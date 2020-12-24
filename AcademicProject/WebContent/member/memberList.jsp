<%@page import="kr.co.kh.member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
	#memberList{
		position: absolute;
		top:300px; left:580px;
	}
	table{border:1px solid black; border-collapse: collapse; text-align:center;}
	th{background-color: black; color: white;}
	body{background-image: url(images/back02.jpg)}
	h1{position:absolute; top:230px; left:580px;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>회원목록</h1>
<div id="memberList">
<table>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>주소</th>
		<th>핸드폰번호</th>
	</tr>
	
	<%
	ArrayList<MemberDTO> memberList = (ArrayList<MemberDTO>)request.getAttribute("memberList");
	for(int i=0;i<memberList.size();i++){
		MemberDTO memberDTO = memberList.get(i);
	%>
	
	<tr>
		<td><%=memberDTO.getId()%></td>
		<td><%=memberDTO.getPw()%></td>
		<td><%=memberDTO.getAddr()%></td>
		<td><%=memberDTO.getTel()%></td>
	</tr>
	<%} %>
</table>
<a href="index.jsp?page=member/memberUpdateForm">회원수정</a>
</div>
</body>
</html>