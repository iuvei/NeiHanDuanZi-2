package com.weibo.neihanduanzi.util;

import com.weibo.neihanduanzi.feature.dagger.component.DaggerOkHttpComponent;
import com.weibo.neihanduanzi.feature.dagger.component.OkHttpComponent;

/**
 * Created by Administrator on 2017/12/11.
 */

public final class OkHttpUtil {

    private OkHttpUtil() {
    }

    public static OkHttpComponent build() {
        return OkHttpComponentHelper.okHttpComponent;
    }

    private final static class OkHttpComponentHelper{
        private final static OkHttpComponent okHttpComponent = DaggerOkHttpComponent.builder().build();
    }

}
