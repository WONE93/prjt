<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<title>boardList.jsp</title>
<jsp:include page="/common/header.jsp"/>

	<h3>게시판</h3>
	<table border="1">
		<tr><th>번호</th><th>제목</th><th>작성자</th></tr>
		<c:forEach items="${list}" var="vo">
			<tr><td>${vo.seq}</td>
				<td><a href="BoardUpdate.do?seq=${vo.seq}"> ${vo.title} </a></td>				
			<td>${vo.name}</td></tr>
			
		</c:forEach>
	</table>
	<%@include file="/common/footer.jsp" %>
</body>
</html>