<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@include file="/common/header.jsp"%>


<h3>회원정보</h3>
<form action="../MemberInsert.do" method="post">
	<!-- 여기서 ../안쓰면 member/memberIndert.do 부르는 거랑 같음 -->
	ID : <input type="text" name="id" /><br /> 비밀번호 : <input
		type="password" name="pwd" id="pwd" /><br /> 이름: <input type="text"
		name="name" id="name" /><br /> 취미: <input type="checkbox"
		name="hobby" id="hobby1" value="h01" />등산 <input type="checkbox"
		name="hobby" id="hobby2" value="h02" />운동 <input type="checkbox"
		name="hobby" id="hobby3" value="h03" />독서 <input type="checkbox"
		name="hobby" id="hobby4" value="h04" />여행</br> 성별: <input type="radio"
		name="gender" value="m" />남자 <input type="radio" name="gender"
		value="f" />여자</br> 종교: <select name="religion" id="religion">
		<option value="r01">기독교
		<option value="r02">불교
		<option value="r03">천주교
		<option value="r04">무교
	</select></br> 자기소개:<br />
	<textarea cols="30" row="10" name="introduction" id="introduction"></textarea>
	</br> <input type="submit" value="전송" /> <input type="reset" value="지우기" />


</form>
<%@include file="/common/footer.jsp"%>
</body>
</html>