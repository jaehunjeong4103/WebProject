package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Tour;

public class TourService {
	
	public List<Tour> getTourList(){
		return getTourList("name", "", 1);
	}
	
	public List<Tour> getTourList(int page){
		return getTourList("name", "", page);
	}
	
	public List<Tour> getTourList(String field, String query, int page){

		List<Tour> list = new ArrayList<>();
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM (SELECT row_number() over(ORDER BY ID DESC) as rownum, tour.* FROM tour WHERE " + field + " like ?) n WHERE rownum BETWEEN ? AND ?";
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
				String op_cl = rs.getString("op_cl");
				String content = rs.getString("content");
				String map_path = rs.getString("map_path");
				String image_path = rs.getString("image_path");
			    
			    Tour tour = new Tour(
						id,
						group_id,
						name,
						address,
						phone,
						op_cl,
						content,
						map_path,
						image_path
						);
			    list.add(tour);
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
	
	public int getTourCount() {
		return getTourCount("name", "");
	}
	
	public int getTourCount(String field, String query) {
		
		int count = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT COUNT(ID) as count FROM (SELECT row_number() over(ORDER BY ID DESC) as rownum, tour.* FROM tour WHERE " + field + " like ?) n";
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
	
	public Tour getTour(int id) {
		
		Tour tour = null;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM tour WHERE ID = ?";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id) ;
			
			ResultSet rs = pstmt.executeQuery();
	
			if (rs.next()){
				int cid = rs.getInt("id");
				int group_id = rs.getInt("group_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String op_cl = rs.getString("op_cl");
				String content = rs.getString("content");
				String map_path = rs.getString("map_path");
				String image_path = rs.getString("image_path");
			    
			    tour = new Tour(
						cid,
						group_id,
						name,
						address,
						phone,
						op_cl,
						content,
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
				
		return tour;
	}

	public int insertTour(Tour tour) {
		int result = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "INSERT INTO tour VALUES(null, 1, ?, ?, ?, ?, ?, ?, ?)";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tour.getName());
			pstmt.setString(2, tour.getAddress());
			pstmt.setString(3, tour.getPhone());
			pstmt.setString(4, tour.getOp_cl());
			pstmt.setString(5, tour.getContent());
			pstmt.setString(6, tour.getMap_path());
			pstmt.setString(7, tour.getImage_path());
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
