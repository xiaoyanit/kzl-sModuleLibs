package com.kzl.lib.http.client.impl.async;

import android.content.Context;

import com.kzl.lib.http.client.callback.IHttpExecute;
import com.kzl.lib.http.client.interfaces.IAsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.AsyncHttpUtil;
import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.request.Request;
import com.litesuits.http.request.param.HttpMethod;
import com.litesuits.http.response.Response;

/**
 * Created by Administrator on 14-4-17.
 * 通过AsyncTask实现的get异步请求
 */
public class GetImplAsyncHttpClient<T extends EmptyHttpResponse> implements IAsyncHttpClient<T> {
    @Override
    public void execute(final Context context, final String requestUrl, EmptyHttpRequest request, final Class<T> classOfT, IHttpResponseHandler<T> handler, final IHttpResponseFilter filter) {
        AsyncHttpUtil.execute(classOfT, handler, new IHttpExecute() {
            @Override
            public Response execute() {
                return LiteHttpClient.getInstance(context).execute(new Request(requestUrl).setMethod(HttpMethod.Get));
            }
        }, filter);
    }
}
