package com.weibo.neihanduanzi.bean.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 * home页面的顶部导航栏tabs
 */

public class Home_Top_Tabs {

    /**
    *  "message": "success",
    *  "data": []
    */

    private String message;

    @SerializedName("data")
    private List<Tab> tabs;

    public Home_Top_Tabs() {
    }

    public Home_Top_Tabs(String message, List<Tab> tabs) {
        this.message = message;
        this.tabs = tabs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
    }

    @Override
    public String toString() {
        return "Home_Top_Tab{" +
                "message='" + message + '\'' +
                ", tabs=" + tabs +
                '}';
    }
}
