package com.kzl.lib.http.client.impl.async;

import com.kzl.lib.http.client.callback.IHttpExecute;
import com.kzl.lib.http.client.utils.AsyncHttpUtil;
import com.kzl.lib.http.client.interfaces.IAsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

/**
 * Created by Administrator on 14-4-17.
 * 通过AsyncTask实现的post异步请求
 */
public class PostImplAsyncHttpClient implements IAsyncHttpClient {
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
    public <T extends EmptyHttpResponse> void execute(final String requestUrl, EmptyHttpRequest request, Class<T> classOfT, IHttpResponseHandler handler, IHttpResponseFilter filter) {
        AsyncHttpUtil.execute(classOfT, handler, new IHttpExecute() {
            @Override
            public HttpResponse execute() {
                return HttpUtils.httpPost(requestUrl);
            }
        }, filter);
    }
}
