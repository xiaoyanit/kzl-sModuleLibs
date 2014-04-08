package com.kzl.lib.utils;

import android.util.Log;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-10-9<br/>
 * Time: 下午3:13<br/>
 * To change this template use File | Settings | File Templates.
 */
public class LogUtil {
    private static final String TAG = "myLog";
    public static final boolean isDebug = true;

    public static void trace(Exception e) {
        if (!isDebug)
            return;
        final String msg = e.getMessage();
        Log.e(TAG, msg == null ? "" : msg);
    }

    public static void trace(String msg) {
        if (!isDebug)
            return;
        Log.d(TAG, msg);
    }


    public static void trace(String tag, String msg) {
        if (!isDebug)
            return;
        Log.d(TAG + tag, msg);
    }

    public static void trace(String tag, Exception e) {
        if (!isDebug)
            return;
        final String msg = e.getMessage();
        Log.e(TAG + tag, msg == null ? "" : msg);
    }
}
