package com.sds.study.andino.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.sds.study.andino.R;
import com.sds.study.andino.adapter.RoomPagerAdapter;

/**
 * Created by lee on 2016-11-25.
 */

public class RoomActivity extends AppCompatActivity {
    Toolbar room_toolbar;
    ViewPager roomPage;
    RoomPagerAdapter roomPagerAdapter;
    ImageView chatting;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roommain);

        /*fragment 정의*/
        roomPage = (ViewPager)findViewById(R.id.roomPage);
        roomPagerAdapter = new RoomPagerAdapter(getSupportFragmentManager());
        roomPage.setAdapter(roomPagerAdapter);

        /*툴바생성*/
        room_toolbar=(Toolbar)findViewById(R.id.room_toolbar);
        room_toolbar.setTitle("채팅");
        setSupportActionBar(room_toolbar);


    }

   /*메뉴부착*/
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.room_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_adduser:
                roomPage.setCurrentItem(0);
                break;
            case R.id.menu_userman:
                roomPage.setCurrentItem(1);
                break;
            case R.id.menu_chatting:
                roomPage.setCurrentItem(2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
