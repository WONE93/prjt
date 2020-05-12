<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>empList.jsp</title>
<%@include file="/common/header.jsp"%>
</head>
<body>
	<h3>사원목록</h3>
	<table border="1">
		<tr><th>사번</th><th>이름</th></tr>
		<c:forEach items="${list}" var="vo" >
			<tr><td>${vo.employee_id}</td>
			 	<td>${vo.first_name} ${vo.last_name}</td>
			 	<td>${vo.job_id}</td>
			 	<td>${vo.department_id}</td></tr>
			 	
		</c:forEach>
		</table>
		<%@include file="/common/footer.jsp"%>
</body>
</html>