<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body{background-image: url(images/back02.jpg)}
	h1{text-align: center;}
	ul{list-style-type: none;}
	
	.kh01{
		width: 200px; height: 100px;
	}
	.kh02{
		width: 200px; height: 80px;
	}
	
	#loginForm{
		position:absolute;
		top: 300px; left:700px;
	}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="loginForm">
	<h1>로그인</h1>
	<form action="member/login.jsp" method="get">
		<ul>
			<li><label for="아이디">&nbsp;아&nbsp;이&nbsp;디&nbsp;</label>
				<input type="text" name="id" maxlength="20" size="20" autofocus="autofocus" required="required" placeholder="아이디를 입력하세요">
			</li>
			<li><label for="패스워드">패스워드</label>
				<input type="password" name="pw" maxlength="10" size="20" placeholder="패스워드를 입력해주세요">
			</li>
			<li><input type="image" src="images/login.png" class="kh01">
				<a href="index.jsp?page=member/memberForm"><img src="images/member.png" class="kh02"></a>
			</li>
			<li><a href="member/idcheck.jsp">아이디찾기</a>&nbsp;&nbsp;
     		<a href="member/pwcheck.jsp">패스워드찾기</a>
			</li>
		</ul>
	</form>
</div>
</body>
</html>