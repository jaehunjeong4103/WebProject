package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Room;
import entity.Stay;
import entity.Tour;
import service.RoomService;
import service.StayService;
import service.TourService;

@WebServlet("/view/admin_insert")
public class Admin_insert_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin_insert.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int result;
		
		String group_id_ = request.getParameter("group_id"); 
		String name_ = request.getParameter("name");
		String address_ = request.getParameter("address");
		String phone_ = request.getParameter("phone");
		String op_cl_ = request.getParameter("op_cl");
		String map_path_ = request.getParameter("map_path");
		String image_path_ = request.getParameter("image_path");
		String content_ = request.getParameter("content");
		String check_in_ = request.getParameter("check_in");
		String stay_name_ = request.getParameter("stay_id");
		String max_person_ = request.getParameter("max_person");
		String weekend_price_ = request.getParameter("weekend_price_");
		String weekday_price_ = request.getParameter("weekday_price_");
		String option_ = request.getParameter("option"); 
		
		int group_id = 0;
		String name= "이름";
		String address = "주소";
		String phone = "전화번호";
		String op_cl = "기간";
		String map_path = "지도 주소";
		String image_path = "이미지주소";
		String content = "내용";
		String check_in = "체크인 시간";
		String stay_name = "숙소이름";
		int max_person = 0;
		String weekend_price = "주말 가격";
		String weekday_price = "평일 가격";
		String option = "방옵션";
		
		if(group_id_ != null && !group_id_.equals("")) {
			group_id = Integer.parseInt(group_id_);
		}
		if(name_ != null && !name_.equals("")) {
			name = name_;
		}
		if(address_ != null && !address_.equals("")) {
			address = address_;
		}
		if(phone_ != null && !phone_.equals("")) {
			phone = phone_;
		}
		if(op_cl_ != null && !op_cl_.equals("")) {
			op_cl = op_cl_;
		}
		if(map_path_ != null && !map_path_.equals("")) {
			map_path = map_path_;
		}
		if(image_path_ != null && !image_path_.equals("")) {
			image_path = image_path_;
		}
		if(content_ != null && !content_.equals("")) {
			content = content_;
		}
		if(check_in_ != null && !check_in_.equals("")) {
			check_in = check_in_;
		}
		if(stay_name_ != null && !stay_name_.equals("")) {
			stay_name = stay_name_;
		}
		if(max_person_ != null && !max_person_.equals("")) {
			max_person = Integer.parseInt(max_person_);
		}
		if(weekend_price_ != null && !weekend_price_.equals("")) {
			weekend_price = weekend_price_;
		}
		if(weekday_price_ != null && !weekday_price_.equals("")) {
			weekday_price = weekday_price_;
		}
		if(option_ != null && !option_.equals("")) {
			option = option_;
		}
		
		
		switch (group_id) {
			case 1:
				Tour tour = new Tour();
				tour.setName(name);
				tour.setAddress(address);
				tour.setPhone(phone);
				tour.setOp_cl(op_cl);
				tour.setContent(content);
				tour.setMap_path(map_path);
				tour.setImage_path(image_path);
			
				TourService tour_service = new TourService();
				result = tour_service.insertTour(tour);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				Stay stay = new Stay();
				stay.setName(name);
				stay.setAddress(address);
				stay.setPhone(phone);
				stay.setCheck_in(check_in);
				stay.setMap_path(map_path);
				stay.setImage_path(image_path);
				
				StayService stay_service = new StayService();
				result = stay_service.insertStay(stay);
				break;
			case 5:
				Room room = new Room();
				room.setName(name);
				room.setStay_name(stay_name);
				room.setMax_person(max_person);
				room.setWeekday_price(weekend_price);
				room.setWeekday_price(weekday_price);
				room.setOption(option);
				
				RoomService room_service = new RoomService();
				result = room_service.insertRoom(room);
				break;
		
		}
		response.sendRedirect("/view/admin_insert");
	}
}
