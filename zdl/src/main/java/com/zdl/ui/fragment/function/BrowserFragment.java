package com.zdl.ui.fragment.function;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.zdl.R;
import com.zdl.iview.BrowserInterface;
import com.zdl.presenter.BrowserPresenter;
import com.zdl.ui.base.ContainerActivity;
import com.zdl.ui.base.MvpBaseFragment;

import butterknife.BindView;

/**
 * Created by bayin on 2016/11/30.
 */

public class BrowserFragment extends MvpBaseFragment<BrowserInterface, BrowserPresenter> implements BrowserInterface {
    @BindView(R.id.webview_progress)
    ProgressBar mProgressBar;
    @BindView(R.id.webview)
    WebView mWebView;
    private static String sUrl = "";
    public static String URL_KEY = "url_key";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BrowserPresenter createPresenter() {
        return new BrowserPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_browser;
    }

    @Override
    protected void initView(View inflate, Bundle savedInstanceState) {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("xx", "shouldOverrideUrlLoading：" + url);
                mWebView.loadUrl(url);
                return true;
            }

        });
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) mProgressBar.setVisibility(View.GONE);
                else mProgressBar.setVisibility(View.VISIBLE);
                mProgressBar.setProgress(newProgress);
            }
        });
        //initdata
        mPresenter.loadData();
    }


    public static void launch(Activity from, Bundle bundle) {
        if (bundle != null) {
            sUrl = (String) bundle.get(URL_KEY);
            ContainerActivity.launch(from, BrowserFragment.class, bundle);
        }
    }

    @Override
    public void loadHtml() {
        if (!TextUtils.isEmpty(sUrl))
            mWebView.loadUrl(sUrl);
    }
}
