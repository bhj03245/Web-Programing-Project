<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="textprocess.jsp" method="get">
<fieldset>
	<legend>텍스트필드</legend>
	<ul>
		<li><label for="이름">이름</li>
		<input type="text" name="name" autofocus="autofocus" required="required" placeholder="이름을 입력해주세요"> 
		</li>
		<!-- required는 박스안에 공란일 경우 경고메세지 출력 -->
		<li><input type="submit" value="눌러라">
	</ul>
</fieldset>
</form>
</body>
</html>