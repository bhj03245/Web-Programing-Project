<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="rangeProcess.jsp" method="get">
<fieldset>
	<legend>막대 테스트</legend>
	<ul>
		<li><label for="range">range</label>
			<input type="range" name="range" max="50" min="1" step="1">
		<li><input type="submit" value="전송"></li>
	</ul>
</fieldset>
</form>
</body>
</html>