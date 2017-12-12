package com.weibo.neihanduanzi.feature.dagger.component;

import com.weibo.neihanduanzi.feature.dagger.module.HttpModule;
import com.weibo.neihanduanzi.feature.glide.integration.OkHttpLibraryGlideModule;
import com.weibo.neihanduanzi.fragment.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/12.
 */

@Singleton
@Component(modules = {HttpModule.class})
public interface HttpComponent {
    void inject(OkHttpLibraryGlideModule module);
    void inject(HomeFragment homeFragment);
}
