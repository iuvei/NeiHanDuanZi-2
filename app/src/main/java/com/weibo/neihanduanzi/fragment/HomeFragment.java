package com.weibo.neihanduanzi.fragment;


import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioGroup;

import com.jakewharton.rxbinding2.widget.RxRadioGroup;
import com.weibo.neihanduanzi.R;
import com.weibo.neihanduanzi.activity.MainActivity;
import com.weibo.neihanduanzi.adapter.NavViewPagerFragmentAdapter;

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

import io.reactivex.functions.Consumer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

    public static final String TAG = HomeFragment.class.getSimpleName();
    private List<String> titleDataList;
    private MainActivity mainActivity;
    private RadioGroup rg_top_nav;
    private MagicIndicator home_top_indicator;
    private ViewPager home_viewpager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void findView() {
        home_viewpager = find(R.id.home_viewpager);
        rg_top_nav = find(R.id.rg_top_nav);
        home_top_indicator = find(R.id.home_top_indicator);
    }

    @Override
    protected void listener() {
        RxRadioGroup.checkedChanges(rg_top_nav)
                .compose(this.<Integer>bindToLifecycle())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        int id = integer.intValue();
                        rg_top_nav.check(id);
                        switch (id) {
                            case R.id.rb_featured:
                                break;
                            case R.id.rb_attention:
                                break;
                            default:
                                break;
                        }
                    }
                });
    }

    @Override
    protected void loadData() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(RecommendFragment.newInstance());
        fragmentList.add(VideoFragment.newInstance());
        fragmentList.add(DuanYouXiuFragment.newInstance());
        fragmentList.add(ImageFragment.newInstance());
        fragmentList.add(DuanZiFragment.newInstance());
        fragmentList.add(FeaturedFragment.newInstance());
        fragmentList.add(SameCityFragment.newInstance());
        home_viewpager.setAdapter(new NavViewPagerFragmentAdapter(fragmentList, getFragmentManager()));

        titleDataList = new ArrayList<>();
        titleDataList.add("推荐");
        titleDataList.add("视频");
        titleDataList.add("段友秀");
        titleDataList.add("图片");
        titleDataList.add("段子");
        titleDataList.add("精华");
        titleDataList.add("同城");
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
                        Snackbar.make(rg_top_nav, "" + index, Snackbar.LENGTH_SHORT).show();
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
