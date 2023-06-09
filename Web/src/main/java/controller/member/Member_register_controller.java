package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Member;
import service.MemberService;

@WebServlet("/view/member/register")
public class Member_register_controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/register.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
		String name = request.getParameter("NAME");
		String phone = request.getParameter("PHONE");
		String email = request.getParameter("EMAIL");
		String gender = request.getParameter("GENDER");
		
		Member member = new Member();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setPhone(phone);
		member.setEmail(email);
		member.setGender(gender);
		
		MemberService service = new MemberService();
		int result = service.insertMember(member);
		
		response.sendRedirect("/view/main");
	}
}
