package com.kzl.lib.http.client.utils;

import android.os.AsyncTask;

import com.kzl.lib.http.client.callback.IHttpExecute;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.HttpCommonUtil;

import cn.trinea.android.common.entity.HttpResponse;

/**
 * Created by kzl on 14-3-19.
 */
public class AsyncHttpUtil {
    /**
     * 通过同步的http 请求，自己实现异步，具体请求子类实现
     *
     * @param classOfT
     * @param handler
     * @param httpExecute
     * @param <T>
     */
    public static <T extends EmptyHttpResponse> void execute(final Class<T> classOfT,
                                                             final IHttpResponseHandler handler, final IHttpExecute httpExecute, final IHttpResponseFilter filter) {
        new AsyncTask<Void, Void, HttpResponse>() {
            @Override
            protected HttpResponse doInBackground(Void... params) {
                return httpExecute.execute();
            }

            @Override
            protected void onPostExecute(HttpResponse response) {
                super.onPostExecute(response);
                HttpCommonUtil.onFinish(response, classOfT, handler, filter);
            }
        }.execute();
    }
}
