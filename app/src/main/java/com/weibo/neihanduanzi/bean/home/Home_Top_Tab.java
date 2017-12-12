package com.weibo.neihanduanzi.bean.home;

/**
 * Created by Administrator on 2017/12/12.
 * home页面的顶部导航栏tabs
 */

public class Home_Top_Tab {

    /**
    *  "message": "success",
    *  "data": []
    */

    private String message;
    private Tab[] tabs;

    public Home_Top_Tab() {
    }

    public Home_Top_Tab(String message, Tab[] tabs) {
        this.message = message;
        this.tabs = tabs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tab[] getTabs() {
        return tabs;
    }

    public void setTabs(Tab[] tabs) {
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
