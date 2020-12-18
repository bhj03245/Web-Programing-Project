<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body{background-image: url(images/back02.jpg)}
	#memberForm{
		position:absolute;
		top: 300px; left:800px;
	}
	.kh01{
		width: 100px; height: 50px;
	}
	.reset{
		font-size:27px;
		background-color: cornflowerblue;
		color: white;
	}
	ul{list-style-type: none;}
	h1{text-align: center;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="memberForm">
	<h1>회원가입</h1>
	<form action="member/memberRegister.jsp" method="get">
		<ul>
			<li><label for="아이디">아&nbsp;&nbsp;이&nbsp;&nbsp;디&nbsp;&nbsp;</label>
				<input type="text" name="id" size="20" maxlength="20" autofocus="autofocus" required="required" placeholder="아이디를입력하세요.">
			</li>
			<li><label for="패스워드">패스워드&nbsp;&nbsp;</label>
				<input type="password" name="pw" size="20" maxlength="" placeholder="패스워드입력">
			</li>
			<li><label for="주소">&nbsp;&nbsp;&nbsp;주&nbsp;&nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input type="text" name="addr" size="20" maxlength="100" placeholder="주소입력">
			</li>
			<li><label for="핸드폰">&nbsp;핸&nbsp;&nbsp;드&nbsp;&nbsp;폰&nbsp;</label>
				<input type="text" name="tel" placeholder="010-xxxx-xxxx">
			</li>
			<li><input type="image" src="images/member.png" class="kh01">
				<input type="reset" value="되돌리기" class="reset">
			</li>
		</ul>
	</form>
</div>
</body>
</html>