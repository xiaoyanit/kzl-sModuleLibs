package com.kzl.lib.http.task.interfaces.sync.impl;

import com.kzl.lib.http.client.impl.sync.GetImplSyncHttpClient;
import com.kzl.lib.http.client.interfaces.ISyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.http.client.utils.HttpCommonUtil;
import com.kzl.lib.http.task.interfaces.sync.ISyncHttpTask;
import com.kzl.lib.http.task.interfaces.sync.SyncHttpExecute;
import com.kzl.lib.utils.LogUtil;

/**
 * Created by Administrator on 14-4-15.
 */
public class GetImplSyncHttpTask<T extends EmptyHttpResponse> implements ISyncHttpTask<T> {
    private static ISyncHttpClient syncHttpClient;

    public static ISyncHttpClient getSyncHttpClient() {
        if (syncHttpClient == null) {
            syncHttpClient = new GetImplSyncHttpClient();
        }
        return syncHttpClient;
    }

    @SuppressWarnings("unchecked")
    public T execute(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final IHttpResponseFilter filter) {
        LogUtil.trace(LOG_TAG, "GetImplSyncHttpTask");
        return new SyncHttpExecute() {
            @Override
            public T execute() {
                return (T) getSyncHttpClient().execute(url, request, HttpCommonUtil.getResponseClassType(mapper, request), filter);
            }
        }.filter(url, request);
    }

}
