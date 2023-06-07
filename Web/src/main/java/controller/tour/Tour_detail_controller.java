package controller.tour;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Review;
import entity.Tour;
import service.ReviewService;
import service.TourService;

@WebServlet("/view/tour/tour_detail")
public class Tour_detail_controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		TourService tour_service = new TourService();
		Tour tour = tour_service.getTour(id);
		request.setAttribute("t", tour);
		
		HttpSession session = request.getSession();
		int code = tour.getId();
		int group_id = tour.getGroup_id();
		session.setAttribute("code", code);
		session.setAttribute("group_id", group_id);
		
		ReviewService review_service = new ReviewService();
		List<Review> review_list = review_service.getReviewList(code, group_id);
		
		request.setAttribute("review_list", review_list);
		request.getRequestDispatcher("/WEB-INF/view/tour/tour_detail.jsp").forward(request, response);

	}
}
