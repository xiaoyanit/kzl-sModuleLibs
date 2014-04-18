package com.kzl.lib.http.client.callback;

import com.litesuits.http.response.Response;

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
     Response execute();
}
