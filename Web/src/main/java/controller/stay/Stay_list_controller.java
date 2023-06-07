package controller.stay;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Stay;
import service.StayService;

@WebServlet("/view/stay/stay_list")
public class Stay_list_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String field = "name";
		if(field_ != null && !field_.equals("")) {
			field = field_;
		}
		String query = "";
		if(query_ != null && !query_.equals("")) {
			query = query_;
		}
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		StayService stay_service = new StayService();
		List<Stay> stay_list = stay_service.getStayList(field, query, page);
		int count = stay_service.getStayCount(field, query);
		
		request.setAttribute("stay_list", stay_list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/view/stay/stay_list.jsp").forward(request, response);
	}
}
