package com.kzl.lib.http.sample.http.base.async.impl;

import android.content.Context;
import com.kzl.lib.http.client.impl.async.PostImplAsyncHttpClient;
import com.kzl.lib.http.task.interfaces.BaseHttpResponse;

/**
 * Created by kzl on 14-3-19.
 */
public class ImplBasePostAsyncHttpTask<T extends BaseHttpResponse> extends ImplBaseAsyncHttpTask<T> {
    public ImplBasePostAsyncHttpTask(Context context) {
        super(context, new PostImplAsyncHttpClient());
    }
}
