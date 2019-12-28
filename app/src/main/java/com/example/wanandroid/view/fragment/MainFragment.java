package com.example.wanandroid.view.fragment;

import android.os.Bundle;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.wanandroid.R;
import com.example.wanandroid.mvp.BaseFragment;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import com.zhpan.bannerview.BannerViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author hwq
 * @date 2019/12/28.
 * GitHub：
 * Email：
 * Description：首页fragment
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.banner_view) BannerViewPager bannerViewPager;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rlv_main) SwipeRecyclerView rlv_main;

    @Override
    public int getContentViewId() {
        return R.layout.main_fragment;
    }

    @Override
    public void initAllMembersView(Bundle var1) {
        ButterKnife.bind(this, rootView);
    }
}
