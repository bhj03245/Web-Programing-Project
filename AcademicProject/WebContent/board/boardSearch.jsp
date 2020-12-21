<%@page import="kr.co.kh.board.BoardDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardSearch" class="kr.co.kh.board.BoardDAO" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<style>
#boardSearch{
	position: absolute;
	top:300px; left:570px;
	width: 500px;
	background-color:white;
}
table{border: 1px solid black; border-collapse: collapse;}
body{background-image: url(images/back02.jpg);}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<%
	BoardDTO boardDTO = (BoardDTO)request.getAttribute("boardDTO");
	boardSearch.boardReadCount(boardDTO);
%>

<div id = "boardSearch">
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
	
	<tr>
		<td><%=boardDTO.getNo() %></td>
		<td><%=boardDTO.getTitle() %></td>
		<td><%=boardDTO.getContent() %></td>
		<td><%=boardDTO.getAuthor() %></td>
		<td><%=boardDTO.getNal() %></td>
		<td><%=boardDTO.getReadcount()+1 %></td>
	</tr>	
	</table>
<a href="boardList.bo">게시판 목록</a>
</div>
</body>
</html>