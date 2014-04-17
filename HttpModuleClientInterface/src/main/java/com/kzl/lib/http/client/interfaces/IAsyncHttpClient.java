package com.kzl.lib.http.client.interfaces;

import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * Created by Administrator on 14-4-17.
 */
public interface IAsyncHttpClient {

    public <T extends EmptyHttpResponse> void execute(final String requestUrl,final EmptyHttpRequest request, final Class<T> classOfT,
                                                          final IHttpResponseHandler handler, final IHttpResponseFilter filter);
}
