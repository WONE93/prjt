package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDAO;
import member.model.MemberVO;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/MemberInsert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//회원가입 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
				
		//1.파라미터 받기
		String id = request.getParameter("id"); // 이런식으로 아이디와 패스워드 받기												
		String pwd = request.getParameter("pwd");
		
		//자기소개, 이름, 종교, 취미
		String name = request.getParameter("name");
//		String hobby = request.getParameter("hobby");
		String religion = request.getParameter("religion");
		String introduction = request.getParameter("introduction");
		String gender = request.getParameter("gender");
	
		String[] hobby = request.getParameterValues("hobby");
		// 값이 체크박스일 경우에만, 선택지가 여러개인 경우에만 파라미터밸류스로 
		String hobbs = "";
		if(hobby != null)
			for(String temp: hobby) {
				hobbs += temp + ",";
			}

		
		//2.서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setHobby(hobbs);
		member.setGender(gender);
		member.setReligion(religion);
		member.setIntroduction(introduction);
		
		int r = memberDAO.memberInsert(member);
		
		//3.회원목록 이동   // include, forward, sendRedirect
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/MemberList.do");  

		
		
	}


	//회원가입 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberInsert.jsp").forward(request, response);
	}
	
	
	
	


}
