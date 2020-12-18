<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
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
	ResultSet rs = null;
	String searchId = request.getParameter("id");
	String pw = null;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "select pw from memberhj where id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, searchId);
	rs = pstmt.executeQuery();
	while(rs.next()){
		pw = rs.getString("pw");
	}
	out.print("<script>alert('찾으신 비밀번호는 "+pw+" 입니다.');history.back();</script>");
%>
</body>
</html>