package com.kzl.lib.http.task.interfaces.sync.impl;

import com.kzl.lib.http.client.SyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.http.client.utils.HttpCommonUtil;
import com.kzl.lib.http.task.interfaces.sync.ISyncHttpTask;
import com.kzl.lib.http.task.interfaces.sync.SyncHttpExecute;
import com.kzl.lib.utils.LogUtil;

/**
 * Created by Administrator on 14-4-16.
 */
public class PostImplSyncHttpTask<T extends EmptyHttpResponse> implements ISyncHttpTask<T> {
    @Override
    @SuppressWarnings("unchecked")
    public T execute(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final IHttpResponseFilter filter) {
        LogUtil.trace(LOG_TAG, "PostImplSyncHttpTask");
        return new SyncHttpExecute() {
            @Override
            public T execute() {
                return (T) SyncHttpClient.post(url, HttpCommonUtil.getResponseClassType(mapper, request), filter);
            }
        }.filter(url, request);
    }
}
