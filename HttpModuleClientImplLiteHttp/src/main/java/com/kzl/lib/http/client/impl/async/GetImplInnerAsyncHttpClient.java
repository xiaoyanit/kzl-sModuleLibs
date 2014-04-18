package com.kzl.lib.http.client.impl.async;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.IAsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;
import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.async.HttpAsyncExcutor;
import com.litesuits.http.data.HttpStatus;
import com.litesuits.http.data.NameValuePair;
import com.litesuits.http.exception.HttpException;
import com.litesuits.http.request.Request;
import com.litesuits.http.response.Response;
import com.litesuits.http.response.handler.HttpResponseHandler;

/**
 * Created by Administrator on 14-4-17.
 * 使用第三方实现get方式异步请求
 */
public class GetImplInnerAsyncHttpClient implements IAsyncHttpClient {

    /**
     * @param requestUrl
     * @param request
     * @param classOfT
     * @param handler
     * @param filter
     * @param <T>
     */
    @Override
    public <T extends EmptyHttpResponse> void execute(Context context, String requestUrl, EmptyHttpRequest request, final Class<T> classOfT, final IHttpResponseHandler<T> handler, final IHttpResponseFilter filter) {
        HttpAsyncExcutor asyncExcutor = new HttpAsyncExcutor();

        asyncExcutor.execute(LiteHttpClient.getInstance(context), new Request(requestUrl), new HttpResponseHandler() {
            @Override
            protected void onSuccess(Response res, HttpStatus status, NameValuePair[] headers) {
                if (res == null)
                    return;
                HttpCommonUtil.onFinish(res.getString(), classOfT, handler, filter);
            }

            @Override
            protected void onFailure(Response res, HttpException e) {
            }
        });
    }
}
