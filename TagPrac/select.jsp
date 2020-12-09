<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="selectProcess.jsp" method="get">
<fieldset>
	<legend>선택창</legend>
	<ul>
		<li><label for="방송국">방송국</label>
		<select name="tv">
			<option value="KBS">KBS</option>
			<option value="SBS">SBS</option>
			<option value="TVN">TVN</option>
			<option value="JTBC">JTBC</option>
		</select>
		</li>
		<li><input type="submit" value="전송"></li>
	</ul>
</fieldset>
</form>
</body>
</html>