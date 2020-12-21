<%@page import="kr.co.kh.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<BoardDTO> boardList =(ArrayList<BoardDTO>)request.getAttribute("boardList");
	for(int i=0;i<boardList.size();i++){
		BoardDTO boardDTO = boardList.get(i);
%>
<tr>
	<td><%=boardDTO.getNo() %></td>
	<td><%=boardDTO.getTitle() %></td>
	<td><%=boardDTO.getContent() %></td>
	<td><%=boardDTO.getAuthor() %></td>
	<td><%=boardDTO.getNal() %> </td>
	<td><%=boardDTO.getReadcount() %></td>
	<td><a href="boardDelete.bo?no=<%=boardDTO.getNo() %>">삭제</a></td>
</tr>
<%} %>
</table>
<a href="index.jsp?page=board/boardWrite">게시판글작성</a>&nbsp;&nbsp;&nbsp;
<a href="index.jsp?page=board/boardSearchForm">게시판글검색</a>&nbsp;&nbsp;&nbsp;
<a href="index.jsp?page=board/boardUpdateForm">게시판글수정</a>
</div>
</body>
</html>