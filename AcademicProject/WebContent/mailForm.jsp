<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table{
		width:560px;
		margin: auto;
	}
	h1{
		text-align: center;
	}
	
	td{
		border: 1px dotted blackl
	}
	body{background-image: url(images/back02.jpg)}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="mailSend" method="post">
<H1>자바 메일보내기</H1>
<table>
	<tr><td>발신자 이메일: </td><td><input type="text" name="sender"></td></tr>
	<tr><td>수신자 이메일: </td><td><input type="text" name="receiver"></td></tr>
	<tr><td>제목: </td><td><input type="text" name="title"></td></tr>
	<tr>
		<td>내용: </td>
		<td><textarea name="content" cols="40" rows="20"></textarea></td>
	</tr>
	<tr><td align="center" colspan="2"><input type="submit" value="보내기"></td></tr>
</table>
</form>
</body>
</html>