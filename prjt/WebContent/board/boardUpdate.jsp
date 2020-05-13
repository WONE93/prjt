<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>boardUpdate.jsp</title>
<jsp:include page="/common/header.jsp"/>

</head>
<body>
<h3>게시글 수정</h3>
<form action="/prjt/BoardUpdate.do" method="post">
	<input name="seq" value="${board.seq}" type="hidden"/>
	주제 <input name="title" value="${board.title}"><br>
	내용 <br><textarea cols="30" row="10" name="contents" id="contents">${board.contents}</textarea>
	<br>
	<button>등록</button>
	<a href="BoardDelete.do?seq=${board.seq}">삭제</a>
</form>
<%@include file="/common/footer.jsp"%>
</body>
</html>