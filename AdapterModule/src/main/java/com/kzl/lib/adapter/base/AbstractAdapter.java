package com.kzl.lib.adapter.base;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
/**
 * a abstract class do some job to reduce code about bind view to holder and easy on use baseAdapter
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/21<br/>
 * Time: 17:32<br/>
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractAdapter<T> extends BaseAdapter {

    protected Context context;
    protected String TAG = this.getClass().getName();
    protected LayoutInflater inflater;
    private List<T> list;

    public AbstractAdapter(Context context) {
        this(context, null);
    }

    /**
     * set the list Arrays and notify update
     *
     * @param arrayData
     */
    public void setDataArray(List<T> arrayData) {
        list.clear();
        if (arrayData != null) {
            list.addAll(arrayData);
        }
        syncNotifyDataSetChanged();
    }

    public AbstractAdapter(Context context, List<T> list) {
        this.context = context;
        if (list == null) {
            this.list = new ArrayList<T>();
        } else {
            this.list = list;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        if (list == null || list.size() == 0 || position >= list.size())
            return null;
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        //override if is multi type layout
        return super.getItemViewType(position);
    }

    /**
     * get the item layout base on viewType;
     * 获取对应itemType 的布局文件
     *
     * @param itemViewType
     * @return
     */
    protected abstract int getItemViewLayout(int itemViewType);

    /**
     * get the binder base on viewType;
     * 获取对应itemType的控件集合绑定工具
     *
     * @param itemViewType
     * @return
     */
    protected abstract BaseViewHolder<T> getItemViewHolder(int itemViewType);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);

        View currentFocus = ((Activity) context).getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
        BaseViewHolder<T> holder;
        if (convertView == null) {
            convertView = View.inflate(context, getItemViewLayout(type), null);
            holder = getItemViewHolder(type);
            ViewInjectorByReflect.injectView(holder, convertView);
            holder.setFixedData();
            convertView.setTag(holder);
        } else {
            holder = (BaseViewHolder<T>) convertView.getTag();
        }
        T data = getItem(position);

        holder.setData(data, position);
        return convertView;

    }

    /**
     * a bindable interface with a setData method
     * 数据绑定类 包含绑定的控件成员 绑定方法。
     *
     * @param <D>
     * @author davidleen29
     * @创建时间 2013年11月13日
     */
    public abstract class BaseViewHolder<D> implements UnMixable {
        /**
         * bind the data message,execute every time when getItem
         *
         * @param data     the data params
         * @param position the position of data in the datasArray
         */
        public abstract void setData(D data, int position);

        /**
         * bind the fixed data or listeners,just execute when you new a view holder
         */
        public void setFixedData() {
        }

    }

    protected Context getContext() {
        return context;
    }

    /**
     * 统一去通知数据集已更新
     */
    public synchronized void syncNotifyDataSetChanged() {
        notifyDataSetChanged();
    }
}

