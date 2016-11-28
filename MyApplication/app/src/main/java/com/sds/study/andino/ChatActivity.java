package com.sds.study.andino;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by efro2 on 2016-11-25.
 */

public class ChatActivity extends AppCompatActivity {
    ListView listView;
    BaloonAdapter baloonAdapter;
    ImageView js_to_invite, js_chat_back;
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

        js_to_invite=(ImageView)findViewById(R.id.js_to_invite);
        js_chat_back=(ImageView)findViewById(R.id.js_chat_back);
        js_to_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"친구 초대 화면으로 이동",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity_talk.class);
                startActivity(intent);
            }
        });

        js_chat_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RoomActivity.class);
                startActivity(intent);
            }
        });



    }
    //---------------서버 접속

    //-----------------------------스트림 획득

    //-----------------------------------채팅버튼 눌렀을 시 갱신

    //------------------------------------
}
