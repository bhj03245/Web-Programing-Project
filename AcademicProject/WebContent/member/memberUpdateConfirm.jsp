<%@page import="kr.co.kh.member.MemberDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.kh01{
		width:100px; height:50px;
	}
	#memberUpdate{
		position: absolute;
		top: 250px; left:650px;
		width: 600px; height: 300px;
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
<div id="memberUpdate">
<%	
	MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO");
	out.print("변경하기 전 내용입니다.");
	out.print("아이디: "+memberDTO.getId()+" 패스워드: "+memberDTO.getPw()+" 주소: "+memberDTO.getAddr() + " 전화번호: " + memberDTO.getTel());
	String updateId = memberDTO.getId();
%>
<h1>회원 수정</h1>
<form action="memberUpdateFinal.mb" method="get">
	<ul>
		<li><label for="아이디">아&nbsp;&nbsp;이&nbsp;&nbsp;디</label>
				<input type="text" name="id" size="20" maxlength="20" autofocus="autofocus" required="required" placeholder="변경할아이디를입력하세요.">
				<input type="hidden" name="updateId" value="<%=updateId%>">
			</li>
			<li><label for="패스워드">패스워드&nbsp;</label>
				<input type="password" name="pw" size="20" maxlength="" placeholder="변경할패스워드입력">
			</li>
			<li><label for="주소">&nbsp;&nbsp;&nbsp;주&nbsp;&nbsp;&nbsp;소&nbsp;</label>
				<input type="text" name="addr" size="20" maxlength="100" placeholder="변경할주소입력">
			</li>
			<li><label for="핸드폰">핸&nbsp;&nbsp;드&nbsp;&nbsp;폰</label>
				<input type="text" name="tel" placeholder="010-xxxx-xxxx">
			</li>
			<li><input type="image" src="images/update.png" class="kh01">
				<input type="reset" value="되돌리기" class="reset">
			</li>
	</ul>
</form>
</div>
</body>
</html>