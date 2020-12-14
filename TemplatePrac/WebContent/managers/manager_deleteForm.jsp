<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.kh01{
		width: 250px; height: 200px;
	}
	
	#managerDelete{
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
<h1>관리자삭제</h1>
<div id="managerDelete">
<form action="manager_delete.jsp" method="get">
<ul>
	<li><label for="삭제이름">삭제이름</label>
		<input type="text" name="name">
	</li>
	<li><input type="image" src="../images/delete.jpeg" class="kh01"></li>
</ul>
</form>
</div>
</body>
</html>