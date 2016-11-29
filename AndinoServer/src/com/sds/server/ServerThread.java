package com.sds.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ServerThread extends Thread {
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	ServerMain serverMain;
	boolean flag=true;
	StringBuffer sb=new StringBuffer();
	public ServerThread(Socket socket,ServerMain serverMain) {
		this.socket = socket;
		this.serverMain=serverMain;
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void jsonAnalyzer(String data){
		JSONParser jsonParser=new JSONParser();
		sb.setLength(0);
		try {
			JSONObject jsonObject=(JSONObject) jsonParser.parse(data);
			String title=(String)jsonObject.get("title");
			switch(title){
			case "chat":
				String content=(String)jsonObject.get("content");
				sb.append("f");
				for(int i=0;i<serverMain.threadList.size();i++){
					((ServerThread)serverMain.threadList.get(i)).sendMsg(content);
				}
				break;
			case "login":
				break;
			
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listen() {
		String data = null;
		try {
			data = buffr.readLine();
			jsonAnalyzer(data);
			for(int i=0;i<serverMain.threadList.size();i++){
				serverMain.threadList.get(i).sendMsg(data);
			}
		} catch (IOException e) {
			flag=false;
			serverMain.threadList.remove(serverMain.threadList.indexOf(this));
			e.printStackTrace();
		}
	}

	public void sendMsg(String data) {
		try {
			buffw.write(data+"\n");
			buffw.flush();
		} catch (IOException e) {
			flag=false;
			serverMain.threadList.remove(serverMain.threadList.indexOf(this));
			e.printStackTrace();
		}
	}

	public void run() {
		while(flag){
			listen();
		}
	}
	
	

}
