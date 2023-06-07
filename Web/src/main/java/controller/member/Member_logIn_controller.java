package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Member;
import service.MemberService;

@WebServlet("/view/member/logIn")
public class Member_logIn_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/logIn.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
		
		MemberService service = new MemberService();
		Member member = service.checkMember(id, password);
		
		if (member != null) {
			HttpSession session = request.getSession();
			String logIn_id = member.getId();
			session.setAttribute("logIn", member);
			session.setAttribute("logIn_id", logIn_id);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			w.write("<script>alert('로그인에 성공하였습니다.');location.href='/view/main';</script>");
			w.flush();
			w.close(); 
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			w.write("<script>alert('로그인에 실패하였습니다.');location.href='/view/member/logIn';</script>");
			w.flush();
			w.close(); 
		}	

	}
}

