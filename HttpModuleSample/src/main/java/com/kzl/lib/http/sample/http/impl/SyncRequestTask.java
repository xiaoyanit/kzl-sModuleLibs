package com.kzl.lib.http.sample.http.impl;


import com.kzl.lib.http.sample.http.base.sync.BaseSyncHttpTask;
import com.kzl.lib.http.sample.module.request.LoginRequest;
import com.kzl.lib.http.sample.module.response.LoginResponse;

/**
 * Created by Administrator on 14-3-28.
 */
public class SyncRequestTask {
    public static LoginResponse loginGetTask(final String account, final String md5Password) {
        return (LoginResponse) BaseSyncHttpTask.getInstance().get(new LoginRequest(account, md5Password));
    }

    public static LoginResponse loginPostTask(final String account, final String md5Password) {
        return (LoginResponse)BaseSyncHttpTask.getInstance().post(new LoginRequest(account, md5Password));
    }
}
