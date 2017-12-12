package com.weibo.neihanduanzi.feature.dagger.module;

import com.weibo.neihanduanzi.Constant;
import com.weibo.neihanduanzi.api.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/12.
 */

@Module
public class HttpModule {

    public HttpModule() {
    }

    @Singleton
    @Provides
    public OkHttpClient providesOkHttpCliet() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }

    @Singleton
    @Provides
    public ApiService providesApiService(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(Constant.BASE_URL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }

}
