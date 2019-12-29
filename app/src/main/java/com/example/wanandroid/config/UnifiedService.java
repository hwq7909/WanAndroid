package com.example.wanandroid.config;

import com.example.wanandroid.bean.MainBannerBean;
import com.example.wanandroid.bean.MainBannerListBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UnifiedService {

    @FormUrlEncoded
    @POST("banner/json")
    Observable<MainBannerListBean> getBannerList(@Field("a") String a);

}
