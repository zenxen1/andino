package com.sds.study.andino.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sds.study.andino.Item.ItemLeftBaloon;
import com.sds.study.andino.Item.ItemRightBaloon;
import com.sds.study.andino.activity.ChatActivity;
import com.sds.study.andino.model.dto.Speech;

import java.util.ArrayList;

/**
 * Created by efro2 on 2016-11-25.
 */

public class BaloonAdapter extends BaseAdapter {
    public ArrayList<Speech> list=new ArrayList<Speech>();
    ChatActivity chatActivity;
    String TAG;
    public BaloonAdapter(ChatActivity chatActivity) {
        this.chatActivity = chatActivity;
        TAG=getClass().getName();
        /*Speech speech = new Speech();
        speech.setId("지석");
        speech.setContent("이젠 파일 직접 올리지 않습니다. \n메일주소 적어주시면 보내드릴게요..\n" +
                "어떤분이 다른동에 가셔서 자기거인냥");
        speech.setTime("12:42");
        for (int i=0;i<8;i++) {
            list.add(speech);
        }*/
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Speech dto=(Speech) list.get(i);
        if(dto.getId().equals("0")) {
            view = new ItemRightBaloon(chatActivity, dto);
        }else{
            view=new ItemLeftBaloon(chatActivity,dto);
        }
        return view;
    }
}
