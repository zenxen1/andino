package com.sds.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sds.server.common.ConnectionManager;
import com.sds.server.dto.Room;

public class RoomDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public RoomDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List selectAll(){
		String sql = "select * from room";
		ArrayList<Room> list = new ArrayList<Room>();
		try {
			con = ConnectionManager.getInstance().getConnection(); 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()){
				Room dto = new Room();
				dto.setR_captain(rs.getInt("r_captain"));
				dto.setR_registtime(rs.getString("r_registtime"));
				dto.setR_title(rs.getString("r_title"));
				dto.setRoom_no(rs.getInt("room_no"));
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("³ª¿À³Ä");
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().freeConnection(rs, pstmt, con);
		}
		
		return list;
	}
}
