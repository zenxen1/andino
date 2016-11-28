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

public class RoomChatFragment extends Fragment {
    RoomChatItemAdapter roomChatItemAdapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.roomchatfragment,null);

        ListView listView = (ListView)view.findViewById(R.id.list_view);
        roomChatItemAdapter = new RoomChatItemAdapter(getContext());
        listView.setAdapter(roomChatItemAdapter);


        return view;
    }
}
