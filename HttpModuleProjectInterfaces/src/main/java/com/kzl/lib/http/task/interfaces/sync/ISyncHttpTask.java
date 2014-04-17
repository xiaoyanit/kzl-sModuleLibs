package com.kzl.lib.http.task.interfaces.sync;


import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.http.task.interfaces.GPConstantValues;

/**
 * Created by Administrator on 14-4-15.
 */
public interface ISyncHttpTask<T extends EmptyHttpResponse> {
    final static String LOG_TAG = GPConstantValues.LOG_TAG;
    public T execute(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final IHttpResponseFilter filter);
}
