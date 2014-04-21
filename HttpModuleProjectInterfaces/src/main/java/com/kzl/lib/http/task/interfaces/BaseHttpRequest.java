package com.kzl.lib.http.task.interfaces;


import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class BaseHttpRequest extends EmptyHttpRequest {

    public BaseHttpRequest(String actionCode) {
        super(actionCode);
    }
}
