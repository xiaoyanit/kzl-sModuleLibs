package com.kzl.lib.http.task.interfaces.sync;

import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.task.interfaces.GPConstantValues;
import com.kzl.lib.utils.LogUtil;

/**
 * Created by Administrator on 14-4-16.
 */
public abstract class SyncHttpExecute {
    private final static String LOG_TAG = GPConstantValues.LOG_TAG;
    public abstract <T extends EmptyHttpResponse> T execute();
    public <T extends EmptyHttpResponse> T filter(String url, EmptyHttpRequest request) {
        LogUtil.trace(LOG_TAG, "json-request sync:" + url);
        LogUtil.trace(LOG_TAG, "request-actionCode:" + request.getActionCode());

        final long start = System.currentTimeMillis();

        T response = execute();

        LogUtil.trace(LOG_TAG + "  start-end ==" + (System.currentTimeMillis() - start));
        return response;
    }
}
