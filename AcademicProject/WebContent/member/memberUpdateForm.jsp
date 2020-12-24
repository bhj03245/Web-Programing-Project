<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.kh01{
		width:100px; height:50px;
	}
	#memberUpdateForm{
		position: absolute;
		top: 250px; left:700px;
		width: 400px; height: 200px;
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
<div id="memberUpdateForm">
<h1>회원수정</h1>
	<form action="memberUpdateConfirm.mb" method="get">
		<ul>
			<li><h3>정보를 수정할 아이디를 입력하세요.</h3></li>
			<li><label for="아이디">아&nbsp;&nbsp;이&nbsp;&nbsp;디&nbsp;&nbsp;</label>
				<input type="text" name="id" size="20" maxlength="20" autofocus="autofocus" required="required" placeholder="아이디를입력하세요.">
			</li>
			<li><input type="image" src="images/update.png" class="kh01"></li>		
		</ul>
	</form>
</div>
</body>
</html>