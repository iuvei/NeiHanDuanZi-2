package com.weibo.neihanduanzi.mvp.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;

import com.weibo.neihanduanzi.R;
import com.weibo.neihanduanzi.adapter.NavViewPagerFragmentAdapter;
import com.weibo.neihanduanzi.api.ApiService;
import com.weibo.neihanduanzi.bean.home.Home_Top_Tabs;
import com.weibo.neihanduanzi.bean.home.Tab;
import com.weibo.neihanduanzi.mvp.view.activity.MainActivity;
import com.weibo.neihanduanzi.util.LogUtils;
import com.weibo.neihanduanzi.util.OkHttpUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

    public static final String TAG = HomeFragment.class.getSimpleName();
    private List<String> titleDataList;
    private List<Fragment> fragmentList;
    private MainActivity mainActivity;
    private MagicIndicator home_top_indicator;
    private ViewPager home_viewpager;
    @Inject
    ApiService apiService;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OkHttpUtil.build().inject(this);
    }

    @Override
    protected void findView() {
        home_viewpager = find(R.id.home_viewpager);
        home_top_indicator = find(R.id.home_top_indicator);
    }

    @Override
    protected void listener() {

    }

    @Override
    protected void loadData() {
        fragmentList = new ArrayList<>();
        titleDataList = new ArrayList<>();
        apiService.getTabs()
                .compose(this.<Home_Top_Tabs>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<Home_Top_Tabs, ObservableSource<Tab>>() {
                    @Override
                    public ObservableSource<Tab> apply(Home_Top_Tabs home_top_tabs) throws Exception {
                        return Observable.fromIterable(home_top_tabs.getTabs());
                    }
                })
                .subscribe(new Consumer<Tab>() {
                    @Override
                    public void accept(Tab tab) throws Exception {
                        String name = tab.getName();
                        //titleDataList.add(name);
                        LogUtils.d(name);
                    }
                });

        fragmentList.add(AttentionFragment.newInstance());
        fragmentList.add(RecommendFragment.newInstance());
        fragmentList.add(VideoFragment.newInstance());
        fragmentList.add(LiveFragment.newInstance());
        fragmentList.add(ImageFragment.newInstance());
        fragmentList.add(DuanZiFragment.newInstance());
        fragmentList.add(GameFragment.newInstance());
        fragmentList.add(EssenceFragment.newInstance());

        titleDataList.add("关注");
        titleDataList.add("推荐");
        titleDataList.add("视频");
        titleDataList.add("直播");
        titleDataList.add("图片");
        titleDataList.add("段子");
        titleDataList.add("游戏");
        titleDataList.add("精华");

        home_viewpager.setAdapter(new NavViewPagerFragmentAdapter(fragmentList, getFragmentManager()));

        final CommonNavigator commonNavigator = new CommonNavigator(mainActivity);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return titleDataList == null ? 0 : titleDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.GRAY);
                colorTransitionPagerTitleView.setGravity(Gravity.CENTER);
                colorTransitionPagerTitleView.setSelectedColor(Color.BLACK);
                colorTransitionPagerTitleView.setText(titleDataList.get(index));
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        home_viewpager.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                return indicator;
            }
        });
        //commonNavigator.setAdjustMode(true);
        home_top_indicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(home_top_indicator, home_viewpager);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

}
