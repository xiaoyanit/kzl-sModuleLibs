package com.kzl.lib.http.client.interfaces.utils;

import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Project:HttpModule<br/>
 * Module:
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 14-3-28<br/>
 * Time: 下午9:21<br/>
 * To change this template use File | Settings | File Templates.
 * 子类必须findClass方法,静态初始化，
 */
public class HttpResponseMapper {
    /**
     * 子类可以重写CLASS_MAP修改里面的值类型为其具体抽象类类型，但，此时，会丢失父类初始化的数据，*
     */
    protected final static Map<String, Class<? extends EmptyHttpResponse>> CLASS_MAP = new HashMap<String, Class<? extends EmptyHttpResponse>>();

    static {
        if (LogUtil.isDebug) {
            CLASS_MAP.put("g", EmptyHttpResponse.class);
        }
    }

    /**
     * 如果没有找到key对应的类型，则返回null，子类可以根据自身需求返回具体抽象类型
     *
     * @param actionCode
     * @param <T>
     * @return
     */
    public <T extends EmptyHttpResponse> Class<T> findClass(String actionCode) {
        Class c = CLASS_MAP.get(actionCode);
//        if (c == null)
//            c = EmptyHttpResponse.class;
        return c;
    }
}
