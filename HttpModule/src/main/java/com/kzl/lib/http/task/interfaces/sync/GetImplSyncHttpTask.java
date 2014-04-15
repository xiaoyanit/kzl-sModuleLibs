package com.kzl.lib.http.task.interfaces.sync;

import com.kzl.lib.http.task.impl.SyncHttpClient;
import com.kzl.lib.http.task.impl.callback.IHttpResponseFilter;
import com.kzl.lib.http.task.impl.model.EmptyHttpRequest;
import com.kzl.lib.http.task.impl.model.EmptyHttpResponse;
import com.kzl.lib.http.task.impl.utils.HttpCommonUtil;
import com.kzl.lib.http.task.impl.utils.HttpResponseMapper;

/**
 * Created by Administrator on 14-4-15.
 */
public class GetImplSyncHttpTask<T extends EmptyHttpResponse> implements ISyncHttpTask<T>{
    @Override
    @SuppressWarnings("unchecked")
    public T execute(EmptyHttpRequest request, String url, HttpResponseMapper mapper, IHttpResponseFilter filter) {
        return (T) SyncHttpClient.get(url, HttpCommonUtil.getResponseClassType(mapper, request), filter);
    }
}
