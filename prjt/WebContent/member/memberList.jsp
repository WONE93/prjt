<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
<jsp:include page="/common/header.jsp"/>
</head>
<body>
	<h3>회원목록</h3>
	<form name="searchfrm"> 
		<input name="p" value="1" type="hidden">
		이름<input name="name">
		<button>검색</button>
	</form> 
	
	<table border="1">
		<tr><th>ID</th><th>이름</th><th>성별</th></tr>
		<c:forEach items="${list}" var="vo" >
			<tr><td>${vo.id}</td>
			 	<td>${vo.name}</td>
			 	<td>${vo.gender}</td></tr>			 	
		</c:forEach>
		</table>
		<script>
		function gopage(p) {
			document.searchfrm.p.value = p;
			document.searchfrm.submit();	
		}
		</script>
		
		<my:paging paging="${paging}" jsfunc="gopage"/>
		<%@include file="/common/footer.jsp"%>
</body>
</html>