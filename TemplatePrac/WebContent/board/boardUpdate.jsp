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
	String searchTitle = request.getParameter("searchTitle");
	String no = request.getParameter("no");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String author = request.getParameter("author");
	String nal = request.getParameter("nal");
	String readcount = request.getParameter("readcount");
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "update boardhj set title=?,content=?,author=?,nal=?,readcount=? where title=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,title);
	pstmt.setString(2,content);
	pstmt.setString(3,author);
	pstmt.setString(4,nal);
	pstmt.setString(5,readcount);
	pstmt.setString(6,searchTitle);
	int cnt = pstmt.executeUpdate();
%>
<%
	response.sendRedirect("../index.jsp?page=board/boardList");
%>
</body>
</html>