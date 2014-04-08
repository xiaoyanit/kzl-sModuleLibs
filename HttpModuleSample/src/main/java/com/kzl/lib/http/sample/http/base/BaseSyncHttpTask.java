package com.kzl.lib.http.sample.http.base;


import com.kzl.lib.http.sample.http.GpConstantsActionCode;
import com.kzl.lib.http.sample.module.BaseRequest;
import com.kzl.lib.http.sample.module.BaseResponse;
import com.kzl.lib.http.task.interfaces.sync.ImplSyncHttpTask;

/**
 * Created by zhenlu .
 * Project:ZuShou365_phone
 * Email: kezhenlu@qq.com<br/>
 * User: kenny.ke
 * Date: 14-3-27<br/>
 * Time: 下午9:49<br/>
 * To change this template use File | Settings | File Templates.
 */
public class BaseSyncHttpTask<T extends BaseResponse> extends ImplSyncHttpTask {
    private static BaseSyncHttpTask instance;

    private BaseSyncHttpTask() {
    }

    public static BaseSyncHttpTask getInstance() {
        if (instance == null) {
            instance = new BaseSyncHttpTask();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public T get(BaseRequest request) {
        return (T) super.get(request, HttpCommonUtils.getRequestUrl(request), GpConstantsActionCode.getInstance(), ImplHttpResponseFilter.getInstance());
    }

    @SuppressWarnings("unchecked")
    public T post(BaseRequest request) {
        return (T) super.post(request, HttpCommonUtils.getRequestUrl(request), GpConstantsActionCode.getInstance(), ImplHttpResponseFilter.getInstance());
    }
}
