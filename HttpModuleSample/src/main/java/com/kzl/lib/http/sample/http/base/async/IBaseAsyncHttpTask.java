package com.kzl.lib.http.sample.http.base.async;

import com.kzl.lib.http.task.interfaces.BaseHttpRequest;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/17<br/>
 * Time: 22:11<br/>
 * To change this template use File | Settings | File Templates.
 */
public interface IBaseAsyncHttpTask {
    public void execute(final BaseHttpRequest request);
}
