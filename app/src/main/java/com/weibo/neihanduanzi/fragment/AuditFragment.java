package com.weibo.neihanduanzi.fragment;


import android.support.v4.app.Fragment;

import com.weibo.neihanduanzi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AuditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AuditFragment extends BaseFragment {

    public static final String TAG = AuditFragment.class.getSimpleName();

    public AuditFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_audit;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static AuditFragment newInstance() {
        AuditFragment fragment = new AuditFragment();
        return fragment;
    }

}
