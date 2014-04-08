package com.kzl.lib.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-12-10<br/>
 * Time: 下午3:05<br/>
 * To change this template use File | Settings | File Templates.
 */
public class ThreadPoolUtil {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static Executor threadPool;

    public static Executor getThreadPool() {
        if (threadPool == null) {
//            threadPool = Executors.newCachedThreadPool();
            threadPool = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        }
        return threadPool;
    }
}
