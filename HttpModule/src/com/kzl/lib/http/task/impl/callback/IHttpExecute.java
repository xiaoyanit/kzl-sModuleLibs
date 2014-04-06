package com.kzl.lib.http.task.impl.callback;

import cn.trinea.android.common.entity.HttpResponse;

/**
 * Created by kzl on 14-3-20.
 */
public interface IHttpExecute {
    /**
     * execute a http request
     * eg:baseGet , basePost ,delete ...
     *
     * @return the response from http
     */
    HttpResponse execute();
}
