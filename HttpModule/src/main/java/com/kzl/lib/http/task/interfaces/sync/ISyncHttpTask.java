package com.kzl.lib.http.task.interfaces.sync;

import com.kzl.lib.http.task.impl.callback.IHttpResponseFilter;
import com.kzl.lib.http.task.impl.model.EmptyHttpRequest;
import com.kzl.lib.http.task.impl.model.EmptyHttpResponse;
import com.kzl.lib.http.task.impl.utils.HttpResponseMapper;

/**
 * Created by Administrator on 14-4-15.
 */
public interface ISyncHttpTask<T extends EmptyHttpResponse> {
    public T execute(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final IHttpResponseFilter filter);
}
