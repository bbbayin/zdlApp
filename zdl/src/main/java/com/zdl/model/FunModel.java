package com.zdl.model;

import com.zdl.apiservice.FunService;
import com.zdl.bean.FunBean;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by bayin on 2016/11/29.
 */

public class FunModel extends BaseModel{
    public FunModel() {
        super();
    }

    public void api_fun(int page, int num, Observer<FunBean> observable){
        FunService funService = mRetrofit.create(FunService.class);
        funService.apiFunNews(page, num)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);
    }
}
