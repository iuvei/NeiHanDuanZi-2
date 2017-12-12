package com.weibo.neihanduanzi.util;

import com.weibo.neihanduanzi.feature.dagger.component.DaggerHttpComponent;
import com.weibo.neihanduanzi.feature.dagger.component.HttpComponent;

/**
 * Created by Administrator on 2017/12/11.
 */

public final class OkHttpUtil {

    private OkHttpUtil() {
    }

    public static HttpComponent build() {
        return OkHttpComponentHelper.httpComponent;
    }

    private final static class OkHttpComponentHelper{
        private final static HttpComponent httpComponent = DaggerHttpComponent.builder().build();
    }

}
