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

/**
 * http工具类
 * Project:LuLuModuleLibs<br/>
 * Module:HttpModuleClientImplLiteHttp<br/>
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke<br/>
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class HttpCommonUtil {
    private final static String LOG_TAG = "HTTPUtil";
    private final static Gson GSON = new Gson();


    public static <T extends EmptyHttpResponse> Class<T> getResponseClassType(HttpResponseMapper mapper, EmptyHttpRequest request) {
        return mapper.findClass(request.getActionCode());
    }

    /**
     * execute after baseGet the response
     * @param responseString
     * @param classOfT
     * @param handler
     * @param filter
     * @param <T>
     * @return
     */
    public static <T extends EmptyHttpResponse> T onFinish(String  responseString, final Class<T> classOfT, final IHttpResponseHandler<T> handler, final IHttpResponseFilter filter) {
        if (responseString == null) {
            LogUtil.trace(LOG_TAG, "connect fail onPostExecute");
            return null;
        }
        LogUtil.trace(LOG_TAG, "json-response:" + responseString);
        T responseEntity = null;
        try {
            String retJson = filter.dealWithRet(responseString);
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
