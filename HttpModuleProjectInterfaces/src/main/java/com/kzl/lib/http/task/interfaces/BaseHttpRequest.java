package com.kzl.lib.http.task.interfaces;


import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-12-3<br/>
 * Time: 下午5:30<br/>
 * To change this template use File | Settings | File Templates.
 */
public class BaseHttpRequest extends EmptyHttpRequest {

    public BaseHttpRequest(String actionCode) {
        super(actionCode);
    }
}
