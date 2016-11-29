package com.sds.server.dto;

public class chat {
	
	private int chat_no;
	private int c_roomno;
	private String c_msg;
	private int c_me;
	private String c_time;
	
	public int getChat_no() {
		return chat_no;
	}
	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}
	public int getC_roomno() {
		return c_roomno;
	}
	public void setC_roomno(int c_roomno) {
		this.c_roomno = c_roomno;
	}
	public String getC_msg() {
		return c_msg;
	}
	public void setC_msg(String c_msg) {
		this.c_msg = c_msg;
	}
	public int getC_me() {
		return c_me;
	}
	public void setC_me(int c_me) {
		this.c_me = c_me;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
	
	

}
