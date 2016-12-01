package com.sds.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sds.server.common.ConnectionManager;
import com.sds.server.dto.NickName;

public class NickNameDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public NickNameDAO() {

	}

	public List selectAll() {

		String sql = "select*from member";
		ArrayList<NickName> list = new ArrayList<NickName>();

		try {
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				NickName dto = new NickName();
				dto.setMember_id(rs.getInt("member_id"));
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_nickname(rs.getString("m_nickname"));
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("OK");
			e.printStackTrace();
		} finally {
			ConnectionManager.getInstance().freeConnection(rs, pstmt, con);
		}
		return list;

	}

}
