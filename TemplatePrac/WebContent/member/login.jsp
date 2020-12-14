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
	String chkid = null;
	String chkpw = null;
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "select id, pw from memberhj where id=? and pw=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,id);
	pstmt.setString(2,pw);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		chkid = rs.getString("id");
		chkpw = rs.getString("pw");
	}
	if(!id.equals(chkid)){
		out.print("아이디가 혹은 패스워드가 틀렸습니다.");
	}
	
	if(id.equals(chkid) && !pw.equals(chkpw)){
		out.print("아이디 혹은 패스워드가 틀렸습니다.");
	}
	
	if(id.equals(chkid) && pw.equals(chkpw)){
		out.print("로그인 성공");
		session.setAttribute("id",id);
	}
	response.sendRedirect("../index.jsp");
%>
</body>
</html>