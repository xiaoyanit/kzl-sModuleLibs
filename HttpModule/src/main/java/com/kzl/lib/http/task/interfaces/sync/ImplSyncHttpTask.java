package com.kzl.lib.http.task.interfaces.sync;


import com.kzl.lib.http.task.impl.model.EmptyHttpRequest;
import com.kzl.lib.http.task.impl.model.EmptyHttpResponse;
import com.kzl.lib.http.task.impl.utils.HttpCommonUtil;
import com.kzl.lib.http.task.impl.utils.HttpResponseMapper;
import com.kzl.lib.http.task.impl.SyncHttpClient;
import com.kzl.lib.http.task.impl.callback.IHttpResponseFilter;
import com.kzl.lib.utils.LogUtil;

/**
 * Created by Administrator on 14-3-19.
 */
public class ImplSyncHttpTask<T extends EmptyHttpResponse> {
    private final static String LOG_TAG = "HTTPUtil";

    @SuppressWarnings("unchecked")
    public T get(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final IHttpResponseFilter filter) {
        return filter(new SyncHttpExecute() {
            @Override
            public T execute() {
                return (T) SyncHttpClient.get(url, HttpCommonUtil.getResponseClassType(mapper, request), filter);
            }
        }, url, request);
    }

    @SuppressWarnings("unchecked")
    public T post(final EmptyHttpRequest request, final String url, final HttpResponseMapper mapper, final IHttpResponseFilter filter) {
        return filter(new SyncHttpExecute() {
            @Override
            public T execute() {
                return (T) SyncHttpClient.post(url, HttpCommonUtil.getResponseClassType(mapper, request), filter);
            }
        }, url, request);
    }

    private T filter(SyncHttpExecute httpExecute, String url, EmptyHttpRequest request) {
        LogUtil.trace(LOG_TAG, "json-request:" + url);
        LogUtil.trace(LOG_TAG, "request-actionCode:" + request.getActionCode());

        final long start = System.currentTimeMillis();

        T response = httpExecute.execute();

        LogUtil.trace(LOG_TAG + "  start-end ==" + (System.currentTimeMillis() - start));
        return response;
    }

    interface SyncHttpExecute {
        <T extends EmptyHttpResponse> T execute();
    }
}
