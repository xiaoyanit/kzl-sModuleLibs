package com.kzl.lib.http.sample.http.base.async.impl;

import android.content.Context;
import com.kzl.lib.http.client.impl.async.GetImplAsyncHttpClient;
import com.kzl.lib.http.sample.module.BaseResponse;

/**
 * Created by kzl on 14-3-19.
 */
public class ImplBaseGetAsyncHttpTask<T extends BaseResponse> extends ImplBaseAsyncHttpTask<T> {
    public ImplBaseGetAsyncHttpTask(Context context) {
        super(context, new GetImplAsyncHttpClient());
    }
}
