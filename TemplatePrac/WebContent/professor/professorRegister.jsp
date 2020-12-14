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
<h1>교수등록처리</h1>
<%
	String age = request.getParameter("age");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
%>
<%= age %>:<%=name %>:<%=subject %>

<%
	int cnt = 0;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "insert into professorhj(age, name, subject) values(?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,age);
	pstmt.setString(2,name);
	pstmt.setString(3,subject);
	cnt = pstmt.executeUpdate();
%>
<%= cnt %>건 교수가 등록되었습니다.

<%
	pstmt.close();
	conn.close();
	response.sendRedirect("professorList.jsp");
%>
</body>
</html>