package com.sds.server;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ServerMain extends JFrame implements ActionListener{
	JTextArea area;
	JTextField tf_port;
	JPanel p_north;
	int port=9090;
	JButton bt_run;
	JScrollPane scroll;
	AcceptThread acceptThread;
	HashMap<Integer, Vector> roomList=new HashMap<Integer,Vector>();
	Vector<ServerThread> threadList=new Vector<ServerThread>();
	public ServerMain() {
		p_north=new JPanel();
		p_north.setLayout(new FlowLayout());
		area=new JTextArea();
		tf_port=new JTextField(Integer.toString(port));
		bt_run=new JButton("°¡µ¿");
		scroll=new JScrollPane(area);
		p_north.add(tf_port);
		p_north.add(bt_run);
		this.add(p_north,BorderLayout.NORTH);
		this.add(scroll);
		bt_run.addActionListener(this);
		setSize(600, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		acceptThread=new AcceptThread(this);
	}
	
	public static void main(String[] args) {
		new ServerMain();
	}
	
}
