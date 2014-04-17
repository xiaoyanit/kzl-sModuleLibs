package com.kzl.lib.http.client.interfaces.callback;

/**
 * Created by zhenlu on 14-3-27.
 */
public interface IHttpResponseFilter {
    /**
     * filter the response json and return as you like
     *
     * @param responseJson
     * @return
     */
    String dealWithRet(String responseJson);
}
