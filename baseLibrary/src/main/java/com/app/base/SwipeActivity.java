package com.app.base;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.app.mylibrary.R;


/**
 * 滑動關閉頁面基類，使用時繼承此類並使用BlankTheme主題即可
 */
public abstract class SwipeActivity extends AppCompatActivity {

    private SwipeLayout swipeLayout;

    /**
     * 是否可以滑動關閉頁面
     */
    protected boolean swipeEnabled = true;

    /**
     * 是否可以在頁面任意位置右滑關閉頁面，如果是false則從左邊滑才可以關閉。
     */
    protected boolean swipeAnyWhere = false;

    public SwipeActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        swipeLayout = new SwipeLayout(this);
    }

    public void setSwipeAnyWhere(boolean swipeAnyWhere) {
        this.swipeAnyWhere = swipeAnyWhere;
    }

    public boolean isSwipeAnyWhere() {
        return swipeAnyWhere;
    }

    public void setSwipeEnabled(boolean swipeEnabled) {
        this.swipeEnabled = swipeEnabled;
    }

    public boolean isSwipeEnabled() {
        return swipeEnabled;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        swipeLayout.replaceLayer(this);
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    private boolean swipeFinished = false;

    @Override
    public void finish() {
        if (swipeFinished) {
            super.finish();
            overridePendingTransition(0, 0);
        } else {
            swipeLayout.cancelPotentialAnimation();
            super.finish();
            overridePendingTransition(0, R.anim.slide_out_right);
        }
    }

    class SwipeLayout extends FrameLayout {

        //private View backgroundLayer;用來設置滑動時的背景色
        private Drawable leftShadow;

        public SwipeLayout(Context context) {
            super(context);
        }

        public SwipeLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public SwipeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        public void replaceLayer(Activity activity) {
            leftShadow = activity.getResources().getDrawable(R.drawable.left_shadow);
            touchSlop = (int) (touchSlopDP * activity.getResources().getDisplayMetrics().density);
            sideWidth = (int) (sideWidthInDP * activity.getResources().getDisplayMetrics().density);
            mActivity = activity;
            screenWidth = getScreenWidth(activity);
            setClickable(true);
            final ViewGroup root = (ViewGroup) activity.getWindow().getDecorView();
            content = root.getChildAt(0);
            ViewGroup.LayoutParams params = content.getLayoutParams();
            ViewGroup.LayoutParams params2 = new ViewGroup.LayoutParams(-1, -1);
            root.removeView(content);
            this.addView(content, params2);
            root.addView(this, params);
        }

        @Override
        protected boolean drawChild(@NonNull Canvas canvas, @NonNull View child, long drawingTime) {
            boolean result = super.drawChild(canvas, child, drawingTime);
            final int shadowWidth = leftShadow.getIntrinsicWidth();
            int left = (int) (getContentX()) - shadowWidth;
            leftShadow.setBounds(left, child.getTop(), left + shadowWidth, child.getBottom());
            leftShadow.draw(canvas);
            return result;
        }

        boolean canSwipe = false;
        /**
         * 超過了touchslop仍然沒有達到沒有條件，則忽略以後的動作
         */
        boolean ignoreSwipe = false;
        View content;
        Activity mActivity;
        int sideWidthInDP = 16;
        int sideWidth = 72;
        int screenWidth = 1080;
        VelocityTracker tracker;

        float downX;
        float downY;
        float lastX;
        float currentX;
        float currentY;

        int touchSlopDP = 20;
        int touchSlop = 60;

        @Override
        public boolean dispatchTouchEvent(@NonNull MotionEvent ev) {
            if (swipeEnabled && !canSwipe && !ignoreSwipe) {
                if (swipeAnyWhere) {
                    switch (ev.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            downX = ev.getX();
                            downY = ev.getY();
                            currentX = downX;
                            currentY = downY;
                            lastX = downX;
                            break;
                        case MotionEvent.ACTION_MOVE:
                            float dx = ev.getX() - downX;
                            float dy = ev.getY() - downY;
                            if (dx * dx + dy * dy > touchSlop * touchSlop) {
                                if (dy == 0f || Math.abs(dx / dy) > 1) {
                                    downX = ev.getX();
                                    downY = ev.getY();
                                    currentX = downX;
                                    currentY = downY;
                                    lastX = downX;
                                    canSwipe = true;
                                    tracker = VelocityTracker.obtain();
                                    return true;
                                } else {
                                    ignoreSwipe = true;
                                }
                            }
                            break;
                    }
                } else if (ev.getAction() == MotionEvent.ACTION_DOWN && ev.getX() < sideWidth) {
                    canSwipe = true;
                    tracker = VelocityTracker.obtain();
                    return true;
                }
            }
            if (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_CANCEL) {
                ignoreSwipe = false;
            }
            return super.dispatchTouchEvent(ev);
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return canSwipe || super.onInterceptTouchEvent(ev);
        }

        boolean hasIgnoreFirstMove;

        @Override
        public boolean onTouchEvent(@NonNull MotionEvent event) {
            if (canSwipe) {
                tracker.addMovement(event);
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        downX = event.getX();
                        downY = event.getY();
                        currentX = downX;
                        currentY = downY;
                        lastX = downX;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        currentX = event.getX();
                        currentY = event.getY();
                        float dx = currentX - lastX;
                        if (dx != 0f && !hasIgnoreFirstMove) {
                            hasIgnoreFirstMove = true;
                            dx = dx / dx;
                        }
                        if (getContentX() + dx < 0) {
                            setContentX(0);
                        } else {
                            setContentX(getContentX() + dx);
                        }
                        lastX = currentX;
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        tracker.computeCurrentVelocity(10000);
                        tracker.computeCurrentVelocity(1000, 20000);
                        canSwipe = false;
                        hasIgnoreFirstMove = false;
                        int mv = screenWidth * 3;
                        if (Math.abs(tracker.getXVelocity()) > mv) {
                            animateFromVelocity(tracker.getXVelocity());
                        } else {
                            if (getContentX() > screenWidth / 3) {
                                animateFinish(false);
                            } else {
                                animateBack(false);
                            }
                        }
                        tracker.recycle();
                        break;
                    default:
                        break;
                }
            }
            return super.onTouchEvent(event);
        }

        ObjectAnimator animator;

        public void cancelPotentialAnimation() {
            if (animator != null) {
                animator.removeAllListeners();
                animator.cancel();
            }
        }

        public void setContentX(float x) {
            int ix = (int) x;
            content.setX(ix);
            invalidate();
        }

        public float getContentX() {
            return content.getX();
        }


        /**
         * 彈回，不關閉，因為left是0，所以setX和setTranslationX效果是一樣的
         *
         * @param withVel 使用計算出來的時間
         */
        private void animateBack(boolean withVel) {
            cancelPotentialAnimation();
            animator = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0);
            int tmpDuration = withVel ? ((int) (duration * getContentX() / screenWidth)) : duration;
            if (tmpDuration < 100) {
                tmpDuration = 100;
            }
            animator.setDuration(tmpDuration);
            animator.setInterpolator(new DecelerateInterpolator());
            animator.start();
        }

        private void animateFinish(boolean withVel) {
            cancelPotentialAnimation();
            animator = ObjectAnimator.ofFloat(this, "contentX", getContentX(), screenWidth);
            int tmpDuration = withVel ? ((int) (duration * (screenWidth - getContentX()) / screenWidth)) : duration;
            if (tmpDuration < 100) {
                tmpDuration = 100;
            }
            animator.setDuration(tmpDuration);
            animator.setInterpolator(new DecelerateInterpolator());
            animator.addListener(new Animator.AnimatorListener() {

                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    if (!mActivity.isFinishing()) {
                        swipeFinished = true;
                        mActivity.finish();
                    }
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }
            });
            animator.start();
        }

        private final int duration = 200;

        private void animateFromVelocity(float v) {
            if (v > 0) {
                if (getContentX() < screenWidth / 3 && v * duration / 1000 + getContentX() < screenWidth / 3) {
                    animateBack(false);
                } else {
                    animateFinish(true);
                }
            } else {
                if (getContentX() > screenWidth / 3 && v * duration / 1000 + getContentX() > screenWidth / 3) {
                    animateFinish(false);
                } else {
                    animateBack(true);
                }
            }

        }
    }

}
