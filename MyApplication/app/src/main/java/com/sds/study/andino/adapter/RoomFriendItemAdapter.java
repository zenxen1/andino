package com.sds.study.andino.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sds.study.andino.Item.RoomFriendItem;
import com.sds.study.andino.R;
import com.sds.study.andino.model.dto.RoomFriend;

import java.util.ArrayList;

/**
 * Created by lee on 2016-11-26.
 */

public class RoomFriendItemAdapter extends BaseAdapter{
    Context context;
    ArrayList <RoomFriend> list = new ArrayList<RoomFriend>();
    int[] profile={R.drawable.i6,R.drawable.i9};
    String[] nickname={"방사능 토토로","성지석"};
    String[] comment={"초심으로","아힘들다"};

    public RoomFriendItemAdapter(Context context) {
        this.context=context;

        for(int i=0;i<2;i++) {
            RoomFriend roomFriend = new RoomFriend();
            roomFriend.setProfile(profile[i]);
            roomFriend.setNickname(nickname[i]);
            roomFriend.setComment(comment[i]);

            list.add(roomFriend);
        }
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
        RoomFriend roomFriend = list.get(i);
        if(convertView == null){
            RoomFriendItem item = new RoomFriendItem(context);
            item.setData(roomFriend);
            view = item;
        }else{
            RoomFriendItem item = (RoomFriendItem)convertView;
            item.setData(roomFriend);
            view = item;
        }
        return view;
    }
}
