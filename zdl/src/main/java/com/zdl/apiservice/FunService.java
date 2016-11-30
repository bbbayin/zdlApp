package com.zdl.apiservice;

import com.zdl.bean.FunBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bayin on 2016/11/30.
 */

public interface FunService {
    @GET("huabian/")
    Observable<FunBean> apiFunNews(@Query("page") int page, @Query("num") int num);
}
