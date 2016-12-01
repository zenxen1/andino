package com.sds.study.andino.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.sds.study.andino.adapter.BaloonAdapter;
import com.sds.study.andino.R;
import com.sds.study.andino.network.ClientThread;

/**
 * Created by efro2 on 2016-11-25.
 */

public class ChatActivity extends AppCompatActivity {
    ListView listView;
    public BaloonAdapter baloonAdapter;
    ImageView js_to_invite, js_chat_back;
    EditText txt_send;
    Button bt_send;
    String TAG;
    public Handler handler;
    public static ChatActivity chatActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //-----------------------------------roomchat에서 인텐트 받아오기
        //room_id,자신의 member_id,같이 채팅하는 사람들 id를 받아와서 db에서 이미지 정보등을 받아온다.

        //-------------------------------------------------------
        chatActivity=this;
        TAG=getClass().getName();
        setContentView(R.layout.chatactivity_layout);
        listView=(ListView)findViewById(R.id.listView);
        baloonAdapter=new BaloonAdapter(this);
        listView.setAdapter(baloonAdapter);
        init();
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                baloonAdapter.notifyDataSetChanged();
            }
        };
    }
    public void btnClick(View view){
        StringBuffer sb=new StringBuffer();

        sb.append("{");
        sb.append("\"title\":\"chat\",");
        sb.append("\"id\":\"1\",");
        sb.append("\"content\":\""+txt_send.getText().toString()+"\"");
        sb.append("}");
        ClientThread.getInstance().sendMsg(sb.toString());
    }
    public void init(){
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
        bt_send=(Button)findViewById(R.id.bt_send);
        txt_send=(EditText)findViewById(R.id.txt_send);
    }

}
