package com.kzl.lib.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-12-19<br/>
 * Time: 下午3:23<br/>
 * To change this template use File | Settings | File Templates.
 */
public class EmptyUtils {

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

}
