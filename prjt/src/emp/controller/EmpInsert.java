package emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DeptDAO;
import emp.DeptVO;
import emp.EmpDAO;
import emp.EmpVO;
import emp.JobDAO;
import emp.JobVO;



/**
 * Servlet implementation class EmpInsert
 */
@WebServlet("/EmpInsert.do")
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 등록폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// job
		List<JobVO> jobList = JobDAO.getInstance().selectAll();
		request.setAttribute("jobList", jobList);
		// dept
		List<DeptVO> deptList = DeptDAO.getInstance().selectAll();
		request.setAttribute("deptList", deptList);
		// manager(emp)
		List<EmpVO> empList = EmpDAO.getInstance().selectAll();
		request.setAttribute("empList", empList);

		request.getRequestDispatcher("emp/empInsert.jsp").forward(request, response);
	}

	// 등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 포스트 방식일때는 밑의 방식으로 해야 한글 안깨짐
		// 응답결과 인코딩
		response.setContentType("text/html; charset=UTF-8");
		// 요청정보 인코딩
		request.setCharacterEncoding("utf-8");

		// 1. 파라미터
		String employee_id = request.getParameter("employee_id"); // 이런식으로 아이디와 패스워드 받기												
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String hire_date = request.getParameter("hire_date");
		String job_id = request.getParameter("job_id");
		String department_id = request.getParameter("department_id");
		String manager_id = request.getParameter("manager_id");
		
		// 2. DAO insert
		EmpDAO empDAO = new EmpDAO();
		EmpVO emp = new EmpVO();
		
		emp.setEmployee_id(employee_id);
		emp.setFirst_name(first_name);
		emp.setLast_name(last_name);
		emp.setEmail(email);
		emp.setPhone_number(phone_number);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setDepartment_id(department_id);
		emp.setManager_id(manager_id);
		
		int r = empDAO.insert(emp);

		// 3. 목록 서블릿 redirect
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect( "/edu/EmpList.do");  
	}

}
