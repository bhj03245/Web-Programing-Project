<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>당신이 좋아하는 고양이를 선택하세요</h1>
<form action="choiceCat" method="post">
	<input type="checkbox" name="cat" value="cat1.jpg">고양이1
	<input type="checkbox" name="cat" value="cat2.jpg">고양이2
	<input type="checkbox" name="cat" value="cat3.jpg">고양이3
	<input type="checkbox" name="cat" value="cat4.jpg">고양이4
	<input type="submit" value="선택">
</form>
</body>
</html>