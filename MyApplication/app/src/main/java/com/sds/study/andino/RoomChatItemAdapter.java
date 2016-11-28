package com.sds.study.andino;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by lee on 2016-11-26.
 */

public class RoomChatItemAdapter extends BaseAdapter{
    Context context;

    public RoomChatItemAdapter(Context context) {
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
            RoomChatItem item = new RoomChatItem(context);
            view = item;
        }else{
            RoomChatItem item = ( RoomChatItem)convertView;
            view = item;
        }
        return view;
    }
}
