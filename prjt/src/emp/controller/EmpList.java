package emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.EmpDAO;
import emp.EmpVO;


/**
 * Servlet implementation class EmpList
 */
@WebServlet("/EmpList.do")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터
		
		//2. 서비스(DAO 목록조회)
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = dao.selectAll();
		
		//3. 결과출력 OR 결과저장해서 view 포워드
		request.setAttribute("list", list);
		request
		.getRequestDispatcher("/emp/empList.jsp") //뷰페이지 포워드 넘어감
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
