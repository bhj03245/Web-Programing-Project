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
	body{background-image: url(images/back02.jpg);}
	.kh01{
		width:100px; height:100px;
	}
	
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<%
	String searchTitle = request.getParameter("searchTitle");
	int no = 0;
	String title = null;
	String content = null;
	String author = null;
	String nal = null;
	String readcount = null;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
	String sql = "select no,title,content,author,nal,readcount from boardhj where title = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,searchTitle);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		no = rs.getInt("no");
		title = rs.getString("title");
		content = rs.getString("content");
		author = rs.getString("author");
		nal = rs.getString("nal");
		readcount = rs.getString("readcount");
	}

%>

<div id="boardUpdate">
	<form action="boardUpdate.jsp" method="get">
		<ul>
			<li><label for="번호">번호</label>
				<input type="number" value="<%= no %>"readonly="readonly">
				<input type="hidden" name="no" value="<%= no %>">
			</li>
			<li><label for="제목">제목</label>
				<input type="text" name="title" value="<%= title %>" autofocus="autofocus" required="required" placeholder="변경할 제목을 입력해주세요">
				<input type="hidden" name="searchTitle" value="<%=searchTitle %>">
			</li>
			<li><label for="내용">내용</label>
				<textarea rows="20" cols="80" name="content" placeholder="변경할 내용을 입력해주세요"></textarea>
			</li>
			<li><label for="작성자">작성자</label>
				<input type="text" name="author" value="<%= author %>" placeholder="변경할 작성자를 입력해주세요">
			</li>
			<li><label for="날짜">날짜</label>
				<input type="date" name="nal" value="<%= nal %>" placeholder="변경할 작성일을 입력해주세요">
			</li>
			<li><label for="조회수">조회수</label>
				<input type="text" name="readcount" value="<%= readcount %>" >
			</li>
			<li><input type="image" src="../images/update.png" class="kh01"></li>
			<input type="reset" value="되돌리기">
		</ul>
	</form>
</div>
</body>
</html>