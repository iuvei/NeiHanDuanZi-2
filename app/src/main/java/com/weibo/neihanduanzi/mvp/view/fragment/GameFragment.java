package com.weibo.neihanduanzi.mvp.view.fragment;

import com.weibo.neihanduanzi.R;

public class GameFragment extends BaseFragment {

    public GameFragment() {
        // Required empty public constructor
    }

    public static GameFragment newInstance() {
        GameFragment fragment = new GameFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_game;
    }
}
