package com.sds.study.andino.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.sds.study.andino.R;
import com.sds.study.andino.adapter.RoomPagerAdapter;
import com.sds.study.andino.network.ClientThread;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by lee on 2016-11-25.
 */

public class RoomActivity extends AppCompatActivity {
    Toolbar room_toolbar;
    ViewPager roomPage;
    RoomPagerAdapter roomPagerAdapter;
    ImageView chatting;
    public Socket socket;
    public static ClientThread clientThread;//서버 요청시  사용 할것
    String ip = "192.168.0.28";//필요한 아이피로 바꿀것
    int port = 9090;
    RoomActivity roomActivity;
    String TAG;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.roomActivity = this;
        TAG = this.getClass().getName();
        connect();
        setContentView(R.layout.roommain);

        /*fragment 정의*/
        roomPage = (ViewPager) findViewById(R.id.roomPage);
        roomPagerAdapter = new RoomPagerAdapter(getSupportFragmentManager());
        roomPage.setAdapter(roomPagerAdapter);

        /*툴바생성*/
        room_toolbar = (Toolbar) findViewById(R.id.room_toolbar);
        room_toolbar.setTitle("채팅");
        setSupportActionBar(room_toolbar);

       // friendList();

    }

    public void friendList(){
        StringBuffer sb=new StringBuffer();

        sb.append("{");
        sb.append("\"title\":\"friendList\",");
        sb.append("\"content\":\"1\"");
        sb.append("}");
        if(clientThread!=null) {
            clientThread.sendMsg(sb.toString());
        }
        Log.d(TAG,sb.toString());
    }

    /*메뉴부착*/
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.room_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
    //서버와 연결
    public void connect(){
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    socket = new Socket(ip, port);//서버 연결

                    clientThread = new ClientThread(roomActivity);
                    clientThread.start();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
