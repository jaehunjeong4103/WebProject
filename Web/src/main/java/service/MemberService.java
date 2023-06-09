package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Member;
import entity.Tour;

public class MemberService {
	
	public int insertMember(Member member) {
		int result = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?)";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getGender());
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
	
	public Member checkMemberId(String id) {
		Member member = null;

		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM member WHERE id = ?";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
		
			if (rs.next()) {
				String cid = rs.getString("id"); 
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				
				member = new Member(cid, password, name, phone, email, gender);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return member;
	}
	
	public Member checkMember(String id, String password) {
		Member member = null;

		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM member WHERE id = ? and password = ?";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
		
			if (rs.next()) {
				String cid = rs.getString("id"); 
				String cpassword = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				
				member = new Member(cid, cpassword, name, phone, email, gender);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return member;
	}

	public Member getMember(String id) {
		Member member = null;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "SELECT * FROM member where id = ?";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id) ;
			ResultSet rs = pstmt.executeQuery();
	
			if (rs.next()){
				String cid = rs.getString("id"); 
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
			    
			    member = new Member(
						cid,
						password,
						name,
						phone,
						email,
						gender
						);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	public int updateMember(Member member) {
		int result = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "UPDATE member SET password = ?, name = ?, phone = ?, email = ?, gender = ? where id = ?";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getId());
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
