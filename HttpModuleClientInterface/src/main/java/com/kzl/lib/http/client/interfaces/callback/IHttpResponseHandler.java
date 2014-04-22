package com.kzl.lib.http.client.interfaces.callback;


import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;

/**
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleProjectInterfaces<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface IHttpResponseHandler<T extends EmptyHttpResponse>  {
    /**
     * do when you get the http response
     *
     * @param response
     */
    public void onFinish(T response);
}
