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
 * 使用第三方实现get方式异步请求
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplLiteHttp<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class GetImplInnerAsyncHttpClient<T extends EmptyHttpResponse> implements IAsyncHttpClient<T> {

    @Override
    public void execute(Context context, String requestUrl, EmptyHttpRequest request, final Class<T> classOfT, final IHttpResponseHandler<T> handler, final IHttpResponseFilter filter) {
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
