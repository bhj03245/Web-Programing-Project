<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.kh01{
		width: 250px; height: 200px;
	}
	
	#managerRegister{
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
<h1>관리자등록</h1>
<div id="managerRegister"> 
	<form action="../managerRegister.do" method="get">
		<ul>
			<li><label for="나이">나이</label>
				<input type="number" name="age">
			</li>
			
			<li><label for="이름">이름</label>
				<input type="text" name="name" size="20">
			</li>
			
			<li><label for="부서">부서</label>
				<input type="text" name="part" size="20">
			</li>
			
			<li><input type="image" src="../images/submit.jpg" class="kh01"></li>
		</ul>
	</form>
</div>
<a href="managerList.jsp">관리자 전체출력</a>
<a href="../index.jsp?page=haksaInfo">학사관리</a>
</body>
</html>