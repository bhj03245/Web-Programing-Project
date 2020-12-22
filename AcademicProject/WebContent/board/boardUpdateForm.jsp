<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body{background-image: url(images/back02.jpg);}
	#boardUpdateForm{
		position: absolute;
		top: 250px; left:600px;
		width: 300px; height: 200px;
		border: 1px solid black;
	}
	.update{
		width: 250px; height: 100px;
	}
	
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardUpdateForm">
<form action="boardUpdateSearch.bo" method="get">
	<ul>
		<li><label for="수정할제목">수정할제목&nbsp;</label>
			<input type="text" name="updateTitle" autofocus="autofocus" placeholder="수정할 제목을 입력" required="required">
		</li>
		<li><input type="image" src="images/update.png" class="update"></li>
	</ul>
</form>
</div>
</body>
</html>