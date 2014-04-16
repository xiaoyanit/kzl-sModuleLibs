package com.kzl.lib.http.client.model;

/**
 * Project:HttpModule
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 14-3-28<br/>
 * Time: 下午9:16<br/>
 * To change this template use File | Settings | File Templates.
 */
public class EmptyHttpRequest {
    private transient String actionCode;

    public EmptyHttpRequest() {
    }

    public EmptyHttpRequest(String actionCode) {

        this.actionCode = actionCode;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
}
