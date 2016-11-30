package com.sds.study.andino.network;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.sds.study.andino.activity.ChatActivity;
import com.sds.study.andino.activity.LoginActivity;
import com.sds.study.andino.activity.RoomActivity;
import com.sds.study.andino.model.dto.Speech;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by efro2 on 2016-11-29.
 */

public class ClientThread extends Thread {
    BufferedReader buffr;
    BufferedWriter buffw;
    boolean flag=true;
    PackageInfo info;
    String TAG;
    private static ClientThread instance;
    private ClientThread() {
        TAG=this.getClass().getName();
        try {
            buffr=new BufferedReader(new InputStreamReader(LoginActivity.socket.getInputStream(),"utf-8"));
            buffw=new BufferedWriter(new OutputStreamWriter(LoginActivity.socket.getOutputStream(),"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ClientThread getInstance(){
        if(instance==null){
            instance=new ClientThread();
        }

        return instance;
    }

    public void listen(){
        try {
            String data=buffr.readLine();
            jsonAnalyzer(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMsg(String data){
        try {
            buffw.write(data+"\n");
            buffw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (flag){
            listen();
        }
    }
    public void jsonAnalyzer(String data){
        try {
            Log.d(TAG,data);
            JSONObject jsonObject=new JSONObject(data);
            String title=(String)jsonObject.getString("title");
            if(title.equals("chat")){
                Speech speech=new Speech();
                speech.setId(jsonObject.getString("id"));
                speech.setContent(jsonObject.getString("content"));
                speech.setTime("11:00");
                ChatActivity.chatActivity.baloonAdapter.list.add(speech);
                ChatActivity.chatActivity.handler.sendEmptyMessage(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
