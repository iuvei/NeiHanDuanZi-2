package com.weibo.neihanduanzi.mvp.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.jakewharton.rxbinding2.widget.RxRadioGroup;
import com.weibo.neihanduanzi.R;
import com.weibo.neihanduanzi.mvp.view.fragment.AuditFragment;
import com.weibo.neihanduanzi.mvp.view.fragment.DiscoveryFragment;
import com.weibo.neihanduanzi.mvp.view.fragment.HomeFragment;
import com.weibo.neihanduanzi.mvp.view.fragment.MsgFragment;

import io.reactivex.functions.Consumer;

/**
 * Created by wxjqgt on 2017/12/6.
 */

public class MainActivity extends BaseActivity {

    private FragmentManager fm;
    private Fragment lastFragment;
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
                            case R.id.rb_audit:
                                tag = AuditFragment.TAG;
                                fragment = fm.findFragmentByTag(tag);
                                if (fragment != null) {
                                    ft.show(fragment);
                                } else {
                                    fragment = AuditFragment.newInstance();
                                    ft.add(R.id.fragment, fragment, tag);
                                }
                                break;
                            case R.id.rb_message:
                                tag = MsgFragment.TAG;
                                fragment = fm.findFragmentByTag(tag);
                                if (fragment != null) {
                                    ft.show(fragment);
                                } else {
                                    fragment = MsgFragment.newInstance();
                                    ft.add(R.id.fragment, fragment, tag);
                                }
                                break;
                            default:
                                break;
                        }
                        lastFragment = fragment;
                        ft.commit();
                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
