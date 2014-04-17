package com.kzl.lib.http.client.impl.sync;

import com.kzl.lib.http.client.interfaces.ISyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;

import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

/**
 * Created by Administrator on 14-4-17.
 */
public class PostSyncHttpClient implements ISyncHttpClient {
    @Override
    public <T extends EmptyHttpResponse> T execute(String requestUrl, EmptyHttpRequest request, Class<T> classOfT, IHttpResponseFilter filter) {
        HttpResponse response = HttpUtils.httpPost(requestUrl);
        return HttpCommonUtil.onFinish(response, classOfT, null, filter);
    }
}
