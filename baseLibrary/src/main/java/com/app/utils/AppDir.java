package com.app.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class AppDir {

    public static final String TAG = AppDir.class.getName();

    private static Context mContext;

    enum Type {
        CACHE,FILE;
    }

    public static String APP_CACHE = "";//   /storage/emulated/0/Android/data/{package}/cache/
    public static String IMAGE = "";//       /storage/emulated/0/Android/data/{package}/cache/image
    public static String CAMERA = "";//      /storage/emulated/0/Android/data/{package}/cache/camera
    public static String GIF = "";//         /storage/emulated/0/Android/data/{package}/cache/gif
    public static String FUND = "";//        /storage/emulated/0/Android/data/{package}/cache/fund
    public static String CRASH = "";//       /storage/emulated/0/Android/data/{package}/files/crash
    public static String PLAYER = "";//      /storage/emulated/0/Android/data/{package}/files/player
    public static String P2P = "";//         /storage/emulated/0/Android/data/{package}/files/p2p
    public static String DOWNLOAD = "";//    /storage/emulated/0/Android/data/{package}/files/download或者自定义的目录

    public static AppDir getInstance(Context mContext){
        AppDir appDir = new AppDir();
        AppDir.mContext = mContext;
        initDatas();
        return appDir;
    }

    private static void initDatas(){
        APP_CACHE = createPath("APP_CACHE", 0, "", Type.CACHE);
        IMAGE =createPath("IMAGE", 1, "image", Type.CACHE);
        CAMERA = createPath("CAMERA", 2, "camera", Type.CACHE);
        GIF = createPath("GIF", 3, "gif", Type.CACHE);
        FUND = createPath("FUND", 4, "fund", Type.CACHE);
        CRASH = createPath("CRASH", 5, "crash", Type.FILE);
        PLAYER = createPath("PLAYER", 6, "player", Type.FILE);
        P2P = createPath("P2P", 8, "p2p", Type.FILE);
        DOWNLOAD = createDownloadPath();
    }

    private static String createPath(String name, int index, String subpath, Type p) {
        String cachePath = mContext.getExternalCacheDir() + File.separator;//一般存放臨時緩存數據
        String filePath = mContext.getExternalFilesDir(null) + File.separator;//一般放一些長時間保存的數據
        String path = p == Type.CACHE ? cachePath + subpath : filePath + subpath;

        Log.e(TAG,"{AppDir}name="+name+";path="+path);
        FileUtils.makeDirs(path);//創建目錄
        return path;
    }

    private static String createDownloadPath() {
        String path = "";
        // 判斷sd卡是否存在
        boolean sdCardExit = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        Log.e(TAG,"{AppDir}sdCardExit="+sdCardExit);
        if (sdCardExit) {
            if(Build.VERSION.SDK_INT >= 19) {//如果版本大於19，則直接在緩存目錄中創建download目錄
                File[] files = mContext.getExternalFilesDirs("download");
                if(files != null && files.length >= 1 && files[0] != null) {
                    path = files[0].getAbsolutePath();//  /storage/emulated/0/Android/data/{package}/files/download
                }
            }else {
                path = Environment.getExternalStorageDirectory() + File.separator + "why/download";//使用自定義的download目錄
            }
        }else{
            path = Environment.getDataDirectory() + File.separator + "why/download";//使用自定義的download目錄
        }
        Log.e(TAG,"{AppDir}DOWNLOAD"+";path="+path);
        FileUtils.makeDirs(path);//創建目錄
        return path;
    }


}

