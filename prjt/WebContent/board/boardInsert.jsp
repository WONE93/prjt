<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> 게시판 등록 </title>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
	
	<h3>게시판</h3>
	<form action="BoardInsert.do" method="post" >
	작성자 : <input type="text" name="id"  value= "${loginId}"><br/>								
	제목 : <input type ="text" name="title" id="title"/><br/>
	내용: <input type="text" name="contents" id="contents"/><br/>
		
		<input type="submit" value="전송" />
		<input type="reset" value="지우기" />
</form>

<%@include file="/common/footer.jsp" %>
</body>
</html>