package com.weibo.neihanduanzi.activity;

import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding2.widget.RxRadioGroup;
import com.weibo.neihanduanzi.R;
import com.weibo.neihanduanzi.util.SnackbarUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by wxjqgt on 2017/12/6.
 */

public class MainActivity extends BaseActivity {

    private RelativeLayout rl_topbar;
    private RadioGroup rg_top_nav;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findView() {
        rl_topbar = findViewById(R.id.rl_topbar);
        rg_top_nav = findViewById(R.id.rg_top_nav);
    }

    @Override
    protected void listener() {
        RxRadioGroup.checkedChanges(rg_top_nav)
                .compose(this.<Integer>bindToLifecycle())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        int id = integer.intValue();
                        rg_top_nav.check(id);
                        switch (id){
                            case R.id.rb_featured:
                                //Snackbar.make(rl_topbar,"hhh",Snackbar.LENGTH_LONG).show();
                                SnackbarUtils.with(rg_top_nav).setMessage("featured").setDuration(SnackbarUtils.LENGTH_SHORT).show();
                                break;
                            case R.id.rb_attention:
                                SnackbarUtils.with(rg_top_nav).setMessage("attention").setDuration(SnackbarUtils.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }
                });

    }
}
