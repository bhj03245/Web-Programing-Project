<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.kh01{
		width:200px; height:150px;
	}
	#memberout{
		position: absolute;
		top: 250px; left:750px;
		width: 400px; height: 300px;
		border: 1px solid black;
	}
	ul{list-style-type: none;}
	body{background-image: url(images/back02.jpg);}
	h1{text-align:center;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="memberout">
<h1>회원 탈퇴</h1>
<form action="memberDelete.mb" method="get">
	<ul>
		<li><label for="패스워드">패스워드</label>
		     <input type="password" name="pw" required="required" autofocus="autofocus" placeholder="탈퇴할 패스워드 입력">
		</li>
		<li><a onclick="alert('정말 탈퇴하시겠습니까?')"><input type="image" src="../images/submit.jpg" class="kh01"></a></li>

	</ul>
</form>
</div>
</body>
</html>