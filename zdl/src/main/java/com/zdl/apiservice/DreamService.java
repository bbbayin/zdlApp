package com.zdl.apiservice;

import com.zdl.bean.DreamResultBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bayin on 2016/12/5.
 */

public interface DreamService {
    @GET("txapi/dream/")
    Observable<DreamResultBean> apiSearchDream(@Query("word") String keyword);
}
