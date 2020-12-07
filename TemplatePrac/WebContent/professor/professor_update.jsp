<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>교수 최종 수정</h1>
<% 
	String age = request.getParameter("age");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String updateName = request.getParameter("updateName");
	Class.forName("com.mysql.jdbc.Driver");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "update professorhj set age=?, name=?, subject=? where name = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,age);
	pstmt.setString(2,name);
	pstmt.setString(3,subject);
	pstmt.setString(4,updateName);
	int cnt = pstmt.executeUpdate();
%>
<%=cnt %>건 교수가 수정되었습니다.
<br>
<%response.sendRedirect("professorList.jsp"); %>
<%
	pstmt.close();
	conn.close();
%>
</body>
</html>