package com.zdl.bean;

/**
 * Created by bayin on 2016/12/2.
 */

public class HomeLableBean {
    private String lableTitle;
    private String subTitle;
    private int resId;
    private String fragmentName;

    public String getFragmentName() {
        return fragmentName;
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
    }

    public String getLableTitle() {
        return lableTitle;
    }

    public void setLableTitle(String lableTitle) {
        this.lableTitle = lableTitle;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
