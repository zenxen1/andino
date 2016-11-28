package com.sds.study.andino.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sds.study.andino.Item.RoomFriendItem;

/**
 * Created by lee on 2016-11-26.
 */

public class RoomFriendItemAdapter extends BaseAdapter{
    Context context;

    public RoomFriendItemAdapter(Context context) {
        this.context=context;

    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = null;
        if(convertView == null){
            RoomFriendItem item = new RoomFriendItem(context);
            view = item;
        }else{
            RoomFriendItem item = (RoomFriendItem)convertView;
            view = item;
        }
        return view;
    }
}
