<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="managerDAO" class="kr.co.kh.academic.ManagerDAO" scope="page"/>
<jsp:useBean id="managerDTO" class="kr.co.kh.academic.ManagerDTO" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<style>
	table{border: 3px solid skyblue; border-collapse: collapse; width: 500px; height: 200px;}
	th{border: 1px solid blue; background-color: yellow;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<body>
<h1>관리자 전체출력</h1>
<%
	ResultSet rs = managerDAO.managerListSql();
%>
<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th>번호</th>
		<th>나이</th>
		<th>이름</th>
		<th>부서</th>
	</tr>
<%
while(rs.next()){
	managerDTO.setNo(rs.getInt("no"));
	managerDTO.setAge(rs.getString("age"));
	managerDTO.setName(rs.getString("name"));
	managerDTO.setPart(rs.getString("part"));
	out.print("<tr>");
	out.print("<td>"+managerDTO.getNo()+"</td>");
	out.print("<td>"+managerDTO.getAge()+"</td>");
	out.print("<td>"+managerDTO.getName()+"</td>");
	out.print("<td>"+managerDTO.getPart()+"</td>");
	out.print("</tr>");
}
%>
</table>
<a href="manager.jsp">관리자 등록</a>&nbsp;&nbsp;
<a href="manager_searchForm.jsp">관리자 검색</a>&nbsp;&nbsp;
<a href="manager_deleteForm.jsp">관리자 삭제</a>&nbsp;&nbsp;
<a href="manager_updateForm.jsp">관리자 수정</a>&nbsp;&nbsp;
<a href="../index.jsp?page=haksaInfo">메인 페이지</a>
</body>
</html>