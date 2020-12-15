<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="colorProcess.jsp" method="get">
<fieldset>
	<legend>Color테스트</legend>
	<ul>
		<li><label for="color">색상</label>
			<input type="color" name="col">
		</li>
		<li><input type="submit" value="전송"></li>
	</ul>
</fieldset>
</form>
</body>
</html>