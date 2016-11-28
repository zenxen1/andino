package com.sds.study.andino.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.sds.study.andino.R;

/**
 * Created by lee on 2016-11-26.
 */

public class RoomFriendItem extends LinearLayout{
    Context context;
    public RoomFriendItem(Context context) {
        super(context);
        this.context=context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.roomfrienditem,this);
    }
}
