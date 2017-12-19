package com.weibo.neihanduanzi.api;

import com.weibo.neihanduanzi.bean.home.Home_Top_Tabs;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/12/12.
 * @author weibo
 */

public interface ApiService {
    /**
     * 获取首页的顶部导航栏信息，包括推荐，图片，段友秀等
     * @return
     */
    @GET("neihan/service/tabs")
    Observable<Home_Top_Tabs> getTabs();
}
