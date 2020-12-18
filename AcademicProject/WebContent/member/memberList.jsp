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
	String id = null;
	String pw = null;
	String addr = null;
	String tel = null;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후
	String sql = "select id,pw,addr,tel from memberhj";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		id = rs.getString("id");
		pw = rs.getString("pw");
		addr = rs.getString("addr");
		tel = rs.getString("tel");
		out.print("<tr><td>"+id+"</td><td>"+pw+"</td><td>"+addr+"</td><td>"+tel+"</td></tr>");
	}
%>
</table>
<a href="index.jsp?page=member/memberUpdateForm">회원수정</a>
</div>
</body>
</html>