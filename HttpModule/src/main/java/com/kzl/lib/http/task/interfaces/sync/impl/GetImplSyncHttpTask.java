package com.kzl.lib.http.task.interfaces.sync.impl;

import com.kzl.lib.http.task.impl.SyncHttpClient;
import com.kzl.lib.http.task.impl.callback.IHttpResponseFilter;
import com.kzl.lib.http.task.impl.model.EmptyHttpRequest;
import com.kzl.lib.http.task.impl.model.EmptyHttpResponse;
import com.kzl.lib.http.task.impl.utils.HttpCommonUtil;
import com.kzl.lib.http.task.impl.utils.HttpResponseMapper;
import com.kzl.lib.http.task.interfaces.sync.ISyncHttpTask;
import com.kzl.lib.http.task.interfaces.sync.SyncHttpExecute;
import com.kzl.lib.utils.LogUtil;

/**
 * Created by Administrator on 14-4-15.
 */
public class GetImplSyncHttpTask<T extends EmptyHttpResponse> implements ISyncHttpTask<T> {
    private final static String LOG_TAG = "HTTPUtil";
    @SuppressWarnings("unchecked")
    public T execute(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final IHttpResponseFilter filter) {
        LogUtil.trace(LOG_TAG,"GetImplSyncHttpTask");
        return new SyncHttpExecute() {
            @Override
            public T execute() {
                return (T) SyncHttpClient.get(url, HttpCommonUtil.getResponseClassType(mapper, request), filter);
            }
        }.filter(url, request);
    }

}
