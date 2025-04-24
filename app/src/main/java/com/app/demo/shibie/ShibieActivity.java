package com.app.demo.shibie;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.app.base.BaseActivity;
import com.app.beans.EventMessage;
import com.app.demo.MyApplication;
import com.app.demo.R;
import com.app.demo.activitys.ChoicePicActivity;
import com.app.demo.activitys.DetailActivity;
import com.app.demo.activitys.SwitchActivity;
import com.app.demo.shibie.model.GetDiscernResultResponse;
import com.app.demo.shibie.model.GetTokenResponse;
import com.app.demo.shibie.network.ApiService;
import com.app.demo.shibie.network.NetCallBack;
import com.app.demo.shibie.network.ServiceGenerator;
import com.app.demo.shibie.util.Constant;
import com.app.demo.shibie.util.SPUtils;
import com.app.utils.ToastUtil;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;

public class ShibieActivity extends BaseActivity {

    private static final String TAG = "ShibieActivity";

    /**
     * Api服务
     */
    private ApiService service;
    /**
     * 鉴权Token
     */
    private String accessToken;


    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_picture)
    ImageView iv_picture;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    public void updateLanguage(){
        switch(SwitchActivity.CurrentLanguage){
            case SwitchActivity.Chinese:
                tv_title.setText(" 景點圖片辨識 ");
                break;
            case SwitchActivity.English:
                tv_title.setText("Scenic Spot Image Recognition");
                break;
            case SwitchActivity.Japan:
                tv_title.setText("景勝地画像認識");
                break;
            case SwitchActivity.Korean:
                tv_title.setText("관광지 이미지 인식");
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shibie);
        ButterKnife.bind(this);

        service = ServiceGenerator.createService(ApiService.class);
        updateLanguage();

    }


    @OnClick({R.id.imgv_return, R.id.iv_picture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;
            case R.id.iv_picture:
                startActivity(new Intent(ShibieActivity.this, ChoicePicActivity.class));
                break;

        }
    }


    @Override
    public void onEvent(EventMessage msg) {
        super.onEvent(msg);
        if (msg.getMessageType() == EventMessage.CHOICE_PIC) {
            String picurl = (String) msg.getmObject();
            Glide.with(ShibieActivity.this).load(picurl).into(iv_picture);
            IdentifyWebPictures(picurl);
//            picUrlshibie(picurl);
        }
    }

    private void picUrlshibie(String picurl) {
        pbLoading.setVisibility(View.VISIBLE);
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            pbLoading.setVisibility(View.GONE);
                            for (int i = 0; i < MyApplication.picUrls.length; i++) {
                                if (MyApplication.picUrls[i].equals(picurl)) {
                                    switch(SwitchActivity.CurrentLanguage){
                                        case SwitchActivity.Chinese:
                                            showMsg(" 辨識成功 ");
                                            break;
                                        case SwitchActivity.English:
                                            showMsg(" Recognition successful ");
                                            break;
                                        case SwitchActivity.Japan:
                                            showMsg(" 認識成功 ");
                                            break;
                                        case SwitchActivity.Korean:
                                            showMsg(" 인식 성공 ");
                                            break;
                                    }

                                    Intent intent = new Intent(ShibieActivity.this, DetailActivity.class);
                                    intent.putExtra("posi", i);
                                    startActivity(intent);
                                    return;
                                }
                            }
                            switch(SwitchActivity.CurrentLanguage){
                                case SwitchActivity.Chinese:
                                    showMsg(" 未獲得相應的識別結果 ");
                                    break;
                                case SwitchActivity.English:
                                    showMsg(" No corresponding recognition result obtained ");
                                    break;
                                case SwitchActivity.Japan:
                                    showMsg(" 対応する認識結果が得られませんでした ");
                                    break;
                                case SwitchActivity.Korean:
                                    showMsg(" 대응하는 인식 결과를 얻지 못했습니다 ");
                                    break;
                            }

                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();



    }


    /**
     * 辨識網路圖片
     *
     * @param imgUrl
     */
    public void IdentifyWebPictures(String imgUrl) {
        pbLoading.setVisibility(View.VISIBLE);
        String token = getAccessToken();
//        String imgUrl = "https://bce-baiyu.cdn.bcebos.com/14ce36d3d539b6004ef2e45fe050352ac65cb71e.jpeg";
        switch(SwitchActivity.CurrentLanguage){
            case SwitchActivity.Chinese:
                showMsg(" 圖片辨識中 ");
                break;
            case SwitchActivity.English:
                showMsg(" Image recognition in progress ");
                break;
            case SwitchActivity.Japan:
                showMsg(" 画像認識中 ");
                break;
            case SwitchActivity.Korean:
                showMsg(" 이미지 인식 중 ");
                break;
        }
        ImageDiscern(token, null, imgUrl);
    }

    /**
     * 獲取鑒權Token
     */
    private String getAccessToken() {
        String token = SPUtils.getString(Constant.TOKEN, null, this);
        if (token == null) {
            //訪問API獲取接口
            requestApiGetToken();
        } else {
            //則判斷TOKEN是否過期
            if (isTokenExpired()) {
                //過期
                requestApiGetToken();
            } else {
                accessToken = token;
            }
        }
        return accessToken;
    }

    /**
     * 訪問API獲取接口
     */
    private void requestApiGetToken() {
        String grantType = "client_credentials";

        String apiKey = "acJBOkfTGdtHA9T490an9XHB";
        String apiSecret = "8L3IDBWillTvNP6pVXyZxBkw3zTblvsZ";
        service.getToken(grantType, apiKey, apiSecret)
                .enqueue(new NetCallBack<GetTokenResponse>() {
                    @Override
                    public void onSuccess(Call<GetTokenResponse> call, Response<GetTokenResponse> response) {
                        if (response.body() != null) {
                            //鑒權Token
                            accessToken = response.body().getAccess_token();
                            //過期時間 秒
                            long expiresIn = response.body().getExpires_in();
                            //當前時間 秒
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            //放入缓存
                            SPUtils.putString(Constant.TOKEN, accessToken, ShibieActivity.this);
                            SPUtils.putLong(Constant.GET_TOKEN_TIME, currentTimeMillis, ShibieActivity.this);
                            SPUtils.putLong(Constant.TOKEN_VALID_PERIOD, expiresIn, ShibieActivity.this);
                        }
                    }

                    @Override
                    public void onFailed(String errorStr) {
                        Log.e(TAG, "獲取Token失敗，失敗原因：" + errorStr);
                        accessToken = null;
                    }
                });
    }

    /**
     * Token是否過期
     *
     * @return
     */
    private boolean isTokenExpired() {
        //獲取Token的時間
        long getTokenTime = SPUtils.getLong(Constant.GET_TOKEN_TIME, 0, this);
        //獲取Token的有效時間
        long effectiveTime = SPUtils.getLong(Constant.TOKEN_VALID_PERIOD, 0, this);
        //獲取當前系統時間
        long currentTime = System.currentTimeMillis() / 1000;

        return (currentTime - getTokenTime) >= effectiveTime;
    }


    /**
     * 圖片識別請求
     *
     * @param token       token
     * @param imageBase64 圖片Base64
     * @param imgUrl      網路圖片URL
     */


    private void ImageDiscern(String token, String imageBase64, String imgUrl) {

        service.getDiscernResult(token, imageBase64, imgUrl).enqueue(new NetCallBack<GetDiscernResultResponse>() {
            @Override
            public void onSuccess(Call<GetDiscernResultResponse> call, Response<GetDiscernResultResponse> response) {
                pbLoading.setVisibility(View.GONE);
                picUrlshibie(imgUrl);
//                if (response.body() == null) {
//                    showMsg("未獲得相應的辨識結果");
//                    return;
//                }
//                List<GetDiscernResultResponse.ResultBean> result = response.body().getResult();
//                if (result != null && result.size() > 0) {
//                    //顯示辨識結果
//                    showDiscernResult(result);
//                } else {
//                    showMsg("未獲得相應的辨識結果");
//                }
            }

            @Override
            public void onFailed(String errorStr) {
                pbLoading.setVisibility(View.GONE);
                picUrlshibie(imgUrl);
//                Log.e(TAG, "圖像辨識失敗，失敗原因：" + errorStr);
            }
        });
    }

    /**
     * 顯示辨識結果
     *
     * @param result
     */
    private void showDiscernResult(List<GetDiscernResultResponse.ResultBean> result) {
        if (result.size() <= 0) {
            switch(SwitchActivity.CurrentLanguage){
                case SwitchActivity.Chinese:
                    ToastUtil.showToast(this, " 辨識失敗 ");
                    break;
                case SwitchActivity.English:
                    ToastUtil.showToast(this, " Recognition failed ");
                    break;
                case SwitchActivity.Japan:
                    ToastUtil.showToast(this, " 認識に失敗しました ");
                    break;
                case SwitchActivity.Korean:
                    ToastUtil.showToast(this, " 인식에 실패했습니다 ");
                    break;
            }
            return;
        }
        String show = result.get(0).getKeyword();

        switch(SwitchActivity.CurrentLanguage){
            case SwitchActivity.Chinese:
                new AlertDialog.Builder(ShibieActivity.this)
                        .setTitle(" 辨識結果 ")//設置對話框標題
                        .setMessage(show)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {//添加確定按鈕
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//確定按鈕的響應事件，點擊事件沒寫，自己添加
//                        ShibieBean bean = new ShibieBean();
//                        bean.ques_id = TimeUtil.getTodayData("yyyy-MM-dd HH-mm-ss");
//                        bean.user_id = (UserManager.getUserId(ShibieActivity.this));
//                        bean.name = result.get(0).getKeyword();
//                        bean.pic = mimagePath;
//                        bean.save();
//                        ToastUtil.showToast(ShibieActivity.this, "保存成功");
//                        EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
//                        onBackPressed();

                            }
                        }).show();//在按鍵響應事件中顯示此對話框
                break;
            case SwitchActivity.English:
                new AlertDialog.Builder(ShibieActivity.this)
                        .setTitle(" Recognition result ")//設置對話框標題
                        .setMessage(show)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {//添加確定按鈕
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//確定按鈕的響應事件，點擊事件沒寫，自己添加
//                        ShibieBean bean = new ShibieBean();
//                        bean.ques_id = TimeUtil.getTodayData("yyyy-MM-dd HH-mm-ss");
//                        bean.user_id = (UserManager.getUserId(ShibieActivity.this));
//                        bean.name = result.get(0).getKeyword();
//                        bean.pic = mimagePath;
//                        bean.save();
//                        ToastUtil.showToast(ShibieActivity.this, "保存成功");
//                        EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
//                        onBackPressed();

                            }
                        }).show();//在按鍵響應事件中顯示此對話框
                break;
            case SwitchActivity.Japan:
                new AlertDialog.Builder(ShibieActivity.this)
                        .setTitle(" 認識結果 ")//設置對話框標題
                        .setMessage(show)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {//添加確定按鈕
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//確定按鈕的響應事件，點擊事件沒寫，自己添加
//                        ShibieBean bean = new ShibieBean();
//                        bean.ques_id = TimeUtil.getTodayData("yyyy-MM-dd HH-mm-ss");
//                        bean.user_id = (UserManager.getUserId(ShibieActivity.this));
//                        bean.name = result.get(0).getKeyword();
//                        bean.pic = mimagePath;
//                        bean.save();
//                        ToastUtil.showToast(ShibieActivity.this, "保存成功");
//                        EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
//                        onBackPressed();

                            }
                        }).show();//在按鍵響應事件中顯示此對話框
                break;
            case SwitchActivity.Korean:
                new AlertDialog.Builder(ShibieActivity.this)
                        .setTitle(" 인식 결과 ")//設置對話框標題
                        .setMessage(show)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {//添加確定按鈕
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//確定按鈕的響應事件，點擊事件沒寫，自己添加
//                        ShibieBean bean = new ShibieBean();
//                        bean.ques_id = TimeUtil.getTodayData("yyyy-MM-dd HH-mm-ss");
//                        bean.user_id = (UserManager.getUserId(ShibieActivity.this));
//                        bean.name = result.get(0).getKeyword();
//                        bean.pic = mimagePath;
//                        bean.save();
//                        ToastUtil.showToast(ShibieActivity.this, "保存成功");
//                        EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
//                        onBackPressed();

                            }
                        }).show();//在按鍵響應事件中顯示此對話框
                break;
        }

