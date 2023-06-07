package controller.tour;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Tour;
import service.TourService;

@WebServlet("/view/tour/tour_list")
public class Tour_list_controller extends HttpServlet{
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
		
		TourService tour_service = new TourService();
		List<Tour> tour_list = tour_service.getTourList(field, query, page);
		int count = tour_service.getTourCount(field, query);
		
		request.setAttribute("tour_list", tour_list);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/WEB-INF/view/tour/tour_list.jsp").forward(request, response);
		
	}
}
