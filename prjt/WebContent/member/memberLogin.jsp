<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title></title>

<jsp:include page="/common/header.jsp"/>

<h3>로그인</h3>
<div>${errorMsg}</div>
<form action="/prjt/MemberLogin.do" method="post">
	<input name="id" placeholder="id" value="${param.id}"><br> <input name="pwd"
		placeholder="pwd"><br>
	<button>로그인</button>
</form>


<%@include file="/common/footer.jsp"%>
</body>
</html>