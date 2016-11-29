package com.sds.server;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ServerMain {
	AcceptThread acceptThread;
	HashMap<Integer, Vector> roomList=new HashMap<Integer,Vector>();
	Vector<ServerThread> threadList=new Vector<ServerThread>();
	public ServerMain() {
		acceptThread=new AcceptThread(this);
	}
	public static void main(String[] args) {
		new ServerMain();
	}
	
}
