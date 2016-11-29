package com.sds.study.andino.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.sds.study.andino.Item.ItemView_talk;
import com.sds.study.andino.adapter.FriendAdapter_talk;
import com.sds.study.andino.model.dto.FriendData_talk;
import com.sds.study.andino.R;

import java.util.ArrayList;

public class MainActivity_talk extends AppCompatActivity {

    private ArrayList<FriendData_talk> data = null;
    private FriendAdapter_talk gAdapter = null;
    private ListView listView = null;
    Toolbar toolbar;
    ImageView plus, invite_back, bell,bell2,star;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talk_invite_main);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar2);


        setSupportActionBar(toolbar);

        gAdapter = new FriendAdapter_talk(this);
        gAdapter.addItem(new FriendData_talk(R.drawable.i1, "강미나"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i2, "최유정"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i3, "정채연"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i4, "정하나"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i5, "김유나"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i7, "김하나"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i8, "하지원"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i9, "길라임"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i10, "박근예"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i11, "문근영"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i12, "문지영"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i13, "효린"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i14, "호비뉴"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i15, "크리스티"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i16, "한지호"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i17, "한지이"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i18, "호지연"));
        gAdapter.addItem(new FriendData_talk(R.drawable.i19, "심재연"));

        listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(gAdapter);
        plus=(ImageView)findViewById(R.id.plus);
        invite_back=(ImageView)findViewById(R.id.invite_back);
        bell=(ImageView)findViewById(R.id.bell);

        star=(ImageView)findViewById(R.id.star);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"친구 초대 화면으로 이동",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(),Friend_MainActivity.class);
                startActivity(intent);
            }
        });

        invite_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"채팅화면으로 이동",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),ChatActivity.class);
                startActivity(intent);
            }
        });

        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"벨 눌렀어?",Toast.LENGTH_SHORT).show();
            }
        });

        bell.setOnClickListener(new View.OnClickListener() {

            boolean flag=false;
            public void onClick(View view) {

                if(!flag) {
                    Toast.makeText(getBaseContext(),"알림켜기",Toast.LENGTH_SHORT).show();
                    bell.setImageResource(R.drawable.bell2);
                    flag=!flag;
                }else{
                    Toast.makeText(getBaseContext(),"알림끄기기",Toast.LENGTH_SHORT).show();
                    bell.setImageResource(R.drawable.bell);
                    flag=!flag;
                }
            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            boolean flag=false;
            public void onClick(View view) {

                if(!flag) {
                    Toast.makeText(getBaseContext(),"즐겨찾기 방으로 설정",Toast.LENGTH_SHORT).show();
                    star.setImageResource(R.drawable.star2);
                    flag=!flag;
                }else{
                    Toast.makeText(getBaseContext(),"즐겨찾기 방으로 설정 해제",Toast.LENGTH_SHORT).show();
                    star.setImageResource(R.drawable.star);
                    flag=!flag;
                }
            }
        });

      /*  LinearLayout layout = (LinearLayout)findViewById(R.id.layout);

        FriendData_talk friendData_talk=new FriendData_talk();
        ItemView_talk itemView_talk = new ItemView_talk(this,friendData_talk);*/



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),gAdapter.getItem(i)+"눌렀어?",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.talk_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
