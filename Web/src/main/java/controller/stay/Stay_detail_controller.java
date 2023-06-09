package controller.stay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Calendar_data;
import entity.Review;
import entity.Room;
import entity.Stay;
import service.ReviewService;
import service.RoomService;
import service.StayService;

@WebServlet("/view/stay/stay_detail")
public class Stay_detail_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("n");
		
		StayService stayService = new StayService();
		Stay stay = stayService.getStay(id);
		request.setAttribute("stay", stay);
		
		HttpSession session = request.getSession();
		int code = stay.getId();
		int group_id = stay.getGroup_id();
		session.setAttribute("code", code);
		session.setAttribute("group_id", group_id);
		session.setAttribute("stay_id", id);
		
		Calendar cal = Calendar.getInstance();
		Calendar next_cal = Calendar.getInstance();
		int now_year = cal.get(Calendar.YEAR);
		int now_month = cal.get(Calendar.MONTH)+1;
		int now_day = cal.get(Calendar.DAY_OF_MONTH);
		
		String c_year = request.getParameter("c_year");
		String c_month = request.getParameter("c_month");

		int year = now_year;
		int month = now_month;
		
		if (c_year != null && !c_year.equals("")) {
			year = Integer.parseInt(c_year);
		}
		if (c_month != null && !c_month.equals("")) {
			month = Integer.parseInt(c_month);
		}
		
		int pre_year = year;
		int pre_month = month-1;
		if(pre_month < 1) {
			pre_year = year-1;
			pre_month = 12;
		}
		
		int next_year = year;
		int next_month = month+1;
		if (next_month > 12) {
			next_year = year+1;
			next_month = 1;
		}
		
		cal.set(year, month-1, 1);		
		int start_day = cal.getMinimum(Calendar.DATE);
		int end_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		
		next_cal.set(year, month, 1);		
		int next_start_day = next_cal.getMinimum(Calendar.DATE);
		int next_end_day = next_cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int next_week = next_cal.get(Calendar.DAY_OF_WEEK);
		
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("now_year", now_year);
		request.setAttribute("now_month", now_month);
		request.setAttribute("now_day", now_day);
		request.setAttribute("pre_year", pre_year);
		request.setAttribute("pre_month", pre_month);
		request.setAttribute("next_year", next_year);
		request.setAttribute("next_month", next_month);
		request.setAttribute("start_day", start_day);
		request.setAttribute("end_day", end_day);
		request.setAttribute("week", week);
		
		Calendar_data calendar_data;
		List<Calendar_data> calendar_list = new ArrayList<>();
		
		for (int i=1; i<week; i++) {
			calendar_data = new Calendar_data(null, null, null);
			calendar_list.add(calendar_data);
		}
		
		for (int i=start_day; i<=end_day; i++) {
			calendar_data = new Calendar_data(String.valueOf(year), String.valueOf(month-1), String.valueOf(i));	
			calendar_list.add(calendar_data);
		}
		int index = 7-calendar_list.size()%7;
		if(calendar_list.size()%7 != 0) {
			for (int i=0; i < index; i++) {
				calendar_data = new Calendar_data(null, null, null);
				calendar_list.add(calendar_data);
			}
		}
		
		List<Calendar_data> next_calendar_list = new ArrayList<>();
		
		for (int i=1; i<next_week; i++) {
			calendar_data = new Calendar_data(null, null, null);
			next_calendar_list.add(calendar_data);
		}
		
		for (int i=next_start_day; i<=next_end_day; i++) {
			calendar_data = new Calendar_data(String.valueOf(year), String.valueOf(month), String.valueOf(i));	
			next_calendar_list.add(calendar_data);
		}
		int next_index = 7-next_calendar_list.size()%7;
		if(next_calendar_list.size()%7 != 0) {
			for (int i=0; i < next_index; i++) {
				calendar_data = new Calendar_data(null, null, null);
				next_calendar_list.add(calendar_data);
			}
		}
		request.setAttribute("calendar_list", calendar_list);
		request.setAttribute("next_calendar_list", next_calendar_list);
		
		String stay_name_ = request.getParameter("stay_name");
		String s_day_ = request.getParameter("s_day");
		String e_day_ = request.getParameter("e_day");
		
		String stay_name = "name";
		if(stay_name_ != null && !stay_name_.equals("")) {
			stay_name = stay_name_;
		}
		String s_day = "0";
		if(s_day_ != null && !s_day_.equals("")) {
			s_day = s_day_;
		}
		String e_day = "0";
		if(e_day_ != null && !e_day_.equals("")) {
			e_day = e_day_;
		}
		
		RoomService room_service = new RoomService();
		List<Room> room_list = room_service.getRoomList(id, name);
		request.setAttribute("room_list", room_list);
		
		ReviewService review_service = new ReviewService();
		List<Review> review_list = review_service.getReviewList(code, group_id);	
		request.setAttribute("review_list", review_list);
		
		request.getRequestDispatcher("/WEB-INF/view/stay/stay_detail.jsp").forward(request, response);
	}
	
}
