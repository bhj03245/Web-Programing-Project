<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="dateProcess.jsp" method="get">
<fieldset>
	<legend>달력테스트</legend>
	<ul>
		<li><label for="date">Date</label>
			<input type="date" name="ymd">
		</li>
		<li><input type="submit" value="전송"></li>
	</ul>
</fieldset>
</form>
</body>
</html>