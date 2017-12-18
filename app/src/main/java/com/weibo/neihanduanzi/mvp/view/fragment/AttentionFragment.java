package com.weibo.neihanduanzi.mvp.view.fragment;


import android.support.v4.app.Fragment;

import com.weibo.neihanduanzi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AttentionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AttentionFragment extends BaseFragment {

    public static final String TAG = AttentionFragment.class.getSimpleName();

    public AttentionFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_attention;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static AttentionFragment newInstance() {
        AttentionFragment fragment = new AttentionFragment();
        return fragment;
    }

}
