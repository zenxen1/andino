package com.sds.study.andino;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by lee on 2016-11-26.
 */

public class RoomChatFragment extends Fragment {
    RoomChatItemAdapter roomChatItemAdapter;
    ImageView chatting;
    Context context;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.roomchatfragment, null);

        ListView listView = (ListView) view.findViewById(R.id.list_view);
        roomChatItemAdapter = new RoomChatItemAdapter(getContext());
        listView.setAdapter(roomChatItemAdapter);
        context = getContext();
       // RoomChatItem roomChatItem = new RoomChatItem(getContext());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "채팅화면으로 이동!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ChatActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
