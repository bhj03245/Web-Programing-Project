<%@page import="java.sql.Statement"%>
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
<h1>학생등록처리</h1>
<%
	String age = request.getParameter("age");
	String name = request.getParameter("name");
	String hakbun = request.getParameter("hakbun");
	//int age = Integer.parseInt(age1);
	//int hakbun = Integer.parseInt(hakbun1);
%>
<%= age %>:<%=name %>:<%=hakbun %>

<%
	int cnt = 0;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
		Statement stmt = conn.createStatement();
		String sql = "insert into studenthj(age, name, hakbun) values('"+age+"','"+name+"','"+hakbun+"')";
		//String sql = "insert into student(age,name,hakbun) values(" + age + ",'" + name + "'," + hakbun + ")";
		cnt = stmt.executeUpdate(sql);
	}catch(ClassNotFoundException e1) {
		e1.printStackTrace();
	} 
	
%>
<%= cnt %>건 학생이 등록되었습니다.
</body>
</html>