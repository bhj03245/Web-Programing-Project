<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
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
<h1>학생검색</h1>
<%
	String searchName = request.getParameter("name");
	Class.forName("com.mysql.jdbc.Driver");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "select no,age,name,hakbun from studenthj where name = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, searchName);
	ResultSet rs = pstmt.executeQuery();
	int no = 0;
	String age = null;
	String name = null;
	String hakbun = null;
	while(rs.next()){
		no = rs.getInt("no");
		age = rs.getString("age");
		name = rs.getString("name");
		hakbun = rs.getString("hakbun");
	}
%>
<%=no %>&nbsp;&nbsp;&nbsp;<%=age %>&nbsp;&nbsp;&nbsp;<%=name %>&nbsp;&nbsp;&nbsp;<%=hakbun%>
<br>
<a href="studentList.jsp">학생전체출력</a>
<a href="../haksaInfo.jsp">학사관리</a>
<%
	pstmt.close();
	rs.close();
	conn.close();
%>
</body>
</html>