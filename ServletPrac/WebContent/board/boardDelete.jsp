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
<%
	String no1 = request.getParameter("no");
	int no = Integer.parseInt(no1);
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "delete from boardhj where no = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1,no);
	int cnt = pstmt.executeUpdate();
%>
<%
	response.sendRedirect("../index.jsp?page=board/boardList");
	pstmt.close();
	conn.close();
%>
</body>
</html>