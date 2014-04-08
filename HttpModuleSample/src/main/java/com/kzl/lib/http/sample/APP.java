package com.kzl.lib.http.sample;

import android.app.Application;
import com.kzl.lib.utils.CrashHandler;
import com.kzl.lib.utils.ToastUtil;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-11-13<br/>
 * Time: 上午9:21<br/>
 * To change this template use File | Settings | File Templates.
 */
public class APP extends Application {
    private static APP APP;

    public static APP getInstance() {
        return APP;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        APP = (com.kzl.lib.http.sample.APP) getApplicationContext();
        ToastUtil.init(APP);

        // 异常捕获处理
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }

}

