package com.kzl.lib.http.client.impl.async;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.IAsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;

import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

/**
 * Created by Administrator on 14-4-17.
 * 使用第三方实现get方式异步请求
 */
public class GetImplInnerAsyncHttpClient<T extends EmptyHttpResponse> implements IAsyncHttpClient<T> {

    @Override
    public void execute(Context context, String requestUrl, EmptyHttpRequest request, final Class<T> classOfT, final IHttpResponseHandler<T> handler, final IHttpResponseFilter filter) {
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
