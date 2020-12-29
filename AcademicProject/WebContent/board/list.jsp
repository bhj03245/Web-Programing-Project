<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="boardList">
<h1>커뮤니티 목록</h1>
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
   <c:forEach items="${list }" var="board">
   <tr>
      <td><a href="editForm.bo?no=${board.no }">${board.no }</a></td>
      <td>${board.title }</td>
      <td>${board.content }</td>
      <td>${board.author }</td>
      <td>${board.nal }</td>
      <td>${board.readcount }</td>
      <td><a href="boardDelete.bo?no=${board.no }">삭제</a></td>
   </tr>
   </c:forEach>   
   <tr>
      <td colspan="7"><jsp:include page="page.jsp" flush="true"/></td>
   </tr>
</table>
<a href="index.jsp?page=board/boardWrite">게시판글작성</a>&nbsp;&nbsp;&nbsp;
<a href="index.jsp?page=board/boardSearchForm">게시판글검색</a>&nbsp;&nbsp;&nbsp;
<a href="index.jsp?page=board/boardUpdateForm">게시판글수정</a>
</div>
</body>
</html>