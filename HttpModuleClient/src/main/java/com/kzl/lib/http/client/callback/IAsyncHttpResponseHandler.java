package com.kzl.lib.http.client.callback;


import com.kzl.lib.http.client.model.EmptyHttpResponse;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: kezhenlu@qq.com<br/>
 * Date: 13-10-9<br/>
 * Time: 下午3:27<br/>
 * async http execute process
 * To change this template use File | Settings | File Templates.
 */
public interface IAsyncHttpResponseHandler<T extends EmptyHttpResponse> {
    /**
     * 访问网络开始时回调，与onFinish成对
     */
    public void onStart();

    /**
     * 访问网络结束时回调，与onStart成对
     */
    public void onFinish();

    /**
     * 访问网络时，无可用网络回调
     */
    public void onNoNet();

    /**
     * 无发解析结果时回调
     */
    public void onNoData();

    /**
     * 访问正常、数据不为空时回调
     */
    public void onSuccess(final T response);

//    /**
//     * 访问正常时回调
//     */
//    public void onError(String retCode, String errorInfo);
}
