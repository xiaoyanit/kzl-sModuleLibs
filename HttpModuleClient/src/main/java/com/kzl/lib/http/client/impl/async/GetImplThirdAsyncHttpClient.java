package com.kzl.lib.http.client.impl.async;

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
public class GetImplThirdAsyncHttpClient implements IAsyncHttpClient {

    /**
     *
     * @param requestUrl
     * @param request
     * @param classOfT
     * @param handler
     * @param filter
     * @param <T>
     */
    @Override
    public <T extends EmptyHttpResponse> void execute(String requestUrl, EmptyHttpRequest request, final Class<T> classOfT, final IHttpResponseHandler handler, final IHttpResponseFilter filter) {
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
