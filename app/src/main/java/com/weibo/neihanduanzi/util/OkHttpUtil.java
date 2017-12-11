package com.weibo.neihanduanzi.util;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/12/11.
 */

public final class OkHttpUtil {

    private OkHttpUtil() {
    }

    public static OkHttpClient get(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3000, TimeUnit.SECONDS)
                .readTimeout(3000, TimeUnit.SECONDS)
                .writeTimeout(3000, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }

}
