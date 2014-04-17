package com.kzl.lib.http.sample.http.impl;


import com.kzl.lib.http.sample.http.base.BaseSyncHttpTask;
import com.kzl.lib.http.sample.module.request.LoginRequest;
import com.kzl.lib.http.sample.module.response.LoginResponse;

/**
 * Created by Administrator on 14-3-28.
 */
public class SyncRequestTask {
    public static LoginResponse loginTask(final String account, final String md5Password) {
        BaseSyncHttpTask.getInstance().post(new LoginRequest(account, md5Password));
        return (LoginResponse) BaseSyncHttpTask.getInstance().get(new LoginRequest(account, md5Password));
    }
}
