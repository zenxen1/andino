package com.sds.study.andino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity_talk extends AppCompatActivity {

    private ArrayList<FriendData_talk> data = null;
    private FriendAdapter_talk gAdapter = null;
    private ListView listView = null;
    Toolbar toolbar;
    ImageView plus, invite_back;



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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.talk_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
