package com.weibo.neihanduanzi.mvp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.weibo.neihanduanzi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EssenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EssenceFragment extends BaseFragment{

    public EssenceFragment() {
        // Required empty public constructor
    }

    public static EssenceFragment newInstance() {
        EssenceFragment fragment = new EssenceFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_essence;
    }
}
