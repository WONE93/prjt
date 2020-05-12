<%@page import="member.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
<%@include file="/common/header.jsp"%>

	<!-- Nevigation bar -->
	<%@include file="/common/menu.jsp"%>
	<%=getServletContext().getRealPath("/") %>
	<h3>회원목록</h3>


<%@include file="/common/footer.jsp"%>
</body>
</html>