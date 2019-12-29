package com.example.wanandroid.model;

import android.content.Context;

import com.example.wanandroid.Interface.IBaseCallBack;
import com.example.wanandroid.bean.MainBannerBean;
import com.example.wanandroid.bean.MainBannerListBean;
import com.example.wanandroid.bean.ResultBean;
import com.example.wanandroid.config.UnifiedService;
import com.example.wanandroid.mvp.RXModel;
import com.example.wanandroid.network.MyObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author hwq
 * @date 2019/12/29.
 * GitHub：
 * Email：
 * Description：
 */
public class MainModel extends RXModel {

    public MainModel(Context context) {
        super(context);
    }

    /**
     * 获得首页轮播图列表
     * @param iBaseCallBack
     */
    public void getBannerList(final IBaseCallBack<MainBannerListBean> iBaseCallBack) {
        getServices(UnifiedService.class, PROJECT_TYPE.WANANDROID)
                .getBannerList("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<MainBannerListBean>(context) {
                    @Override
                    public void succeed(MainBannerListBean bannerListBean) {
                        iBaseCallBack.onSuccess(bannerListBean);
                    }

                    @Override
                    public void failed(ResultBean resultBean) {
                        iBaseCallBack.onFailure(resultBean);
                    }

                    @Override
                    public void error(Throwable e) {
                        iBaseCallBack.onError();
                    }
                });
    }

}
