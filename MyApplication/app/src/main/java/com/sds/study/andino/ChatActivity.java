package com.sds.study.andino;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by efro2 on 2016-11-25.
 */

public class ChatActivity extends AppCompatActivity {
    ListView listView;
    BaloonAdapter baloonAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //-----------------------------------roomchat에서 인텐트 받아오기
        //room_id,자신의 member_id,같이 채팅하는 사람들 id를 받아와서 db에서 이미지 정보등을 받아온다.

        //-------------------------------------------------------
        setContentView(R.layout.jsactivity_layout);
        listView=(ListView)findViewById(R.id.listView);
        BaloonAdapter baloonAdapter=new BaloonAdapter(this);
        listView.setAdapter(baloonAdapter);
    }
    //---------------서버 접속

    //-----------------------------스트림 획득

    //-----------------------------------채팅버튼 눌렀을 시 갱신

    //------------------------------------
}
