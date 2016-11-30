package com.sds.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sds.server.dao.RoomDAO;
import com.sds.server.dto.Room;

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
		System.out.println(data);
		JSONParser jsonParser=new JSONParser();
		sb.setLength(0);
		try {
			JSONObject jsonObject=(JSONObject) jsonParser.parse(data);
			String title=(String)jsonObject.get("title");
			switch(title){
			case "chat2":
				String content=(String)jsonObject.get("content");
				sb.append("{");
				sb.append("\"title\":\"chat\",");
				sb.append("\"id\":3,");
				sb.append("\"content\":\""+jsonObject.get("content")+"\"");
				sb.append("}");
				serverMain.area.append((String) jsonObject.get("content")+"\n");
				for(int i=0;i<serverMain.threadList.size();i++){
					((ServerThread)serverMain.threadList.get(i)).sendMsg(sb.toString());
				}
				break;
			case "login":
				break;
			case "chat":
				RoomDAO dao = new RoomDAO();
				List<Room> list = dao.selectAll();
				sb.append("{");
				sb.append("\"title\":\"roomList\",");
				sb.append("\"roomList\":");
				sb.append("[");
				for(int i=0;i<list.size();i++){
					Room dto = list.get(i);
					sb.append("{");
					sb.append("\"content\":\""+dto.getR_title()+"\"");
					if(i<list.size()-1){
						sb.append("},");
					}else{
						sb.append("}");
					}
				}
				sb.append("]");
				sb.append("}");
				System.out.println(list.size()+","+sb.toString());
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
