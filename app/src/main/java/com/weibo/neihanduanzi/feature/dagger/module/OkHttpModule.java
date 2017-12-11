package com.weibo.neihanduanzi.feature.dagger.module;

import com.weibo.neihanduanzi.util.OkHttpUtil;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/12/12.
 */

@Module
public class OkHttpModule {
    @Provides
    public OkHttpClient providesOkHttpCliet(){
        return OkHttpUtil.get();
    }
}
