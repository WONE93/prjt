package emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
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
		EmpDAO dao = new EmpDAO();  // 페이징 처리후 순서 위로
		
		String department_id = request.getParameter("department_id");
		String first_name = request.getParameter("first_name");		
		
		//페이징 처리 (목록조회전에)
		//현재페이지파라미터 받기
		String strPage = request.getParameter("p");
		int p = 1;
		if(strPage != null && ! strPage.isEmpty()) {
			p = Integer.parseInt(strPage);
		}
		//페이징 객체를 생성
		Paging paging = new Paging();
		paging.setPageSize(3); // 한페이지에 페이지번호가 3개씩 보일것. 디폴트는 10
		paging.setPage(p); // 현재페이지
		paging.setTotalRecord(dao.getCount(department_id, first_name)); // 전체 레코드 건수 조회 CUZ마지막건수가 정의돼야해서(얘는 필수)
		request.setAttribute("paging", paging);
		
		//2. 서비스(DAO 목록조회)
		int start = paging.getFirst();
		int end = paging.getLast();
		

		List<EmpVO> list = dao.selectAll(start, end,department_id,first_name);
		
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
