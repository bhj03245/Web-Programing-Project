<%@page import="kr.co.kh.board.BoardDTO"%>
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
	#boardUpdate{
		position: absolute;
		top: 250px; left:600px;
		width: 700px; height: 500px;
		border: 1px solid black;
	}
	.kh01{
		width:100px; height:100px;
	}
	
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardUpdate">
<%
	BoardDTO boardDTO = (BoardDTO)request.getAttribute("boardDTO");
	out.print("변경하기 이전 내용입니다.<br>");
	out.print("번호="+boardDTO.getNo()+"제목="+boardDTO.getTitle()+"내용="+boardDTO.getContent()+"작성자="+boardDTO.getAuthor()+"작성일자="+boardDTO.getNal()+"조회수="+boardDTO.getReadcount()+"<br>");
%>
	<form action="boardUpdate.bo" method="get">
		<ul>
			<li><label for="번호">번호</label>
				<input type="number" value="<%= boardDTO.getNo() %>"readonly="readonly">
				<input type="hidden" name="no" value="<%= boardDTO.getNo() %>">
			</li>
			<li><label for="제목">제목</label>
				<input type="text" name="title" value="<%= boardDTO.getTitle() %>" autofocus="autofocus" required="required" placeholder="변경할 제목을 입력해주세요">
				<input type="hidden" name="searchTitle" value="<%=boardDTO.getTitle() %>">
			</li>
			<li><label for="내용">내용</label>
				<textarea rows="10" cols="60" name="content" placeholder="변경할 내용을 입력해주세요"></textarea>
			</li>
			<li><label for="작성자">작성자</label>
				<input type="text" name="author" value="<%= boardDTO.getAuthor() %>" placeholder="변경할 작성자를 입력해주세요">
			</li>
			<li><label for="날짜">날짜</label>
				<input type="date" name="nal" value="<%=boardDTO.getNal() %>" placeholder="변경할 작성일을 입력해주세요">
			</li>
			<li><label for="조회수">조회수</label>
				<input type="text" name="readcount" value="<%=boardDTO.getReadcount() %>" >
			</li>
			<li><input type="image" src="images/update.png" class="kh01"></li>
			<input type="reset" value="되돌리기">
		</ul>
	</form>
</div>
</body>
</html>