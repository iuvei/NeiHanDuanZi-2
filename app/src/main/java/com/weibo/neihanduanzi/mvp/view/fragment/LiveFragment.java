package com.weibo.neihanduanzi.mvp.view.fragment;


import android.support.v4.app.Fragment;

import com.weibo.neihanduanzi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveFragment extends BaseFragment {


    public LiveFragment() {
        // Required empty public constructor
    }

    public static LiveFragment newInstance() {
        LiveFragment fragment = new LiveFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }
}
