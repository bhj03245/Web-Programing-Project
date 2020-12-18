<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.kh01{
		width: 200px; height: 100px;
	}
	
	#managerUpdate{
		border: 1px solid skyblue;
		border-radius: 20px;
		width: 300px; height: 200px;
	}
	
	ul{list-style-type: none;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>관리자수정</h1>
<div id="managerUpdate">
<form action="../managerUpdate.do" method="get">
<ul>
	<li><label for="수정할 이름">수정할 이름</label>
		<input type="text" name="name">
	</li>
	<li><input type="image" src="../images/update.png" class="kh01"></li>
</ul>
</form>
&nbsp;&nbsp;&nbsp;<a href="managerList.jsp">관리자 전체 출력</a>
</div>
</body>
</html>