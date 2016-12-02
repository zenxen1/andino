package com.sds.study.andino.network;

import android.content.pm.PackageInfo;
import android.util.Log;

import com.sds.study.andino.activity.ChatActivity;
import com.sds.study.andino.activity.LoginActivity;
import com.sds.study.andino.activity.RoomActivity;
import com.sds.study.andino.activity.mainFragment.RoomChatFragment;
import com.sds.study.andino.model.dto.RoomChat;
import com.sds.study.andino.model.dto.Speech;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by efro2 on 2016-11-29.
 */

public class ClientThread extends Thread {
    BufferedReader buffr;
    BufferedWriter buffw;
    boolean flag = true;
    PackageInfo info;
    String TAG;
    private static ClientThread instance;

    private ClientThread() {
        TAG = this.getClass().getName();
        try {
            buffr = new BufferedReader(new InputStreamReader(LoginActivity.socket.getInputStream(), "utf-8"));
            buffw = new BufferedWriter(new OutputStreamWriter(LoginActivity.socket.getOutputStream(), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ClientThread getInstance() {
        if (instance == null) {
            instance = new ClientThread();
        }
        return instance;
    }

    public void listen() {
        try {
            String data = buffr.readLine();
            jsonAnalyzer(data);
        } catch (IOException e) {
            freeConnection();
            flag = !flag;
            e.printStackTrace();
        }
    }

    public void sendMsg(String data) {
        try {
            Log.d(TAG, data);
            buffw.write(data + "\n");
            buffw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (flag) {
            listen();
        }

    }

    public void jsonAnalyzer(String data) {
        try {
            Log.d(TAG, data);
            JSONObject jsonObject = new JSONObject(data);
            String title = (String) jsonObject.getString("title");
            if (title.equals("chat")) {
                Speech speech = new Speech();
                speech.setId(jsonObject.getString("id"));
                speech.setContent(jsonObject.getString("content"));
                speech.setTime("11:00");
                ChatActivity.chatActivity.baloonAdapter.list.add(speech);
                ChatActivity.chatActivity.handler.sendEmptyMessage(0);
            }else if(title.equals("roomList")){
                Log.d(TAG,"들어오냐??");
                JSONArray jsonArray = jsonObject.getJSONArray("roomList");
                for(int i=0;i<1;i++){
                    JSONObject obj = jsonArray.getJSONObject(i);
                    RoomChat roomChat = new RoomChat();
                    roomChat.setContent(obj.getString("content"));
                    RoomChatFragment roomChatFragment = (RoomChatFragment) RoomActivity.roomActivity.roomPagerAdapter.getItem(2);
                    Log.d(TAG,"프레그먼트는 있나?"+roomChatFragment);
                    Log.d(TAG,"아이템어탭터 있나?"+ roomChatFragment.roomChatItemAdapter);
                    Log.d(TAG,"리스트 있나?"+roomChatFragment.roomChatItemAdapter.list);
                    ArrayList list = roomChatFragment.roomChatItemAdapter.list;
                    list.add(roomChat);
                    Log.d(TAG,"채팅방 리스트 사이즈"+list.size());
                    RoomActivity.roomActivity.handler.sendEmptyMessage(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void freeConnection() {
        if (buffr != null) {
            try {
                buffr.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        buffr = null;
        if (buffw != null) {
            try {
                buffw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        buffw = null;
        if (LoginActivity.socket != null) {
            try {
                LoginActivity.socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        LoginActivity.socket = null;
    }
}
