<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="hiddenProcess.jsp" method="get">
	<fieldset>
		<legend>안보이는 박스</legend>
		<ul>
			<li><label for="안보이는박스">안보이는 박스</label>
			<input type="hidden" name="hidden" value="숨겨진데이터를 전송하겠습니다.">
			</li>
			<li><input type="submit" value="전송"></li>
		</ul>
	</fieldset>
</form>
</body>
</html>