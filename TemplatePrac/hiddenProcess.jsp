<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<%
	String hidden = request.getParameter("hidden");
%>
안보이는 값 전송: <%= hidden %>
</body>
</html>