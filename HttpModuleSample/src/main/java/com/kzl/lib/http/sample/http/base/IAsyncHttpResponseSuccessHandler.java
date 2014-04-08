package com.kzl.lib.http.sample.http.base;

import com.kzl.lib.http.task.interfaces.BaseHttpResponse;

/**
 * Project:HttpModule
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 14-3-28<br/>
 * Time: 下午11:21<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface IAsyncHttpResponseSuccessHandler<T extends BaseHttpResponse> {
    /**
     * http访问正常，数据正常
     */
    public void onNormal(T rest);

    /**
     * http访问正常，但是数据错误
     */
    public void onError(String retCode, String errorInfo);
}