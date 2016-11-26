package com.sds.study.andino;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by lee on 2016-11-26.
 */

public class RoomFrienedFragment extends Fragment {
    RoomFriendItemAdapter roomFriendItemAdapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.roomfriendfragment,null);

        ListView listView = (ListView)view.findViewById(R.id.list_view);
        roomFriendItemAdapter = new RoomFriendItemAdapter(getContext());
        listView.setAdapter(roomFriendItemAdapter);


        return view;
    }
}
