package com.example.wanandroid.config;

import com.example.wanandroid.bean.MainArticleInfoBean;
import com.example.wanandroid.bean.MainArticleListBean;
import com.example.wanandroid.bean.MainBannerBean;
import com.example.wanandroid.bean.MainBannerListBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UnifiedService {

    @FormUrlEncoded
    @POST("banner/json")
    Observable<MainBannerListBean> getBannerList(@Field("a") String a);

    @GET("/article/list/{p}/json")
    Observable<MainArticleInfoBean> getMainArticleList(@Path("p") String p);

}
