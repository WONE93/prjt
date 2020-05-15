<%@page import="emp.EmpVO"%>
<%@page import="emp.DeptVO"%>
<%@page import="emp.JobVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>사원등록</title>
<script>
function validCheck(){
	
	//필수입력 체크 (라벨)
	if(frm.employee_id.value == "" ) {	//trim함수
		alert("employee_id입력하세용");
		frm.employee_id.focus();
		return;
	}	
	frm.submit(); // 아무 이상없이 밑에까지 내려온다면 제출! 
}

</script>
</head>
<body>
<jsp:include page="/common/header.jsp"/>

	<h3 id="top">사원등록</h3>
	<form action="EmpInsert.do" method="post" name="frm">
		<div>
			<span class="label">employee_id</span><input type="number" min="300"
				step="1" name="employee_id">
		</div>
		<div>
			<span class="label">first_name</span><input name="first_name">
		</div>
		<div>
			<span class="label">last_name</span><input name="last_name">
		</div>
		<div>
			<span class="label">email</span><input type="email" name="email">
		</div>
		<div>
			<span class="label">phone_number</span><input type="text"
				name="phone_number">
		</div>
		<div>
			<span class="label">hire_date</span><input type="date"
				name="hire_date">
		</div>
		<div>
			<span class="label">job_id</span> 
			<select name="job_id">
				<%
					List<JobVO> jobList = (List<JobVO>) request.getAttribute("jobList");
					for (JobVO jobVO : jobList) {
				%>
				<option value="<%=jobVO.getJob_id()%>">
					<%=jobVO.getJob_title()%>
					<%
						}
					%>
				
			</select>
		</div>
		<div>
			<span class="label">department_id</span>
			<%
				List<DeptVO> deptList = (List<DeptVO>) request.getAttribute("deptList");
				for (DeptVO deptVO : deptList) {
			%>

			<input type="radio" name="department_id"
				value="<%=deptVO.getDepartment_id()%>"><%=deptVO.getDepartment_name()%>
			<%
				}
			%>
		</div>
		<div>
			<span class="label">manager_id</span> 
			<select name="manager_id">
				<%
					List<EmpVO> empList = (List<EmpVO>) request.getAttribute("empList");
					for (EmpVO empVO : empList) {
				%>
				<option value="<%=empVO.getEmployee_id()%>">
					<%=empVO.getFirst_name()%>
					<%=empVO.getLast_name()%>
					<%
						}
					%>
				
			</select>
		</div>
		<div>
			<button type="button" onclick="validCheck()">등록</button>
			<button type="reset">초기화</button>
		</div>
	</form>
	
<%@include file="/common/footer.jsp" %>
</body>
</html>
