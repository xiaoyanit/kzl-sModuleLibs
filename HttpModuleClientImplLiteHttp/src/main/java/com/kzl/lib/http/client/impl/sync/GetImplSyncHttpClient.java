package com.kzl.lib.http.client.impl.sync;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.ISyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;
import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.request.Request;
import com.litesuits.http.request.param.HttpMethod;
import com.litesuits.http.response.Response;


/**
* Created by Administrator on 14-4-17.
*/
public class GetImplSyncHttpClient implements ISyncHttpClient {
    /**
     *
     * @param requestUrl
     * @param request
     * @param classOfT
     * @param filter
     * @param <T>
     * @return
     */
    @Override
    public <T extends EmptyHttpResponse> T execute(Context context,String requestUrl, EmptyHttpRequest request, Class<T> classOfT, IHttpResponseFilter filter) {
        Response res = LiteHttpClient.getInstance(context).execute(new Request(requestUrl).setMethod(HttpMethod.Get));
        return HttpCommonUtil.onFinish(res.getString(), classOfT, null, filter);
    }
}
