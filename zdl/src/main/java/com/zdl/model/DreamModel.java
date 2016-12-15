package com.zdl.model;


import com.zdl.apiservice.DreamService;
import com.zdl.bean.DreamResultBean;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by bayin on 2016/12/5.
 */

public class DreamModel extends BaseModel {
    public void api_dream(String keyword, Observer<DreamResultBean> observer){
        mRetrofit.create(DreamService.class).apiSearchDream(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
