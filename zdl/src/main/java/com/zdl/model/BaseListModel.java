package com.zdl.model;

import com.zdl.apiservice.CommonService;
import com.zdl.bean.FunBean;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by bayin on 2016/12/6.
 * <p>
 * 通用的数据模型
 */

public class BaseListModel extends BaseModel {
    private String urlPath;
    public BaseListModel(String path) {
        this.urlPath = path;
    }

    public void api_CommonRequest(int pageNo, int limit, Observer<FunBean> observer) {
        CommonService commonService = mRetrofit.create(CommonService.class);
        commonService.apiCommonRequest(urlPath,pageNo, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}