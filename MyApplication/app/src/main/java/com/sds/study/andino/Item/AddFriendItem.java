package com.sds.study.andino.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.sds.study.andino.R;

/**
 * Created by song_kang on 2016-11-27.
 */

public class AddFriendItem extends LinearLayout {
    Context context;
    public AddFriendItem(Context context) {
        super(context);
        this.context=context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.addfrienditem,this);
    }

    public void addFriend(){

    }
}
