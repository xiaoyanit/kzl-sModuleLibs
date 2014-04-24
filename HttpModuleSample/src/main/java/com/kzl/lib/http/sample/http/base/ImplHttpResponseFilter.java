package com.kzl.lib.http.sample.http.base;


import com.kzl.lib.http.client.interfaces.callback.HttpResponseFilter;

/**
 * http响应结果过滤器实现<br/>
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleSample<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class ImplHttpResponseFilter implements HttpResponseFilter {

    private static ImplHttpResponseFilter instance;

    public static ImplHttpResponseFilter getInstance() {
        if (instance == null) {
            instance = new ImplHttpResponseFilter();
        }
        return instance;
    }

    @Override
    public String dealWithRet(String responseJson) {
        return HttpCommonUtils.getRetJson(responseJson);
    }


}
