package com.kzl.lib.http.sample.http.impl;


import android.content.Context;
import com.kzl.lib.http.sample.http.base.BaseAsyncHttpTask;
import com.kzl.lib.http.sample.module.request.LoginRequest;
import com.kzl.lib.http.sample.module.response.LoginResponse;
import com.kzl.lib.utils.LogUtil;
import com.kzl.lib.http.client.model.EmptyHttpResponse;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-10-11<br/>
 * Time: 下午2:53<br/>
 * To change this template use File | Settings | File Templates.
 */
public class LoginTask extends BaseAsyncHttpTask<LoginResponse> {

    public LoginTask(Context context) {
        super(context);
    }

    //登录
    public void send(final String account, final String md5Password) {
        super.executeGet(new LoginRequest(account, md5Password));
        super.executePost(new LoginRequest(account, md5Password));
    }

    @Override
    public void onSuccess(EmptyHttpResponse response) {
        super.onSuccess(response);
    }

    @Override
    public void onError(String retCode, String errorInfo) {
        super.onError(retCode, errorInfo);
    }

    @Override
    public void onNormal(LoginResponse response) {
        super.onNormal(response);
        LogUtil.trace("response==" + response.toString());
    }
}