package com.kzl.lib.http.client;

import android.os.AsyncTask;


import com.kzl.lib.http.client.callback.IHttpExecute;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;

import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

/**
 * Created by kzl on 14-3-19.
 */
public class AsyncHttpClient {
    /**
     * 通过同步的http 请求，自己实现异步，具体请求子类实现
     *
     * @param classOfT
     * @param handler
     * @param httpExecute
     * @param <T>
     */
    public static <T extends EmptyHttpResponse> void execute(final Class<T> classOfT,
                                                             final IHttpResponseHandler handler, final IHttpExecute httpExecute, final IHttpResponseFilter filter) {
        new AsyncTask<Void, Void, HttpResponse>() {
            @Override
            protected HttpResponse doInBackground(Void... params) {
                return httpExecute.execute();
            }

            @Override
            protected void onPostExecute(HttpResponse response) {
                super.onPostExecute(response);
                HttpCommonUtil.onFinish(response, classOfT, handler, filter);
            }
        }.execute();
    }

    /**
     * 通过同步的http basePost，自己实现异步
     *
     * @param requestUrl
     * @param classOfT
     * @param handler
     * @param <T>
     */
    public static <T extends EmptyHttpResponse> void post(final String requestUrl, final Class<T> classOfT,
                                                          final IHttpResponseHandler handler, final IHttpResponseFilter filter) {
        execute(classOfT, handler, new IHttpExecute() {
            @Override
            public HttpResponse execute() {
                return HttpUtils.httpPost(requestUrl);
            }
        }, filter);
    }

    /**
     * 通过同步的http get请求，自己实现异步
     *
     * @param requestUrl
     * @param classOfT
     * @param handler
     * @param <T>
     */
    public static <T extends EmptyHttpResponse> void get(final String requestUrl, final Class<T> classOfT,
                                                         final IHttpResponseHandler handler, final IHttpResponseFilter filter) {
        execute(classOfT, handler, new IHttpExecute() {
            @Override
            public HttpResponse execute() {
                return HttpUtils.httpGet(requestUrl);
            }
        }, filter);
    }

    /**
     * 调用http包自带的异步请求
     *
     * @param requestUrl
     * @param classOfT
     * @param handler
     * @param <T>
     */
    public static <T extends EmptyHttpResponse> void getAsync(final String requestUrl, final Class<T> classOfT,
                                                              final IHttpResponseHandler handler, final IHttpResponseFilter filter) {
        HttpUtils.httpGet(requestUrl, new HttpUtils.HttpListener() {
            @Override
            protected void onPreGet() {
                super.onPreGet();
            }

            @Override
            protected void onPostGet(HttpResponse response) {
                super.onPostGet(response);
                HttpCommonUtil.onFinish(response, classOfT, handler, filter);
            }
        });
    }


}
