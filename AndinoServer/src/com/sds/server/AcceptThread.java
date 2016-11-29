package com.sds.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptThread extends Thread{
	int port=9090;
	ServerSocket serverSocket;
	ServerMain serverMain;
	boolean flag=true;
	public AcceptThread(ServerMain serverMain) {
		this.serverMain=serverMain;
		try {
			serverSocket=new ServerSocket(port);
			serverMain.area.append("서버가동\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.start();
	}
	
	public void run() {
		while(flag){
			try {
				Socket socket=serverSocket.accept();
				ServerThread serverThread=new ServerThread(socket,serverMain);
				serverThread.start();
				serverMain.area.append("접속자 감지"+socket.getInetAddress().getHostAddress()+"\n");
				serverMain.threadList.add(serverThread);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
