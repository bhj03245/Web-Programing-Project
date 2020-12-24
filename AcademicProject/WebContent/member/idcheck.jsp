<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.kh01{
		width:200px; height:150px;
	}
	#idcheck{
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
<div id="idcheck">
<h1>아이디 찾기</h1>
<form action="../memberidCheck.mb" method="get">
	<ul>
		<li><label for="전화번호">전화번호</label>
		     <input type="text" name="tel" required="required" autofocus="autofocus" placeholder="전화번호입력">
		</li>
		<li>
		<input type="image" src="../images/submit.jpg" class="kh01">
		</li>
	</ul>
</form>
</div>
</body>
</html>