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
	#boardList{
		position: absolute;
		top:240px; left:580px;
		background-color: white;
	}
	
	table{
		border: 1px solid black;
		border-collapse: collapse;
	}
	th{background-color: black; color: white;}
	body{background-image: url(images/back02.jpg)}
</style>

<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardList">
<table border="1" cellspacing="0" cellpadding="0">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>내용</th>
	<th>작성자</th>
	<th>날짜</th>
	<th>조회수</th>
	<th>&nbsp;</th>
</tr>
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
		String sql = "select no,title,content,author,nal,readcount from boardhj";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readcount = rs.getInt("readcount");
			out.print("<tr><td>"+no+"</td><td>"+title+"</td><td>"+content+"</td><td>"+author+"</td><td>"+nal+"</td><td>"+readcount+"</td><td><a href=boardDelete.jsp?no="+no+">삭제</a></td></tr>");
		}
		stmt.close();
		rs.close();
		conn.close();
	%>
</table>
<a href="index.jsp?page=boardWrite">글작성</a>
</div>
</body>
</html>