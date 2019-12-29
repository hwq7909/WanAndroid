package com.example.wanandroid.Interface;

import com.example.wanandroid.bean.MainBannerBean;
import com.example.wanandroid.bean.MainBannerListBean;
import com.example.wanandroid.mvp.IBaseView;

/**
 * @author hwq
 * @date 2019/12/29.
 * GitHub：
 * Email：
 * Description：
 */
public interface MainView extends IBaseView {

    /**
     * 获得首页轮播图列表
     * @param bannerListBean
     */
    void getBannerList(MainBannerListBean bannerListBean);

}
