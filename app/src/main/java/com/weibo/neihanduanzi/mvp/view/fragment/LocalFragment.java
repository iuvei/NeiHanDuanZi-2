package com.weibo.neihanduanzi.mvp.view.fragment;


import android.support.v4.app.Fragment;

import com.weibo.neihanduanzi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocalFragment extends BaseFragment {

    public LocalFragment() {
        // Required empty public constructor
    }

    public static LocalFragment newInstance() {
        LocalFragment fragment = new LocalFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_local;
    }
}
