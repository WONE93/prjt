<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<title>boardList.jsp</title>
<jsp:include page="/common/header.jsp"/>

	<h3>게시판</h3>
	<c:if test="${loginId != null}">
		<a href="BoardInsert.do">게시글등록</a>
	</c:if>
	<table border="1">
		<tr><th>제목</th><th>작성자</th><th>작성일자</th><th>date_fmt</th></tr>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td><a href="BoardUpdate.do?seq=${vo.seq}">${vo.title}</a></td>				
			<td>${vo.id}</td>
			<td>${vo.regdt}</td>
			<td>
			<fmt:parseDate value="${vo.regdt}" var="fmtDt" 
							pattern="yyyy-MM-dd HH:mm:ss" />
			<fmt:formatDate value="${fmtDt}" type="both" /></td>
			
		</c:forEach>
	</table>
	<%@include file="/common/footer.jsp" %>
</body>
</html>