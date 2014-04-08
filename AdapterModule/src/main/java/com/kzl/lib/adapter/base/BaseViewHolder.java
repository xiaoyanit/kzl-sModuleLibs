package com.kzl.lib.adapter.base;

/**
 * Project:adapter module
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 14-4-2<br/>
 * Time: 下午8:23<br/>
 * a bindable interface with a setData method
 * 数据绑定类 包含绑定的控件成员 绑定方法。
 */
public interface BaseViewHolder<D> extends UnMixable {
    /**
     * bind the data message
     *
     * @param data     the data params
     * @param position the position of data in the datasArray
     */
    public abstract<T extends D> void setData(T data, int position);

}
