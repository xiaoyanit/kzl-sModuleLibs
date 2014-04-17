package com.kzl.lib.http.client;

import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;

import cn.trinea.android.common.entity.HttpRequest;
import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

/**
 * Created by Administrator on 14-3-19.
 */
public class SyncHttpClient {

    public static <T extends EmptyHttpResponse> T get(final String requestUrl, final Class<T> classOfT, final IHttpResponseFilter filter) {
        HttpResponse response = HttpUtils.httpGet(requestUrl);
        return getResponse(response, classOfT, filter);
    }

    public static <T extends EmptyHttpResponse> T get(final HttpRequest request, final Class<T> classOfT, final IHttpResponseFilter filter) {
        HttpResponse response = HttpUtils.httpGet(request);
        return getResponse(response, classOfT, filter);
    }

    public static <T extends EmptyHttpResponse> T post(final String requestUrl, final Class<T> classOfT, final IHttpResponseFilter filter) {
        HttpResponse response = HttpUtils.httpPost(requestUrl);
        return getResponse(response, classOfT, filter);
    }

    public static <T extends EmptyHttpResponse> T post(final HttpRequest request, final Class<T> classOfT, final IHttpResponseFilter filter) {
        HttpResponse response = HttpUtils.httpPost(request);
        return getResponse(response, classOfT, filter);
    }

    private static <T extends EmptyHttpResponse> T getResponse(HttpResponse response, final Class<T> classOfT, final IHttpResponseFilter filter) {
        return HttpCommonUtil.onFinish(response, classOfT, null, filter);
    }
}
