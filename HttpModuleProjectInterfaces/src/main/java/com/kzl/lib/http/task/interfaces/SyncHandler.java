package com.kzl.lib.http.task.interfaces;

import com.kzl.lib.utils.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class SyncHandler implements InvocationHandler {
    private final static String LOG_TAG = GPConstantValues.LOG_TAG;

    private Object object;

    public SyncHandler(Object obj) {
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        //在这里完全可以把下面这句注释掉，而做一些其它的事情
        Object result = method.invoke(object, args);
        after();
        return result;
    }
    private void doBefore() {
        LogUtil.trace(LOG_TAG,"before");

    }
    private void after() {
        LogUtil.trace(LOG_TAG,"after");
    }

}
