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

@WebServlet("/view/member/duplicate")
public class Member_duplicate_controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/duplicate.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		
		MemberService member_service = new MemberService();
		Member member = member_service.checkMemberId(id);
		
		System.out.println(member);
		
		
		if (member != null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			w.write("<script>alert('중복된 아이디 입니다');location.href='/view/member/duplicate';</script>");
			w.flush();
			w.close(); 
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("chkId", id);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			w.write("<script>alert('사용 가능한 아이디 입니다');location.href='/view/member/register';</script>");
			w.flush();
			w.close(); 
		}	
	}
}
