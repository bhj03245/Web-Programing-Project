<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int cnt = 0;
	String searchId = request.getParameter("updateId");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String addr = request.getParameter("addr");
	String tel = request.getParameter("tel");
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "update memberhj set id = ?, pw=?, addr= ?, tel= ? where id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, pw);
	pstmt.setString(3, addr);
	pstmt.setString(4, tel);
	pstmt.setString(5, searchId);
	cnt = pstmt.executeUpdate();
	out.print("<script>alert('회원정보가 수정되었습니다.'); location.href='../index.jsp?page=member/memberList';</script>");  
%>
</body>
</html>