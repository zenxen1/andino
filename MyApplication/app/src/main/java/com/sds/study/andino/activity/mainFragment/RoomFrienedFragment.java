package com.sds.study.andino.activity.mainFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sds.study.andino.R;
import com.sds.study.andino.adapter.RoomFriendItemAdapter;

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

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {
                onLongListItemClick(view,pos,id);
                return true;
            }
            protected void onLongListItemClick(View view, int pos, long id) {
                //Toast.makeText(getContext(), "팝업리스트보여주기", Toast.LENGTH_SHORT).show();
                PopupMenu popup = new PopupMenu(getActivity(), view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.submenu_actions, popup.getMenu());
                popup.show();
            }

        });

        return view;
    }
}
