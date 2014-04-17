package com.kzl.lib.http.task.interfaces.async;

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
import com.kzl.lib.utils.LogUtil;
import com.kzl.lib.utils.Utils;

/**
 * Created by kzl on 14-3-19.
 * 直接继承EmptyHttResponse则直接调用onNormal，onError将不会被调用
 */
public class ImplAsyncHttpTask<T extends EmptyHttpResponse> implements IAsyncHttpResponseHandler<T>, IAsyncHttpTask {
    private final static String LOG_TAG = GPConstantValues.LOG_TAG;
    protected Context context;
    private IAsyncHttpClient asyncHttpClient;
    private long start;
    @SuppressWarnings("unchecked")
    public final IHttpResponseHandler handler = new IHttpResponseHandler() {

        @Override
        public void onFinish(EmptyHttpResponse response) {
            long end = System.currentTimeMillis();
            LogUtil.trace(LOG_TAG + "  start-end ==" + (end - start));
            if (response == null) {
                onNoData();
            } else {
                onSuccess((T) response);
            }
            ImplAsyncHttpTask.this.onFinish();
        }
    };

    public ImplAsyncHttpTask(Context context, IAsyncHttpClient asyncHttpClient) {
        this.context = context;
        this.asyncHttpClient = asyncHttpClient;
    }

    public ImplAsyncHttpTask(Context context) {
        this.context = context;
    }

    public void filter(final String url, final EmptyHttpRequest request, final IHttpExecutor executor) {
        LogUtil.trace(LOG_TAG, "json-request:" + url);
        LogUtil.trace(LOG_TAG, "request-actionCode:" + request.getActionCode());
        if (!Utils.isNetWorkAvailable(context)) {
            onNoNet();
            return;
        }
        onStart();
        start = System.currentTimeMillis();
        executor.execute();
    }

    @Override
    public void execute(final String url, final EmptyHttpRequest request, final HttpResponseMapper mapper, final IHttpResponseFilter filter) {
        filter(url, request, new IHttpExecutor() {
            @Override
            public void execute() {
                getAsyncHttpClient().execute(url, request, HttpCommonUtil.getResponseClassType(mapper, request), handler, filter);
            }
        });
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onFinish() {
    }

    @Override
    public void onSuccess(T response) {
    }

    @Override
    public void onNoNet() {
    }

    @Override
    public void onNoData() {
    }

    public void setAsyncHttpClient(IAsyncHttpClient asyncHttpClient) {
        this.asyncHttpClient = asyncHttpClient;
    }

    public IAsyncHttpClient getAsyncHttpClient() {
        return asyncHttpClient;
    }
}
