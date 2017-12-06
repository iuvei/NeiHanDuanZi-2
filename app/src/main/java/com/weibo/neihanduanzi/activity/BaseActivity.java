package com.weibo.neihanduanzi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by Administrator on 2017/12/6.
 */

public class BaseActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findView();
        listener();
        loadData();
    }
    protected void findView(){}
    protected void listener(){}
    protected void loadData(){}

}
