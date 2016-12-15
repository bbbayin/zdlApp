package com.zdl.intercepter;

import com.zdl.constant.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by bayin on 2016/11/30.
 */

public class CommonIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        long t1 = System.nanoTime();
        HttpUrl.Builder builder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .addQueryParameter("key", Constants.HTTP_KEY);
        Request newRequest = oldRequest.newBuilder().method(oldRequest.method(), oldRequest.body())
                .url(builder.build())
                .build();
//        Log.d("ZDL-APP[http result", "\nMethod:" + newRequest.method() + "\n"
//                + "URL:" + newRequest.url() + "\n"
//                + "HTTPS:" + newRequest.isHttps() + "]");
        System.out.println(String.format("发送请求: [%s] %s%n%s",
                oldRequest.url(), chain.connection(), oldRequest.headers()));
        Response proceed = chain.proceed(newRequest);

        long t2 = System.nanoTime();
        ResponseBody responseBody = proceed.peekBody(1024 * 1024);
        System.out.println(String.format("接收响应: [%s] %n返回json:【%s】 %.1fms%n%s",
                proceed.request().url(),
                responseBody.string(),
                (t2 - t1) / 1e6d,
                proceed.headers()));

        return proceed;
    }
}
