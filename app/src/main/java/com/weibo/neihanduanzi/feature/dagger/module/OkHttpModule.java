package com.weibo.neihanduanzi.feature.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/12/12.
 */

@Module
public class OkHttpModule {
    public OkHttpModule(){}
    @Singleton
    @Provides
    public OkHttpClient providesOkHttpCliet(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        return okHttpClient;
    }
}
