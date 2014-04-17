package com.kzl.lib.http.sample.http.base.async.impl;

import android.content.Context;
import com.kzl.lib.http.client.interfaces.IAsyncHttpClient;
import com.kzl.lib.http.sample.http.GpConstantsActionCode;
import com.kzl.lib.http.sample.http.base.HttpCommonUtils;
import com.kzl.lib.http.sample.http.base.IAsyncHttpResponseSuccessHandler;
import com.kzl.lib.http.sample.http.base.ImplHttpResponseFilter;
import com.kzl.lib.http.sample.http.base.async.IBaseAsyncHttpTask;
import com.kzl.lib.http.sample.http.base.async.ImplAsyncHttpResponseHandler;
import com.kzl.lib.http.task.interfaces.BaseHttpRequest;
import com.kzl.lib.http.task.interfaces.BaseHttpResponse;
import com.kzl.lib.http.task.interfaces.async.IAsyncHttpTask;
import com.kzl.lib.http.task.interfaces.async.ImplAsyncHttpTask;

/**
 * Created by kzl on 14-3-19.
 */
public class ImplBaseAsyncHttpTask<T extends BaseHttpResponse> extends ImplAsyncHttpResponseHandler<T> implements IBaseAsyncHttpTask, IAsyncHttpResponseSuccessHandler<T> {
    private IAsyncHttpTask iAsyncHttpTask;

    public ImplBaseAsyncHttpTask(Context context, IAsyncHttpClient iAsyncHttpClient) {
        iAsyncHttpTask = new ImplAsyncHttpTask<T>(context, iAsyncHttpClient, this);
    }

    @Override
    public void execute(final BaseHttpRequest request) {
        iAsyncHttpTask.execute(HttpCommonUtils.getRequestUrl(request), request, GpConstantsActionCode.getInstance(), ImplHttpResponseFilter.getInstance());
    }
}
