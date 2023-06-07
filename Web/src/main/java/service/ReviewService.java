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

public class ReviewService {

	public int insertReview(Review review) {
		int result = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "INSERT INTO review VALUES(null, ?, ?, ?, ?, ?, sysdate())";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getMember_id());
			pstmt.setInt(2, review.getGroup_id());
			pstmt.setInt(3, review.getCode());
			pstmt.setString(4, review.getContent());
			pstmt.setInt(5, review.getStar());
			
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

	public List<Review> getReviewList(int codes, int group_id) {
		List<Review> list = new ArrayList<>();
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = " SELECT row_number() over(ORDER BY id DESC) as rownum, review.* FROM review WHERE code = ? and group_id = ?;";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codes) ;
			pstmt.setInt(2, group_id);
			ResultSet rs = pstmt.executeQuery();
	
			while (rs.next()){
				int id = rs.getInt("id");
				String member_id = rs.getString("member_id");
				int Rgroup_id = rs.getInt("group_id");
				int code = rs.getInt("code");
				String content = rs.getString("content");
				int star = rs.getInt("star");
				Date date_d = rs.getDate("date");
				Time date_t = rs.getTime("date");
				
				
				Review review = new Review(
						id,
						member_id,
						Rgroup_id,
						code,
						content,
						star,
						date_d,
						date_t
						);
			    list.add(review);
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
