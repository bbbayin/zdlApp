package com.zdl.bean;

import java.util.List;

/**
 * Created by bayin on 2016/12/6.
 */

public class BaseBean<T> {

    /**
     * code : 200
     * msg : success
     * newslist : [{"id":"139","quest":".一架空调器从楼掉下来会变成啥器？","result":"凶器"}]
     */

    private int code;
    private String msg;
    /**
     * id : 139
     * quest : .一架空调器从楼掉下来会变成啥器？
     * result : 凶器
     */

    private List<T> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<T> newslist) {
        this.newslist = newslist;
    }
}
