package com.kzl.lib.http.task.interfaces.async;

import android.content.Context;

import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;

/**
 * Created by Administrator on 14-4-17.
 */
public interface IAsyncHttpTask {
    void execute(final Context context , final String url, final EmptyHttpRequest request, final HttpResponseMapper mapper, final IHttpResponseFilter filter);
}
