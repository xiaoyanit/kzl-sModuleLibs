package com.kzl.lib.http.task.interfaces.sync.impl;

import android.content.Context;

import com.kzl.lib.http.client.impl.sync.PostImplSyncHttpClient;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * Created by Administrator on 14-4-16.
 */
public class PostImplSyncHttpTask<T extends EmptyHttpResponse> extends BaseImplSyncHttpTask<T> {

    public PostImplSyncHttpTask(Context context) {
        super(context, new PostImplSyncHttpClient());
    }
}
