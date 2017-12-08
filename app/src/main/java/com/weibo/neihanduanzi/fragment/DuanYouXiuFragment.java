package com.weibo.neihanduanzi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weibo.neihanduanzi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DuanYouXiuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DuanYouXiuFragment extends Fragment {


    public DuanYouXiuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DuanYouXiuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DuanYouXiuFragment newInstance() {
        DuanYouXiuFragment fragment = new DuanYouXiuFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_duan_you_xiu, container, false);
    }

}
