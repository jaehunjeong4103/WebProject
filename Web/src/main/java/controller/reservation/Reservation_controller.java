package controller.reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import entity.Reservation;
import entity.Room;
import service.ReservationService;
import service.RoomService;

@WebServlet("/view/reservation/reservation")
public class Reservation_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String stay_name = request.getParameter("stay_name");
		String room_name = request.getParameter("room_name");
		String res_date = request.getParameter("res_date");
		
		RoomService room_service = new RoomService();
		Room room = room_service.getRoom(stay_name, room_name);		
		
		String wep_ = room.getWeekend_price();
		int wep=0;
		if (wep_ != null && !wep_.equals("")) {
			wep = Integer.parseInt(wep_);
		}
		
		String wap_ = room.getWeekend_price();
		int wap=0;
		if (wap_ != null && !wap_.equals("")) {
			wap = Integer.parseInt(wap_);
		}
		
		String wec_ = request.getParameter("weekend_count");
		int wec=0;
		if (wec_ != null && !wec_.equals("")) {
			wec = Integer.parseInt(wec_);
		}
		
		String wac_ = request.getParameter("weekday_count");
		int wac=0;
		if (wac_ != null && !wac_.equals("")) {
			wac = Integer.parseInt(wac_);
		}
		
		String check_in = request.getParameter("check_in");
		String check_out = request.getParameter("check_out");
		int price = (wep*wec)+(wap*wac);
		
		HttpSession session = request.getSession();
		session.setAttribute("stay_name", stay_name);
		session.setAttribute("room_name", room_name);
		session.setAttribute("res_date", res_date);
		session.setAttribute("check_in", check_in);
		session.setAttribute("check_out", check_out);
		session.setAttribute("price", price);
		
		request.getRequestDispatcher("/WEB-INF/view/reservation/reservation.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String member_id_ = request.getParameter("member_id");
		String stay_name_ = request.getParameter("stay_name");
		String room_name_ = request.getParameter("room_name");
		String check_in_ = request.getParameter("check_in");
		String check_out_ = request.getParameter("check_out");
		String member_name_ = request.getParameter("member_name");
		String count_ = request.getParameter("count");
		String price_ = request.getParameter("price");
		
		String member_id = "맴버아이디";
		String stay_name = "";
		String room_name = "";
		String member_name = "";
		
		int count = 0;
		int price = 0;
		
		if(member_id_ != null && !member_id_.equals("")) {
			member_id = member_id_;
		}
		if(stay_name_ != null && !stay_name_.equals("")) {
			stay_name = stay_name_;
		}
		if(room_name_ != null && !room_name_.equals("")) {
			room_name = room_name_;
		}
		LocalDate sql_check_in = LocalDate.parse(check_in_);
		Date check_in = Date.valueOf(sql_check_in);
		
		LocalDate sql_check_out = LocalDate.parse(check_out_);
		Date check_out = Date.valueOf(sql_check_out);
		
		if(member_name_ != null && !member_name_.equals("")) {
			member_name = member_name_;
		}
		if(count_ != null && !count_.equals("")) {
			count = Integer.parseInt(count_);
		}
		if(price_ != null && !price_.equals("")) {
			price = Integer.parseInt(price_);
		}
		
		Reservation reservation = new Reservation();
		reservation.setMember_id(member_id);
		reservation.setStay_name(stay_name);
		reservation.setRoom_name(room_name);
		reservation.setCheck_in(check_in);
		reservation.setCheck_out(check_out);
		reservation.setReservation_person(count);
		reservation.setPrice(price);
		
		ReservationService reservation_service = new ReservationService();
		int result = reservation_service.insertReservation(reservation);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter w = response.getWriter();
		w.write("<script>alert('예약되었습니다');location.href='/view/main';</script>");
		w.flush();
		w.close(); 
	}
}
