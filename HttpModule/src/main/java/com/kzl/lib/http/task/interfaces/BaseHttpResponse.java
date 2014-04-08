package com.kzl.lib.http.task.interfaces;

import com.kzl.lib.http.task.impl.model.EmptyHttpResponse;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-12-3<br/>
 * Time: 下午5:30<br/>
 * To change this template use File | Settings | File Templates.
 */
public class BaseHttpResponse extends EmptyHttpResponse{
    private String resultCode;
    private String errorInfo;
    private String actionCode;

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
