package com.sds.study.andino.network;

import com.sds.study.andino.activity.RoomActivity;

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
    RoomActivity roomActivity;
    BufferedReader buffr;
    BufferedWriter buffw;
    Socket socket;
    boolean flag=true;
    public ClientThread(RoomActivity roomActivity) {
        this.roomActivity=roomActivity;
        this.socket=roomActivity.socket;
        try {
            buffr=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
            buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listen(){
        try {
            String data=buffr.readLine();
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
}
