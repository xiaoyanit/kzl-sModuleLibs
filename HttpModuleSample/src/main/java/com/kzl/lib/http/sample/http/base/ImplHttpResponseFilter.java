package com.kzl.lib.http.sample.http.base;


import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;

/**
 * Project:HttpModuleSample
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 14-3-31<br/>
 * Time: 下午10:06<br/>
 * To change this template use File | Settings | File Templates.
 */
public class ImplHttpResponseFilter implements IHttpResponseFilter {

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
