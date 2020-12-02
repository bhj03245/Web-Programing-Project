<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>학생등록처리</h1>
<%
	String age = request.getParameter("age");
	String name = request.getParameter("name");
	String hakbun = request.getParameter("hakbun");
%>
<%= age %>:<%=name %>:<%=hakbun %>
</body>
</html>