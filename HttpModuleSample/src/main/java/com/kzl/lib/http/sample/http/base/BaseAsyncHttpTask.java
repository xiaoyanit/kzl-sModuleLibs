package com.kzl.lib.http.sample.http.base;

import android.content.Context;
import com.kzl.lib.http.R;
import com.kzl.lib.http.sample.http.GpConstantsActionCode;
import com.kzl.lib.http.task.interfaces.async.ImplAsyncHttpTask;
import com.kzl.lib.http.task.interfaces.BaseHttpRequest;
import com.kzl.lib.http.task.interfaces.BaseHttpResponse;
import com.kzl.lib.http.task.impl.model.EmptyHttpResponse;
import com.kzl.lib.utils.LogUtil;
import com.kzl.lib.utils.ToastUtil;

/**
 * Created by kzl on 14-3-19.
 */
public class BaseAsyncHttpTask<T extends BaseHttpResponse> extends ImplAsyncHttpTask implements IAsyncHttpResponseSuccessHandler<T> {
    public BaseAsyncHttpTask(Context context) {
        super(context);
    }

    public void executeGet(final BaseHttpRequest request) {
        super.baseGet(HttpCommonUtils.getRequestUrl(request), request, GpConstantsActionCode.getInstance(), ImplHttpResponseFilter.getInstance());
    }
    public void executePost(final BaseHttpRequest request) {
        super.basePost(HttpCommonUtils.getRequestUrl(request), request, GpConstantsActionCode.getInstance(), ImplHttpResponseFilter.getInstance());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(EmptyHttpResponse response) {
        LogUtil.trace("onSuccess");
        if (response instanceof BaseHttpResponse) {
            BaseHttpResponse baseHttpResponse = (BaseHttpResponse) response;
            if (GpConstantsActionCode.RES_OK.equals(baseHttpResponse.getResultCode())) {
                onNormal((T) baseHttpResponse);
            } else {
                onError(baseHttpResponse.getResultCode(), baseHttpResponse.getErrorInfo());
            }
        }
    }


    @Override
    public void onStart() {
        LogUtil.trace("onStart");
    }

    @Override
    public void onFinish() {
        LogUtil.trace("onFinish");
    }


    @Override
    public void onNoNet() {
        LogUtil.trace("onNoNet");
        ToastUtil.showMessage(R.string.no_net);
    }

    @Override
    public void onNoData() {
        LogUtil.trace("onNoData");
        ToastUtil.showMessage(R.string.no_data);
    }

    @Override
    public void onNormal(T response) {
        LogUtil.trace("onNormal");
    }

    @Override
    public void onError(String retCode, String errorInfo) {
        LogUtil.trace("onError");
        ToastUtil.showMessage(errorInfo);
    }
}