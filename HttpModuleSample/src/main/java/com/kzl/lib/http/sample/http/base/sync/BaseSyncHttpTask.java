package com.kzl.lib.http.sample.http.base.sync;


import com.kzl.lib.http.sample.http.GpConstantsActionCode;
import com.kzl.lib.http.sample.http.base.HttpCommonUtils;
import com.kzl.lib.http.sample.http.base.ImplHttpResponseFilter;
import com.kzl.lib.http.sample.module.BaseRequest;
import com.kzl.lib.http.sample.module.BaseResponse;
import com.kzl.lib.http.task.interfaces.sync.ISyncHttpTask;
import com.kzl.lib.http.task.interfaces.sync.impl.GetImplSyncHttpTask;
import com.kzl.lib.http.task.interfaces.sync.impl.PostImplSyncHttpTask;

/**
 * Created by zhenlu .
 * Project:ZuShou365_phone
 * Email: kezhenlu@qq.com<br/>
 * User: kenny.ke
 * Date: 14-3-27<br/>
 * Time: 下午9:49<br/>
 * To change this template use File | Settings | File Templates.
 */
public class BaseSyncHttpTask<T extends BaseResponse> {
    private static BaseSyncHttpTask instance;
    private ISyncHttpTask<T> getSyncHttpTask;
    private ISyncHttpTask<T> postSyncHttpTask;

    private BaseSyncHttpTask() {
        getSyncHttpTask = new GetImplSyncHttpTask<T>();
        postSyncHttpTask = new PostImplSyncHttpTask<T>();
    }

    public static BaseSyncHttpTask getInstance() {
        if (instance == null) {
            instance = new BaseSyncHttpTask();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public T get(BaseRequest request) {
        return getSyncHttpTask.execute(request, HttpCommonUtils.getRequestUrl(request), GpConstantsActionCode.getInstance(), ImplHttpResponseFilter.getInstance());
    }

    @SuppressWarnings("unchecked")
    public T post(BaseRequest request) {
        return postSyncHttpTask.execute(request, HttpCommonUtils.getRequestUrl(request), GpConstantsActionCode.getInstance(), ImplHttpResponseFilter.getInstance());
    }
}
