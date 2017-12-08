package com.weibo.neihanduanzi.fragment;


import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import com.jakewharton.rxbinding2.widget.RxRadioGroup;
import com.weibo.neihanduanzi.R;
import com.weibo.neihanduanzi.util.SnackbarUtils;

import io.reactivex.functions.Consumer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

    public static final String TAG = HomeFragment.class.getSimpleName();
    private RadioGroup rg_top_nav;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void findView() {
        rg_top_nav = find(R.id.rg_top_nav);
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

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

}
