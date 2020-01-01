package com.example.wanandroid.presenter;

import com.example.wanandroid.Interface.IBaseCallBack;
import com.example.wanandroid.Interface.MainView;
import com.example.wanandroid.bean.MainArticleListBean;
import com.example.wanandroid.bean.MainBannerBean;
import com.example.wanandroid.bean.MainBannerListBean;
import com.example.wanandroid.bean.ResultBean;
import com.example.wanandroid.model.MainModel;
import com.example.wanandroid.mvp.BasePresenter;
import com.example.wanandroid.mvp.IBaseView;

/**
 * @author hwq
 * @date 2019/12/29.
 * GitHub：
 * Email：
 * Description：
 */
public class MainPresenter extends BasePresenter {

    private MainView iBaseView;
    private MainModel model;

    public MainPresenter(IBaseView iBaseView) {
        this.iBaseView = (MainView) iBaseView;
        model = new MainModel(iBaseView.getContext());
    }

    /**
     * 获取首页轮播图列表
     */
    public void getBannerList() {
        iBaseView.showLoading();
        model.getBannerList(new IBaseCallBack<MainBannerListBean>() {
            @Override
            public void onSuccess(MainBannerListBean data) {
                iBaseView.hideLoading();
                iBaseView.getBannerList(data);
            }

            @Override
            public void onFailure(ResultBean resultBean) {
                iBaseView.hideLoading();
                iBaseView.showToast(resultBean.getMsg());
            }

            @Override
            public void onError() {
                iBaseView.hideLoading();
                iBaseView.showErr("");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 获取首页文章列表
     */
    public void getMainArticleList(int p) {
        iBaseView.showLoading();
        model.getMainArticleList("" + p, new IBaseCallBack<MainArticleListBean>() {
            @Override
            public void onSuccess(MainArticleListBean data) {
                iBaseView.hideLoading();
                iBaseView.getMainArticleList(data);
            }

            @Override
            public void onFailure(ResultBean resultBean) {
                iBaseView.hideLoading();
                iBaseView.showToast(resultBean.getMsg());
            }

            @Override
            public void onError() {
                iBaseView.hideLoading();
                iBaseView.showErr("");
            }

            @Override
            public void onComplete() {

            }
        });
    }

}
