<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{background-image: url(images/back02.jpg);}
#boardSearch{
	position: absolute;
	top:300px; left:570px;
	width: 500px;
}
.kh01{
	position: absolute;
	top: 0px; left: 300px;
	width:100px; height: 70px;
	border-radius: 5px;
}
#boardResult{
	position:absolute;
	top: 400px; left: 570px;
	border: 3px solid black;
}
table{border: 1px solid black; border-collapse: collapse;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardSearch">
<form action="boardSearch.jsp" method="get">
	<ul>
		<li><input type="hidden" name="boardTest" value="index.jsp?page=boardSearchForm"></li>
		<li><label for="제목">제목</label>
			<input type="text" name="title" autofocus="autofocus" required="required" placeholder="제목입력">
		</li>
		<li><input type="image" src="images/search.jpeg" class="kh01"></li>
	</ul>
</form>

<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String no = request.getParameter("no");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String author = request.getParameter("author");
	String nal = request.getParameter("nal");
	String readcount = request.getParameter("readcount");
	if(no == null||no.equals("0")){
		out.print("");
	}
	else{
%>
<a href="index.jsp?page=board/boardList">게시판목록</a>&nbsp;&nbsp;&nbsp;
<a href="index.jsp?page=board/boardWrite">게시판글작성</a>
</div>
<div id="boardResult">
	<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<%
		out.print("<tr><td>"+no+"</td><td>"+title+"</td><td>"+content+"</td><td>"+author+"</td><td>"+nal+"</td><td>"+readcount+"</td></tr>");
	%>
	<% } %>
	</table>
</div>
</body>
</html>