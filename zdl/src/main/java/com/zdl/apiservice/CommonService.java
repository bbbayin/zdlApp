package com.zdl.apiservice;

import com.zdl.bean.FunBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bayin on 2016/12/6.
 */

public interface CommonService{
    @GET("{path}/")
    Observable<FunBean> apiCommonRequest(@Path("path") String path, @Query("page") int page, @Query("num") int num);
}
