package com.weibo.neihanduanzi.mvp.view.fragment;


import android.support.v4.app.Fragment;

import com.weibo.neihanduanzi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFragment extends BaseFragment {

    public static final String TAG = MyFragment.class.getSimpleName();

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

}
