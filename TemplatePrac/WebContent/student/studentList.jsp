<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table{border: 3px solid skyblue; border-collapse: collapse; width:500px; height:200px;}
	th{border: 1px solid blue; background-color: yellow;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>학생 전체출력</h1>
<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th>번호</th>
		<th>나이</th>
		<th>이름</th>
		<th>학번</th>
	</tr>
	<tr>
<%
	Class.forName("com.mysql.jdbc.Driver");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "select no,age,name,hakbun from studenthj";
	PreparedStatement stmt = conn.prepareStatement(sql);
	ResultSet rs = stmt.executeQuery();
	while(rs.next()){
		int no = rs.getInt("no");
		String age = rs.getString("age");
		String name = rs.getString("name");
		String hakbun = rs.getString("hakbun");
		out.print("<tr><td>"+no+"</td>"+"<td>"+age+"</td>"+"<td>"+name+"</td>"+"<td>"+hakbun+"</td></tr>");
	}
	stmt.close();
	rs.close();
	conn.close();
%>
</tr>
</table>
<a href="student.jsp">학생등록</a>
<a href="../haksaInfo.jsp">학사관리</a>
</body>
</html>