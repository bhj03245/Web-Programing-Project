<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
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
	String searchTel = request.getParameter("tel");
	String id = null;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "select id from memberhj where tel = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, searchTel);
	rs = pstmt.executeQuery();
	while(rs.next()){
		id = rs.getString("id");
	}
	out.print("<script>alert('찾으신 아이디는 "+id+" 입니다.');history.back();</script>");
%> 

</body>
</html>