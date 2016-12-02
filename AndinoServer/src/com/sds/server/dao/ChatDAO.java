package com.sds.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sds.server.common.ConnectionManager;
import com.sds.server.dto.Chat;

public class ChatDAO {
	
	public int insert(Chat chat){
		Connection con=ConnectionManager.getInstance().getConnection();
		String sql="insert into chat(chat_no,c_roomno,c_msg,c_me) "
				+ "values(seq_chat.nextval,?,?,?)";
		int result=0;
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, chat.getC_roomno());
			pstmt.setString(2, chat.getC_msg());
			pstmt.setInt(3, chat.getC_me());
			
			result=pstmt.executeUpdate();
			System.out.println("채팅 들어갔따");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
