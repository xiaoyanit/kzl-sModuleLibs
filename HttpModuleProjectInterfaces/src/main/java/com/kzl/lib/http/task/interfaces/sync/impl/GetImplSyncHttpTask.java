package com.kzl.lib.http.task.interfaces.sync.impl;

import android.content.Context;

import com.kzl.lib.http.client.impl.sync.GetImplSyncHttpClient;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * Created by Administrator on 14-4-15.
 */
public class GetImplSyncHttpTask<T extends EmptyHttpResponse> extends BaseImplSyncHttpTask<T> {

    public GetImplSyncHttpTask(Context context) {
        super(context,new GetImplSyncHttpClient());
    }
}
