package com.kzl.lib.http.sample.http.base;

import com.kzl.lib.http.sample.http.GpConstantsActionCode;
import com.kzl.lib.http.task.interfaces.BaseHttpRequest;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public class HttpCommonUtils {

    public static String getRequestUrl(BaseHttpRequest request) {
        return String.format("%s%s", String.format("%s%s", GpConstantsActionCode.HOST, request.getActionCode()), request.toString());
    }

    /**
     * to baseGet the really result json,but the server return the json with in a key "zushou365",so I baseGet the json by this key
     *
     * @param content
     * @return he really result json
     */
    public static String getRetJson(String content) {
        String retJson = null;
        try {
            JSONObject jsonObject = new JSONObject(content);
            JSONObject retJsonObject = jsonObject.getJSONObject("zushou365");
            retJson = retJsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return retJson;
    }
}
