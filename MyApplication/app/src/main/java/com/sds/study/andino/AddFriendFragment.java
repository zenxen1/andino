package com.sds.study.andino;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by song_kang on 2016-11-27.
 */

public class AddFriendFragment extends Fragment {
    AddFriendItemAdapter addFriendItemAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.addfriendfragment,null);

        ListView listView = (ListView)view.findViewById(R.id.listView);
        addFriendItemAdapter = new AddFriendItemAdapter(getContext());
        listView.setAdapter(addFriendItemAdapter);


        return view;

    }

    public void addFriend(){
        Toast.makeText(getContext(), "친구맺기 메서드 작성하기", Toast.LENGTH_SHORT).show();
    }
}
