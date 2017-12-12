package com.weibo.neihanduanzi.feature.dagger.component;

import com.weibo.neihanduanzi.feature.dagger.module.OkHttpModule;
import com.weibo.neihanduanzi.feature.glide.integration.OkHttpLibraryGlideModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/12.
 */
@Singleton
@Component(modules = {OkHttpModule.class})
public interface OkHttpComponent {
    void inject(OkHttpLibraryGlideModule module);
}
