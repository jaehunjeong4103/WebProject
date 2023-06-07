package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Review;
import entity.Room;

public class RoomService {

	public int insertRoom(Room room) {
		int result = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "INSERT INTO room VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, room.getName());
			pstmt.setString(2, room.getStay_name());
			pstmt.setInt(3, room.getMax_person());
			pstmt.setString(4, room.getWeekend_price());
			pstmt.setString(5, room.getWeekday_price());
			pstmt.setString(6, room.getOption());
			pstmt.setString(7, room.getImage_path());
			result = pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public List<Room> getRoomList(int id, String name) {
		List<Room> list = new ArrayList<>();
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM room where stay_name = ?";
		String url = "jdbc:mysql://localhost:3306/yc";

		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name) ;
			ResultSet rs = pstmt.executeQuery();
	
			while (rs.next()){
				int rid = rs.getInt("id");
				String stay_name = rs.getString("stay_name");
				String room_name = rs.getString("name");
				int max_person = rs.getInt("max_person");
				String weekend_price = rs.getString("weekend_price");
				String weekday_price = rs.getString("weekday_price");
				String option = rs.getString("option");
				String image_path = rs.getString("image_path");
				
				Room room = new Room(
						rid,
						stay_name,
						room_name,
						max_person,
						weekend_price,
						weekday_price,
						option,
						image_path
						);
			    list.add(room);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	

	

}
