package com.sds.study.andino;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by song_kang on 2016-11-27.
 */

public class AddFriendItemAdapter extends BaseAdapter{
    Context context;

    public AddFriendItemAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return 12;
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
            AddFriendItem item = new AddFriendItem(context);
            view = item;
        }else{
            AddFriendItem item = (AddFriendItem)convertView;
            view = item;
        }
        return view;
    }
}
