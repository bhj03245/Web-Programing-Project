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
	String broad = request.getParameter("tv");
%>
선택한 방송국은: <%=broad %>
</body>
</html>