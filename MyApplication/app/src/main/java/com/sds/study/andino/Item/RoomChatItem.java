package com.sds.study.andino.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sds.study.andino.R;
import com.sds.study.andino.model.dto.RoomChat;

/**
 * Created by lee on 2016-11-26.
 */

public class RoomChatItem extends LinearLayout{
    Context context;
    public RoomChatItem(Context context) {
        super(context);
        this.context=context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.roomchatitem,this);
    }

    public void setData(RoomChat roomChat){
        TextView content = (TextView)this.findViewById(R.id.content);

        content.setText(roomChat.getContent());
    }
}
