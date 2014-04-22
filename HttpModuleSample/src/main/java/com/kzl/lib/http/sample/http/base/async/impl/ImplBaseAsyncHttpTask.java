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
import com.kzl.lib.http.task.interfaces.async.impl.ImplAsyncHttpTask;

/**
 * http 异步访问的基类,get、post等具体实现，都可以继承本类<br/>
 * Project:LuLuModuleLibs<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class ImplBaseAsyncHttpTask<T extends BaseHttpResponse> extends ImplAsyncHttpResponseHandler<T> implements IBaseAsyncHttpTask, IAsyncHttpResponseSuccessHandler<T> {
    private Context context;
    private IAsyncHttpTask iAsyncHttpTask;

    public ImplBaseAsyncHttpTask(Context context, IAsyncHttpClient iAsyncHttpClient) {
        this.context = context;
        iAsyncHttpTask = new ImplAsyncHttpTask<T>(context, iAsyncHttpClient, this);
    }

    @Override
    public void execute(final BaseHttpRequest request) {
        iAsyncHttpTask.execute(context, HttpCommonUtils.getRequestUrl(request), request, GpConstantsActionCode.getInstance(), ImplHttpResponseFilter.getInstance());
    }
}
