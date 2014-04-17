package com.kzl.lib.http.client.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.interfaces.utils.HttpResponseMapper;
import com.kzl.lib.utils.LogUtil;

import cn.trinea.android.common.entity.HttpResponse;

/**
 * Created by Administrator on 14-3-19.
 */
public class HttpCommonUtil {
    private final static String LOG_TAG = "HTTPUtil";
    private final static Gson GSON = new Gson();


    public static <T extends EmptyHttpResponse> Class<T> getResponseClassType(HttpResponseMapper mapper, EmptyHttpRequest request) {
        return mapper.findClass(request.getActionCode());
    }

    /**
     * execute after baseGet the response
     *
     * @param response
     * @param classOfT
     * @param handler
     * @param <T>
     */
    public static <T extends EmptyHttpResponse> T onFinish(HttpResponse response, final Class<T> classOfT, final IHttpResponseHandler handler, final IHttpResponseFilter filter) {
        if (response == null || response.getResponseBody() == null) {
            LogUtil.trace(LOG_TAG, "connect fail onPostExecute");
            return null;
        }
        LogUtil.trace(LOG_TAG, "json-response:" + response.getResponseBody());
        T responseEntity = null;
        try {
            String retJson = filter.dealWithRet(response.getResponseBody());
            responseEntity = GSON.fromJson(retJson, classOfT);
        } catch (JsonSyntaxException e) {
            LogUtil.trace(e);
        } catch (JsonParseException e) {
            LogUtil.trace(e);
        } finally {
            if (handler != null) {
                handler.onFinish(responseEntity);
            }
            return responseEntity;

        }
    }


}
