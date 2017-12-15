package com.weibo.neihanduanzi.mvp.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import com.jakewharton.rxbinding2.widget.RxRadioGroup;
import com.weibo.neihanduanzi.R;

import io.reactivex.functions.Consumer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiscoveryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoveryFragment extends BaseFragment {

    public static final String TAG = DiscoveryFragment.class.getSimpleName();
    private RadioGroup rg_top_nav;

    public DiscoveryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                                break;
                            case R.id.rb_attention:
                                break;
                            default:
                                break;
                        }
                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static DiscoveryFragment newInstance() {
        DiscoveryFragment fragment = new DiscoveryFragment();
        return fragment;
    }

}
