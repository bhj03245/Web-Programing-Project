<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="studentDAO" class="kr.co.kh.academic.StudentDAO" scope="page"/>
<jsp:useBean id="studentDTO" class="kr.co.kh.academic.StudentDTO" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<style>
	table{border: 3px solid skyblue; border-collapse: collapse; width:500px; height:200px;}
	th{border: 1px solid blue; background-color: yellow;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>학생 전체출력</h1>
<%
	ResultSet rs = studentDAO.studentListSql();
%>
<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th>번호</th>
		<th>나이</th>
		<th>이름</th>
		<th>학번</th>
	</tr>
<%
	while(rs.next()){
	studentDTO.setNo(rs.getInt("no"));
	studentDTO.setAge(rs.getString("age"));
	studentDTO.setName(rs.getString("name"));
	studentDTO.setHakbun(rs.getString("hakbun"));
	out.print("<tr>");
	out.print("<td>"+studentDTO.getNo()+"</td>");
	out.print("<td>"+studentDTO.getAge()+"</td>");
	out.print("<td>"+studentDTO.getName()+"</td>");
	out.print("<td>"+studentDTO.getName()+"</td>");
	out.print("</tr>");
	}
%>
</table>
<a href="student.jsp">학생 등록</a>&nbsp;&nbsp;
<a href="student_searchForm.jsp">학생 검색</a>&nbsp;&nbsp;
<a href="student_deleteForm.jsp">학생 삭제</a>&nbsp;&nbsp;
<a href="student_updateForm.jsp">학생 수정</a>&nbsp;&nbsp;
<a href="../index.jsp?page=haksaInfo">메인 페이지</a>
</body>
</html>