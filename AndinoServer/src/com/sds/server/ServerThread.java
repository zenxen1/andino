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
import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sds.server.common.ConnectionManager;
import com.sds.server.dao.ChatDAO;
import com.sds.server.dao.NickNameDAO;
import com.sds.server.dao.RoomDAO;
import com.sds.server.dto.Chat;
import com.sds.server.dto.NickName;
import com.sds.server.dto.Room;

public class ServerThread extends Thread {
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	ServerMain serverMain;
	boolean switcher = true;
	Connection con;
	PreparedStatement pstmt;

	boolean flag = true;
	StringBuffer sb = new StringBuffer();

	public ServerThread(Socket socket, ServerMain serverMain) {
		
		StringBuffer sb = new StringBuffer();

		

		this.socket = socket;
		this.serverMain = serverMain;

		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void jsonAnalyzer(String data) {
		System.out.println(data);
		JSONParser jsonParser = new JSONParser();
		sb.setLength(0);
		try {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(data);
			String title = (String) jsonObject.get("title");
			switch (title) {
			case "chat":

				String content = (String) jsonObject.get("content");
				String id = (String) jsonObject.get("id");
				ChatDAO chatDAO = new ChatDAO();
				Chat chat = new Chat();
				chat.setC_msg(content);
				chat.setC_roomno(1);
				chat.setC_me(Integer.parseInt(id));
				int answer = chatDAO.insert(chat);
				sb.append("{");
				sb.append("\"title\":\"chat\",");
				if (switcher) {

					sb.append("\"id\":\"0\",");
				} else {
					sb.append("\"id\":\"1\",");
				}
				switcher = !switcher;
				sb.append("\"content\":\"" + jsonObject.get("content") + "\"");

				sb.append("}");
				serverMain.area.append((String) jsonObject.get("content") + "\n");
				for (int i = 0; i < serverMain.threadList.size(); i++) {
					((ServerThread) serverMain.threadList.get(i)).sendMsg(sb.toString());
				}
				break;
			case "regist":
				con = ConnectionManager.getInstance().getConnection();
				System.out.println("db생성");
				String sql = "insert into member(member_id,id,pwd,name,nickname)";
				sql = sql + " values(seq_member.nextval,?,?,?,?)";
				System.out.println(sql);

				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, (String) jsonObject.get("id"));
					pstmt.setString(2, (String) jsonObject.get("password"));
					pstmt.setString(3, (String) jsonObject.get("name"));
					pstmt.setString(4, (String) jsonObject.get("nickname"));

					int result = pstmt.executeUpdate();
					serverMain.area.append("\n" + sb);
					sb.delete(0, sb.length());

					if (result != -1) {
						System.out.println("등록 실패");
					} else {
						System.out.println("등록 성공");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "roomList":
				RoomDAO dao = new RoomDAO();
				List<Room> list = dao.selectAll();
				sb.append("{");
				sb.append("\"title\":\"roomList\",");
				sb.append("\"roomList\":");
				sb.append("[");
				for (int i = 0; i < list.size(); i++) {
					Room dto = list.get(i);
					sb.append("{");
					sb.append("\"content\":\"" + dto.getR_title() + "\"");
					if (i < list.size() - 1) {
						sb.append("},");
					} else {
						sb.append("}");
					}
				}
				sb.append("]");
				sb.append("}");

				System.out.println(list.size()+","+sb.toString());
				for(int i=0;i<serverMain.threadList.size();i++){
					((ServerThread)serverMain.threadList.get(i)).sendMsg(sb.toString());
				}
				break;

			case "nickname":
				String nickname = (String) jsonObject.get("nickname");
				NickNameDAO nickdao = new NickNameDAO();
				NickName nick=new NickName();
				int nicklist = nickdao.updateselect(nick);
				sb.append("{");
				sb.append("\"title\":\"nickname\",");
				sb.append("\"nickname\":\"" + jsonObject.get("nickname") + "\"");
				sb.append("}");
				for (int i = 0; i < serverMain.threadList.size(); i++) {
					((ServerThread) serverMain.threadList.get(i)).sendMsg(sb.toString());
				}
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
			flag = false;
			serverMain.threadList.remove(serverMain.threadList.indexOf(this));
			e.printStackTrace();
		}
	}

	public void sendMsg(String data) {
		try {
			buffw.write(data + "\n");
			buffw.flush();
		} catch (IOException e) {
			flag = false;
			serverMain.threadList.remove(serverMain.threadList.indexOf(this));
			e.printStackTrace();
		}
	}

	public void run() {
		while (flag) {
			listen();
		}
	}

}
