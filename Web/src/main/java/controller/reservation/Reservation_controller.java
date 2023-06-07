package controller.reservation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Reservation;
import service.ReservationService;

@WebServlet("/view/reservation/reservation")
public class Reservation_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String stay_name = request.getParameter("stay_name");
		String room_name = request.getParameter("room_name");
		String res_date = request.getParameter("res_date");
		
		HttpSession session = request.getSession();
		session.setAttribute("stay_name", stay_name);
		session.setAttribute("room_name", room_name);
		session.setAttribute("res_date", res_date);
		
		request.getRequestDispatcher("/WEB-INF/view/reservation/reservation.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String member_id_ = request.getParameter("member_id");
		String stay_name_ = request.getParameter("stay_name");
		String room_name_ = request.getParameter("room_name");
		String res_date_ = request.getParameter("res_date");
		String member_name_ = request.getParameter("member_name");
		String count_ = request.getParameter("count");
		String price_ = request.getParameter("price");
		
		String member_id = "맴버아이디";
		String stay_name = "";
		String room_name = "";
		String res_date = "";
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
		if(res_date_ != null && !res_date_.equals("")) {
			res_date = res_date_;
		}
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
		reservation.setReservation_date(res_date);
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
