package com.kzl.lib.http.sample.http.impl;


import android.content.Context;
import com.kzl.lib.http.sample.http.base.async.impl.ImplBaseGetAsyncHttpTask;
import com.kzl.lib.http.sample.http.base.async.impl.ImplBasePostAsyncHttpTask;
import com.kzl.lib.http.sample.module.request.LoginRequest;
import com.kzl.lib.http.sample.module.response.LoginResponse;
import com.kzl.lib.utils.LogUtil;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-10-11<br/>
 * Time: 下午2:53<br/>
 * To change this template use File | Settings | File Templates.
 */
public class LoginPostTask<T extends LoginResponse> extends ImplBasePostAsyncHttpTask<T> {

    public LoginPostTask(Context context) {
        super(context);
    }

    //登录
    public void send(final String account, final String md5Password) {
        super.execute(new LoginRequest(account, md5Password));
    }

    @Override
    public void onError(String retCode, String errorInfo) {
        super.onError(retCode, errorInfo);
    }

    @Override
    public void onNormal(T response) {
        super.onNormal(response);
        LogUtil.trace("response==" + response.toString());
    }
}