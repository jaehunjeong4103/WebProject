package controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Member;
import service.MemberService;

@WebServlet("/view/member/update")
public class Member_update_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("logIn_id");
		MemberService member_service = new MemberService();
		Member member = member_service.getMember(id);
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("/WEB-INF/view/member/update.jsp").forward(request, response);
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
		int result = service.updateMember(member);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter w = response.getWriter();
		w.write("<script>alert('회원정보가 수정되었습니다.');location.href='/view/main';</script>");
		w.flush();
		w.close(); 
				
	}
}
