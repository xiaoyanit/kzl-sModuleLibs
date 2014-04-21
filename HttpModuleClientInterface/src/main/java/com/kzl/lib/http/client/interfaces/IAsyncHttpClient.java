package com.kzl.lib.http.client.interfaces;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * Created by Administrator on 14-4-17.
 */
public interface IAsyncHttpClient<T extends EmptyHttpResponse> {
    /**
     * @param context
     * @param requestUrl
     * @param request
     * @param classOfT
     * @param handler
     * @param filter
     */
    public void execute(Context context, final String requestUrl,
                        final EmptyHttpRequest request, final Class<T> classOfT,
                        final IHttpResponseHandler<T> handler, final IHttpResponseFilter filter);
}
