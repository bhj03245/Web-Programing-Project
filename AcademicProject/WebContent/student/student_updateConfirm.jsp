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
	.kh01{
		width: 200px; height: 100px;
	}
	
	#studentUpdate{
		border: 1px solid skyblue;
		border-radius: 20px;
		width: 300px; height: 200px;
	}
	
	ul{list-style-type: none;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<%
	String updateName = request.getParameter("name");
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "select age,name,hakbun from studenthj where name = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,updateName);
	ResultSet rs = pstmt.executeQuery();
	String age = null;
	String name = null;
	String hakbun = null;
	while(rs.next()){
		age = rs.getString("age");
		name = rs.getString("name");
		hakbun = rs.getString("hakbun");
	}
%>
<h1>최종수정 하기 전 내용입니다.</h1>
<form action="student_update.jsp" method="get">
<input type="hidden" name="updateName" value="<%=updateName %>">
	<ul>
		<li><label for="나이수정">나이수정</label>
			<input type="number" name = "age" value="<%=age %>">
		</li>
		<li><label for="이름수정">이름수정</label>
			<input type="text" name="name" value="<%=name %>">
		</li>
		<li><label for="학번수정">학번수정</label>
			<input type="text" name="hakbun" value="<%=hakbun %>">
		</li>
		<li><input type="image" src="../images/update.png" class="kh01"></li>
	</ul>
</form>
</body>
</html>