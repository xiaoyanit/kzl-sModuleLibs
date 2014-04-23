package com.kzl.lib.http.client.impl.sync;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.SyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;
import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.request.Request;
import com.litesuits.http.request.param.HttpMethod;
import com.litesuits.http.response.Response;


/**
 * http post同步请求实现
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplLiteHttp<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class PostImplSyncHttpClient<T extends EmptyHttpResponse> implements SyncHttpClient<T> {
    @Override
    public T execute(Context context, String requestUrl, EmptyHttpRequest request, Class<T> classOfT, IHttpResponseFilter filter) {
        Response res = LiteHttpClient.getInstance(context).execute(new Request(requestUrl).setMethod(HttpMethod.Post));
        return HttpCommonUtil.onFinish(res.getString(), classOfT, null, filter);
    }
}
