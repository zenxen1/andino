package com.sds.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sds.server.common.ConnectionManager;
import com.sds.server.dto.Chat;
import com.sds.server.dto.NickName;

public class NickNameDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public NickNameDAO() {

	}

	
	public int update(NickName nickname){
		con=ConnectionManager.getInstance().getConnection();
		String sql="update member set m_nickname=현재 바꿀것  where m_id = 현재의 id와 같은것";
		int result=0;
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, nickname.getM_nickname());

			result=pstmt.executeUpdate();
			System.out.println("update완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public List selectOne() {

		String sql = "select*from member";
		ArrayList<NickName> list = new ArrayList<NickName>();

		try {
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()){
				NickName dto = new NickName();
				dto.setMember_sequence(rs.getInt("member_id"));
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_nickname(rs.getString("m_nickname"));
			}
			
		} catch (SQLException e) {
			System.out.println("OK");
			e.printStackTrace();
		} finally {
			ConnectionManager.getInstance().freeConnection(rs, pstmt, con);
		}
		return list;

	}
	public int updateselect(NickName nickname){
		con=ConnectionManager.getInstance().getConnection();
		String sql="update member set m_nickname=?  where m_id =?";
		int result=0;
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, nickname.getM_nickname());

			result=pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("update완료");
			sql = "select*from member";
			if(rs.next()){
				NickName dto = new NickName();
				
				dto.setM_nickname(rs.getString("m_nickname"));
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
