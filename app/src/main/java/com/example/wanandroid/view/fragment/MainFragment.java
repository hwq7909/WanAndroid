package com.example.wanandroid.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.wanandroid.Interface.MainView;
import com.example.wanandroid.R;
import com.example.wanandroid.bean.MainBannerBean;
import com.example.wanandroid.bean.MainBannerListBean;
import com.example.wanandroid.mvp.BaseFragment;
import com.example.wanandroid.presenter.MainPresenter;
import com.example.wanandroid.utils.log;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.constants.IndicatorGravity;
import com.zhpan.bannerview.holder.ViewHolder;
import com.zhpan.bannerview.utils.BannerUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author hwq
 * @date 2019/12/28.
 * GitHub：
 * Email：
 * Description：首页fragment
 */
public class MainFragment extends BaseFragment implements MainView {

    @BindView(R.id.banner_view) BannerViewPager bannerViewPager;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rlv_main) SwipeRecyclerView rlv_main;

    private MainPresenter presenter;

    @Override
    public int getContentViewId() {
        return R.layout.main_fragment;
    }

    @Override
    public void initAllMembersView(Bundle var1) {
        ButterKnife.bind(this, rootView);

        initView();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter = new MainPresenter(this);
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initData() {
        presenter.getBannerList();
    }

    private void initView() {
    }

    @Override
    public void getBannerList(MainBannerListBean bannerListBean) {
        bannerViewPager.setInterval(3000)
                .setCanLoop(true)
                .setAutoPlay(true)
                .setIndicatorColor(Color.parseColor("#ffffff"), Color.parseColor("#000000"))
//                .setIndicatorGravity(IndicatorGravity.END)
                .setScrollDuration(1000)
                .setPageMargin(BannerUtils.dp2px(0))
                .setHolderCreator(MainBannerViewHolder::new)
                .setOnPageClickListener(new BannerViewPager.OnPageClickListener() {
                    @Override
                    public void onPageClick(int position) {
                        showToast("click" + position + "item");
                    }
                }).create(bannerListBean.getData());
    }

    public class MainBannerViewHolder implements ViewHolder<MainBannerBean> {
        @Override
        public int getLayoutId() {
            return R.layout.main_banner_item;
        }

        @Override
        public void onBind(View itemView, MainBannerBean data, int position, int size) {
            ImageView imageView = itemView.findViewById(R.id.iv_banner_img);
            TextView textView = itemView.findViewById(R.id.tv_banner_title);
            Glide.with(context)
                    .load(data.getImagePath())
                    .into(imageView);
            textView.setText(data.getTitle());
        }
    }

}
