package com.kzl.lib.http.client.interfaces;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * Created by Administrator on 14-4-17.
 */
public interface ISyncHttpClient {
    public  <T extends EmptyHttpResponse> T execute(Context context,
                                                    final String requestUrl,final EmptyHttpRequest request,
                                                    final Class<T> classOfT, final IHttpResponseFilter filter);

}
