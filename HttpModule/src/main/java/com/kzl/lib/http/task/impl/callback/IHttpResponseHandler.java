package com.kzl.lib.http.task.impl.callback;


import com.kzl.lib.http.task.impl.model.EmptyHttpResponse;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-10-9<br/>
 * Time: 下午3:05<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface IHttpResponseHandler {
    /**
     * do when you baseGet the http response
     *
     * @param response
     */
    public<T extends EmptyHttpResponse> void onFinish(T response);
}
