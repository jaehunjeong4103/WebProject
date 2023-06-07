package controller.review;

import java.io.IOException;
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

@WebServlet("/view/review/review")
public class Review_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("/WEB-INF/view/review/review.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String member_id = request.getParameter("ID");
		int group_id = Integer.parseInt(request.getParameter("GROUP_ID"));
		int code = Integer.parseInt(request.getParameter("CODE")); 
		String content = request.getParameter("REVIEW_TEXT");
		int star = Integer.parseInt(request.getParameter("REVIEW_STAR"));
		
		Review review = new Review();
		review.setMember_id(member_id);
		review.setGroup_id(group_id);
		review.setCode(code);
		review.setContent(content);
		review.setStar(star);
		
		ReviewService service = new ReviewService();
		int result = service.insertReview(review);
		
		HttpSession session = request.getSession();
		/*
		session.removeAttribute("code");
		session.removeAttribute("group_id");
		*/
		
		switch (group_id) {
			case 1:
				response.sendRedirect("/view/tour/tour_detail?id=" + code);
				break;
			case 2:
				response.sendRedirect("/view/tour/tour_detail?id=" + code);
				break;
			case 3:
				response.sendRedirect("/view/tour/tour_detail?id=" + code);
				break;
			case 4:
				response.sendRedirect("/view/stay/stay_detail?id=" + code);
				break;
		}

		
	}

}
