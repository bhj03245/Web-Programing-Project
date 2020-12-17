<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
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
	String chkPw = null;
	int cnt = 0;
	String deleteId = (String)session.getAttribute("id");
	String deletePw = request.getParameter("pw");
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "select pw from memberhj where pw = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,deletePw);
	rs = pstmt.executeQuery();
	while(rs.next()){
		chkPw = rs.getString("pw");	
	}
	if(!deletePw.equals(chkPw)){
		out.print("<script>alert('패스워드가 틀렸습니다.');history.back();</script>");
	}
	else{
		sql = "delete from memberhj where id = ? and pw = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, deleteId);
		pstmt.setString(2, deletePw);
		cnt = pstmt.executeUpdate();
		session.invalidate();
		out.print("<script>alert('회원 탈퇴되었습니다.'); location.href='../index.jsp';</script>");  
	}
%>

</body>
</html>