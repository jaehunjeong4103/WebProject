package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Reservation;

public class ReservationService {

	public int insertReservation(Reservation reservation) {
		int result = 0;
		
		String driverName="com.mysql.cj.jdbc.Driver";
		String sql = "INSERT INTO reservation VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
		String url = "jdbc:mysql://localhost:3306/yc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "1111");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservation.getMember_id());
			pstmt.setString(2, reservation.getStay_name());
			pstmt.setString(3, reservation.getRoom_name());
			pstmt.setDate(4, reservation.getCheck_in());
			pstmt.setDate(5, reservation.getCheck_out());
			pstmt.setInt(6, reservation.getReservation_person());
			pstmt.setInt(7, reservation.getPrice());
			
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
