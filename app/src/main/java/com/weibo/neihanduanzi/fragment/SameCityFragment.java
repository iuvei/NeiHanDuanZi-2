package com.weibo.neihanduanzi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weibo.neihanduanzi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SameCityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SameCityFragment extends Fragment {

    public SameCityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SameCityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SameCityFragment newInstance() {
        SameCityFragment fragment = new SameCityFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_same_city, container, false);
    }

}
