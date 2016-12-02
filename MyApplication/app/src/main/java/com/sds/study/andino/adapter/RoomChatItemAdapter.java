package com.sds.study.andino.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.sds.study.andino.Item.RoomChatItem;
import com.sds.study.andino.model.dto.RoomChat;

import java.util.ArrayList;

/**
 * Created by lee on 2016-11-26.
 */

public class RoomChatItemAdapter extends BaseAdapter{
    Context context;
    public ArrayList <RoomChat> list = new ArrayList<RoomChat>();

    public RoomChatItemAdapter(Context context) {
        this.context=context;
        Toast.makeText(context, ","+list.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getCount() {
        return list.size();
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
        RoomChat roomChat = list.get(i);
        if(convertView == null){
            RoomChatItem item = new RoomChatItem(context);
            item.setData(roomChat);
            view = item;
        }else{
            RoomChatItem item = ( RoomChatItem)convertView;
            item.setData(roomChat);
            view = item;
        }
        return view;
    }
}
