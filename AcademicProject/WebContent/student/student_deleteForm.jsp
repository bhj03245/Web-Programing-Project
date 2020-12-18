<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.kh01{
		width: 250px; height: 200px;
	}
	
	#studentDelete{
		border: 1px solid skyblue;
		border-radius: 20px;
		width: 300px; height: 300px;
	}
	
	ul{list-style-type: none;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<H1>학생삭제</H1>
<div id="studentDelete">
<form action="../studentDelete.do" method="get">
<ul>
	<li><label for="삭제이름">삭제이름</label>
		<input type="text" name="name">
	</li>
	<li><input type="image" src="../images/delete.jpeg" class="kh01"></li>
</ul>
</form>
&nbsp;&nbsp;&nbsp;<a href="studentList.jsp">학생 전체 출력</a>
</div>
</body>
</html>