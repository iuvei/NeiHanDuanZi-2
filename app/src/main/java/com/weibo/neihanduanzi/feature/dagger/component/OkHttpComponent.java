package com.weibo.neihanduanzi.feature.dagger.component;

import com.weibo.neihanduanzi.feature.dagger.module.OkHttpModule;
import com.weibo.neihanduanzi.feature.glide.integration.OkHttpStreamFetcher;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/12.
 */

@Component(modules = OkHttpModule.class)
public interface OkHttpComponent {
    void inject(OkHttpStreamFetcher okHttpStreamFetcher);
}
