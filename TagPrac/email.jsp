<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="emailProcess.jsp" method="get">
<fieldset>
	<legend>Email테스트</legend>
	<ul>
		<li><label for="email">Email</label>
			<input type="email" name="email" autofocus="autofocus" required="required" placeholder="이메일을 입력하세요">
		<li><input type="submit" value="전송"></li>
	</ul>
</fieldset>
</form>
</body>
</html>