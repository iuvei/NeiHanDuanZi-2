package com.weibo.neihanduanzi.mvp.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.jakewharton.rxbinding2.widget.RxRadioGroup;
import com.weibo.neihanduanzi.R;
import com.weibo.neihanduanzi.mvp.view.fragment.AttentionFragment;
import com.weibo.neihanduanzi.mvp.view.fragment.DiscoveryFragment;
import com.weibo.neihanduanzi.mvp.view.fragment.DuanYouXiuFragment;
import com.weibo.neihanduanzi.mvp.view.fragment.HomeFragment;
import com.weibo.neihanduanzi.mvp.view.fragment.MyFragment;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by wxjqgt on 2017/12/6.
 */

public class MainActivity extends BaseActivity {

    private FragmentManager fm;
    private Fragment lastFragment;
    private int lastCheckId;
    private RadioGroup rb_bottom_navbar;

    @Override
    protected void findView() {
        rb_bottom_navbar = findViewById(R.id.bottom_navbar);
    }

    @Override
    protected void listener() {
        fm = getSupportFragmentManager();
        RxRadioGroup.checkedChanges(rb_bottom_navbar)
                .compose(this.<Integer>bindToLifecycle())
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        /**
                         * R.id.rb_add 是发文章按钮的id，也就是下方导航栏的大＋按钮
                         *
                         * 需要过滤掉这个ID的响应，不需要显示fragment
                         * 也不需要被选中，所以需要记下上一次选中的ID，作恢复处理
                         *
                         * @return 返回true表示通过，false表示拦截不给通过
                         */
                        boolean filter = integer.intValue() != R.id.rb_add;
                        if (!filter) {
                            rb_bottom_navbar.check(lastCheckId);
                        } else {
                            lastCheckId = integer.intValue();
                        }
                        return filter;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        String tag = HomeFragment.TAG;
                        Fragment fragment = fm.findFragmentByTag(tag);
                        int id = integer.intValue();
                        rb_bottom_navbar.check(id);
                        FragmentTransaction ft = fm.beginTransaction();
                        if (lastFragment != null) {
                            ft.hide(lastFragment);
                        }
                        switch (id) {
                            case R.id.rb_home:
                                if (fragment != null) {
                                    ft.show(fragment);
                                } else {
                                    fragment = HomeFragment.newInstance();
                                    ft.add(R.id.fragment, fragment, tag);
                                }
                                break;
                            case R.id.rb_duanyouxiu:
                                tag = AttentionFragment.TAG;
                                fragment = fm.findFragmentByTag(tag);
                                if (fragment != null) {
                                    ft.show(fragment);
                                } else {
                                    fragment = DuanYouXiuFragment.newInstance();
                                    ft.add(R.id.fragment, fragment, tag);
                                }
                                break;
                            case R.id.rb_discover:
                                tag = DiscoveryFragment.TAG;
                                fragment = fm.findFragmentByTag(tag);
                                if (fragment != null) {
                                    ft.show(fragment);
                                } else {
                                    fragment = DiscoveryFragment.newInstance();
                                    ft.add(R.id.fragment, fragment, tag);
                                }
                                break;
                            case R.id.rb_my:
                                tag = MyFragment.TAG;
                                fragment = fm.findFragmentByTag(tag);
                                if (fragment != null) {
                                    ft.show(fragment);
                                } else {
                                    fragment = MyFragment.newInstance();
                                    ft.add(R.id.fragment, fragment, tag);
                                }
                                break;
                            default:
                                break;
                        }
                        ft.commit();
                        lastFragment = fragment;
                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
