package com.kzl.lib.http.task.interfaces.async.impl;

import android.content.Context;
import com.kzl.lib.http.client.interfaces.IAsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IAsyncHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.http.client.utils.HttpCommonUtil;
import com.kzl.lib.http.task.interfaces.GPConstantValues;
import com.kzl.lib.http.task.interfaces.async.AsyncHttpExecutor;
import com.kzl.lib.http.task.interfaces.async.IAsyncHttpTask;
import com.kzl.lib.utils.LogUtil;
import com.kzl.lib.utils.Utils;

/**
 * Project:LuLuModuleLibs<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class ImplAsyncHttpTask<T extends EmptyHttpResponse> implements IAsyncHttpTask {
    private final static String LOG_TAG = GPConstantValues.LOG_TAG;
    protected Context context;
    private IAsyncHttpClient asyncHttpClient;
    private IAsyncHttpResponseHandler<T> iAsyncHttpResponseHandler;
    private long start;

    public ImplAsyncHttpTask(Context context, IAsyncHttpClient asyncHttpClient, IAsyncHttpResponseHandler<T> iAsyncHttpResponseHandler) {
        this.context = context;
        this.asyncHttpClient = asyncHttpClient;
        this.iAsyncHttpResponseHandler = iAsyncHttpResponseHandler;
    }

    /**
     * 响应的handler，处理http请求响应的结果
     */
    public final IHttpResponseHandler<T> handler = new IHttpResponseHandler<T>() {

        @Override
        public void onFinish(T response) {
            long end = System.currentTimeMillis();
            LogUtil.trace(LOG_TAG + "  start-end ==" + (end - start));
            if (response == null) {
                iAsyncHttpResponseHandler.onNoData();
            } else {
                iAsyncHttpResponseHandler.onSuccess(response);
            }
            iAsyncHttpResponseHandler.onFinish();
        }
    };

    /**
     * http异步请求执行前的准备
     *
     * @param url
     * @param request
     * @param executor
     */
    private void filter(final String url, final EmptyHttpRequest request, final AsyncHttpExecutor executor) {
        LogUtil.trace(LOG_TAG, "json-request async:" + url);
        LogUtil.trace(LOG_TAG, "request-actionCode:" + request.getActionCode());
        if (!Utils.isNetWorkAvailable(context)) {
            iAsyncHttpResponseHandler.onNoNet();
            return;
        }
        iAsyncHttpResponseHandler.onStart();
        start = System.currentTimeMillis();
        executor.execute();
    }

    @Override
    public void execute(final Context context, final String url, final EmptyHttpRequest request, final HttpResponseMapper mapper, final IHttpResponseFilter filter) {
        filter(url, request, new AsyncHttpExecutor() {
            @Override
            public void execute() {
                asyncHttpClient.execute(context, url, request, HttpCommonUtil.getResponseClassType(mapper, request), handler, filter);
            }
        });
    }
}
