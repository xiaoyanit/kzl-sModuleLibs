package com.kzl.lib.http.task.interfaces;

import com.kzl.lib.utils.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 14-4-15.
 */
public class SyncHandler implements InvocationHandler {
    private final static String LOG_TAG = "HTTPUtil";

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
