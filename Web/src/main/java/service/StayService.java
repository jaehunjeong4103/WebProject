package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Stay;
import entity.Tour;

public class StayService {
	
	public List<Stay> getStayList() {
		return getStayList("name", "", 1);
	}

	public List<Stay> getStayList(int page) {
		return getStayList("name", "", page);
	}
	
	public List<Stay> getStayList(String field, String query, int page) {
		List<Stay> list = new ArrayList<>();
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM (SELECT row_number() over(ORDER BY ID DESC) as rownum, stay.* FROM stay WHERE " + field + " like ?) n WHERE rownum BETWEEN ? AND ?";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%") ;
			pstmt.setInt(2, 1+(page-1)*5);
			pstmt.setInt(3, page*5);
			ResultSet rs = pstmt.executeQuery();
	
			while (rs.next()){
				int id = rs.getInt("id");
				int group_id = rs.getInt("group_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String check_in = rs.getString("check_in");
				String map_path = rs.getString("map_path");
				String image_path = rs.getString("image_path");
			    
			    Stay stay = new Stay(
						id,
						group_id,
						name,
						address,
						phone,
						check_in,
						map_path,
						image_path
						);
			    list.add(stay);
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

	public int getStayCount(String field, String query) {
		int count = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT COUNT(ID) as count FROM (SELECT row_number() over(ORDER BY ID DESC) as rownum, stay.* FROM stay WHERE " + field + " like ?) n";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%") ;
			ResultSet rs = pstmt.executeQuery();
	
			if (rs.next()){
				count = rs.getInt("count");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	public Stay getStay(int id) {
		Stay stay = null;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM stay WHERE ID = ?";
		String url = "jdbc:mysql://localhost:3306/yc";
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id) ;
			
			ResultSet rs = pstmt.executeQuery();
	
			if (rs.next()){
				int sid = rs.getInt("id");
				int group_id = rs.getInt("group_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String check_in = rs.getString("check_in");
				String map_path = rs.getString("map_path");
				String image_path = rs.getString("image_path");
						
			    stay = new Stay(
						sid,
						group_id,
						name,
						address,
						phone,
						check_in,
						map_path,
						image_path
						);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return stay;
	}
	
	public Stay getStay(String stay_name) {
		Stay stay = null;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM stay WHERE NAME = ?";
		String url = "jdbc:mysql://localhost:3306/yc";
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stay_name) ;
			
			ResultSet rs = pstmt.executeQuery();
	
			if (rs.next()){
				int sid = rs.getInt("id");
				int group_id = rs.getInt("group_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String check_in = rs.getString("check_in");
				String map_path = rs.getString("map_path");
				String image_path = rs.getString("image_path");
						
			    stay = new Stay(
						sid,
						group_id,
						name,
						address,
						phone,
						check_in,
						map_path,
						image_path
						);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return stay;
	}

	public int insertStay(Stay stay) {
		int result = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "INSERT INTO stay VALUES(null, 4, ?, ?, ?, ?, ?, ?)";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stay.getName());
			pstmt.setString(2, stay.getAddress());
			pstmt.setString(3, stay.getPhone());
			pstmt.setString(4, stay.getCheck_in());
			pstmt.setString(5, stay.getMap_path());
			pstmt.setString(6, stay.getImage_path());
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

	

}
