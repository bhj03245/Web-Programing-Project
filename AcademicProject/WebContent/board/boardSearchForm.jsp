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
<form action="boardSearch.bo" method="get">
	<ul>
		<li><input type="hidden" name="readcount" value="0"></li>
		<li><label for="제목">제목</label>
			<input type="text" name="searchTitle" autofocus="autofocus" required="required" placeholder="제목입력">
		</li>
		<li><input type="image" src="images/search.jpeg" class="kh01"></li>
	</ul>
</form>

<a href="boardList.bo">게시판목록</a>&nbsp;&nbsp;&nbsp;
<a href="index.jsp?page=board/boardWrite">게시판글작성</a>
</div>
</body>
</html>