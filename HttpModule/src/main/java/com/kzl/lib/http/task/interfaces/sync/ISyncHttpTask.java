package com.kzl.lib.http.task.interfaces.sync;

import com.kzl.lib.http.client.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.model.EmptyHttpRequest;
import com.kzl.lib.http.client.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpResponseMapper;

/**
 * Created by Administrator on 14-4-15.
 */
public interface ISyncHttpTask<T extends EmptyHttpResponse> {
    public T execute(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final IHttpResponseFilter filter);
}