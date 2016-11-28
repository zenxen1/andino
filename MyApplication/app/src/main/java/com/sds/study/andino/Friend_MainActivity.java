package com.sds.study.andino;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

public class Friend_MainActivity extends AppCompatActivity {

    private ArrayList<FriendData> data=null;
    private FriendAdapter gAdapter = null;
    private ListView listView=null;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_activity_main);
        toolbar=(Toolbar)findViewById(R.id.my_toolbar);


        setSupportActionBar(toolbar);

        gAdapter = new FriendAdapter(this);
        gAdapter.addItem(new FriendData(R.drawable.i1,"강미나"));
        gAdapter.addItem(new FriendData(R.drawable.i2,"최유정"));
        gAdapter.addItem(new FriendData(R.drawable.i3,"정채연"));
        gAdapter.addItem(new FriendData(R.drawable.i4,"정하나"));
        gAdapter.addItem(new FriendData(R.drawable.i5,"김유나"));
        gAdapter.addItem(new FriendData(R.drawable.i7,"김하나"));
        gAdapter.addItem(new FriendData(R.drawable.i8,"하지원"));
        gAdapter.addItem(new FriendData(R.drawable.i9,"길라임"));
        gAdapter.addItem(new FriendData(R.drawable.i10,"박근예"));
        gAdapter.addItem(new FriendData(R.drawable.i11,"문근영"));
        gAdapter.addItem(new FriendData(R.drawable.i12,"문지영"));
        gAdapter.addItem(new FriendData(R.drawable.i13,"효린"));
        gAdapter.addItem(new FriendData(R.drawable.i14,"호비뉴"));
        gAdapter.addItem(new FriendData(R.drawable.i15,"크리스티"));
        gAdapter.addItem(new FriendData(R.drawable.i16,"한지호"));
        gAdapter.addItem(new FriendData(R.drawable.i17,"한지이"));
        gAdapter.addItem(new FriendData(R.drawable.i18,"호지연"));
        gAdapter.addItem(new FriendData(R.drawable.i19,"심재연"));

        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(gAdapter);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
