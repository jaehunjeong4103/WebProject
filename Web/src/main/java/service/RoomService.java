package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Room;

public class RoomService {

	public int insertRoom(Room room) {
		int result = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
<<<<<<< HEAD
		String sql = "INSERT INTO room VALUES(null, ?, ?, ?, ?, ?, ?)";
=======
		String sql = "INSERT INTO room VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
>>>>>>> 40c60906ea8f5554777666d9de9afe21a40119e0
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
<<<<<<< HEAD
=======
			pstmt.setDate(8,(java.sql.Date) room.getStart_day());
			pstmt.setDate(9,(java.sql.Date) room.getStart_day());
>>>>>>> 40c60906ea8f5554777666d9de9afe21a40119e0
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
<<<<<<< HEAD
=======
				Date start_day = rs.getDate("start_day");
				Date end_day = rs.getDate("end_day");
>>>>>>> 40c60906ea8f5554777666d9de9afe21a40119e0
				
				Room room = new Room(
						rid,
						stay_name,
						room_name,
						max_person,
						weekend_price,
						weekday_price,
<<<<<<< HEAD
						option
=======
						option,
						start_day,
						end_day
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

	public List<Room> getRoomList(String name, String s_day, String e_day) {
		List<Room> list = new ArrayList<>();
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM room WHERE (stay_name = ?) and (start_day > ? OR end_day < ?) OR (start_day IS NULL OR end_day IS NULL);";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, e_day);
			pstmt.setString(3, s_day);
			ResultSet rs = pstmt.executeQuery();
	
			while (rs.next()){
				int id = rs.getInt("id");
				String stay_name = rs.getString("stay_name");
				String room_name = rs.getString("name");
				int max_person = rs.getInt("max_person");
				String weekend_price = rs.getString("weekend_price");
				String weekday_price = rs.getString("weekday_price");
				String option = rs.getString("option");
				Date start_day = rs.getDate("start_day");
				Date end_day = rs.getDate("end_day");
				
				Room room = new Room(
						id,
						stay_name,
						room_name,
						max_person,
						weekend_price,
						weekday_price,
						option,
						start_day,
						end_day
>>>>>>> 40c60906ea8f5554777666d9de9afe21a40119e0
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

	public Room getRoom(String s_name, String r_name) {
		Room room = new Room();
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM room where stay_name = ? and name = ?";
		String url = "jdbc:mysql://localhost:3306/yc";

		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_name);
			pstmt.setString(2, r_name);
			ResultSet rs = pstmt.executeQuery();
	
			if (rs.next()){
				int id = rs.getInt("id");
				String stay_name = rs.getString("stay_name");
				String room_name = rs.getString("name");
				int max_person = rs.getInt("max_person");
				String weekend_price = rs.getString("weekend_price");
				String weekday_price = rs.getString("weekday_price");
				String option = rs.getString("option");
				Date start_day = rs.getDate("start_day");
				Date end_day = rs.getDate("end_day");
				
				room = new Room(
						id,
						stay_name,
						room_name,
						max_person,
						weekend_price,
						weekday_price,
<<<<<<< HEAD
						option
=======
						option,
						start_day,
						end_day
>>>>>>> 40c60906ea8f5554777666d9de9afe21a40119e0
						);
			    
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return room;
	}

	

	

}