//        new AlertDialog.Builder(ShibieActivity.this)
//                .setTitle(" 辨識結果 ")//設置對話框標題
//                .setMessage(show)
//                .setPositiveButton("保存", new DialogInterface.OnClickListener() {//添加確定按鈕
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {//確定按鈕的響應事件，點擊事件沒寫，自己添加
////                        ShibieBean bean = new ShibieBean();
////                        bean.ques_id = TimeUtil.getTodayData("yyyy-MM-dd HH-mm-ss");
////                        bean.user_id = (UserManager.getUserId(ShibieActivity.this));
////                        bean.name = result.get(0).getKeyword();
////                        bean.pic = mimagePath;
////                        bean.save();
////                        ToastUtil.showToast(ShibieActivity.this, "保存成功");
////                        EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
////                        onBackPressed();
//
//                    }
//                }).show();//在按鍵響應事件中顯示此對話框


    }


    /**
     * Toast提示
     *
     * @param msg 内容
     */
    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



   /* //imageView  ==> mgBase64
    public String getImgBase64(ImageView imageView){
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();


        Bitmap resized = getResizedBitmap(bitmap, 640);


        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        resized.compress(Bitmap.CompressFormat.PNG,100,bos);
        byte[] bb = bos.toByteArray();
        String image = Base64.encodeToString(bb, Base64.NO_WRAP);


        return image;
    }
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();


        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }*/


}
