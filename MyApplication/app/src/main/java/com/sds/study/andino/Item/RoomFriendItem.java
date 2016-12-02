package com.sds.study.andino.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sds.study.andino.R;
import com.sds.study.andino.model.dto.RoomChat;
import com.sds.study.andino.model.dto.RoomFriend;

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
    public void setData(RoomFriend roomFriend) {
        TextView nickname = (TextView) findViewById(R.id.nickname);
        TextView comment = (TextView) findViewById(R.id.comment);
        ImageView profile = (ImageView)findViewById(R.id.profile);

        profile.setImageResource(roomFriend.getProfile());
        nickname.setText(roomFriend.getNickname());
        comment.setText(roomFriend.getComment());
    }
}
