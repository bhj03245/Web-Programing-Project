<%@page import="java.sql.ResultSet"%>
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
	request.setCharacterEncoding("utf-8");	
	String searchTitle = request.getParameter("title");
%>
<%
	int no = 0;
	String title = null;
	String author = null;
	String content = null;
	String nal = null;
	int readcount = 0;
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "select no,title,content,author,nal,readcount from boardhj where title=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,searchTitle);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		no = rs.getInt("no");
		title = rs.getString("title");
		content = rs.getString("content");
		author = rs.getString("author");
		nal = rs.getString("nal");
		readcount = rs.getInt("readcount");
	}
	readcount++;
	sql = "update boardhj set readcount=? where title = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1,readcount);
	pstmt.setString(2,searchTitle);
	int cnt = pstmt.executeUpdate();
%>
<jsp:forward page='<%=request.getParameter("boardTest") %>'>
<jsp:param value="<%=no %>" name="no"/>
<jsp:param value="<%=title %>" name="title"/>
<jsp:param value="<%=content %>" name="content"/>
<jsp:param value="<%= author %>" name="author"/>
<jsp:param value="<%=nal %>" name="nal"/>
<jsp:param value="<%=readcount %>" name="readcount"/>
</jsp:forward>
</body>
</html>