package com.weibo.neihanduanzi.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/12/6.
 */

public class NeiHanDuanZiApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    public static Context getContext(){
        return context;
    }
}
