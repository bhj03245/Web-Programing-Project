<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.kh01{
		width:100px; height:50px;
	}
	#memberUpdate{
		position: absolute;
		top: 250px; left:700px;
		width: 400px; height: 300px;
		border: 1px solid black;
	}
	ul{list-style-type: none;}
	body{background-image: url(../images/back02.jpg);}
	h1{text-align:center;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<%	
	String id = null;
	String pw = null;
	String addr = null;
	String tel = null;
	String chkid = (String)session.getAttribute("id");
	String updateId = request.getParameter("id");
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후
	String sql = "select id,pw,addr,tel from memberhj where id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,updateId);
	ResultSet rs = null;
	rs = pstmt.executeQuery();
	if(!rs.isBeforeFirst()){
		out.print("<script>alert('해당하는 아이디가 없습니다.'); location.href='../index.jsp?page=member/memberList';</script>");  
	}
	if(!chkid.equals(updateId)){
		out.print("<script>alert('로그인된 아이디만 수정할 수 있습니다.'); location.href='../index.jsp?page=member/memberList';</script>");  
	}
	while(rs.next()){
		id = rs.getString("id");
		pw = rs.getString("pw");
		addr = rs.getString("addr");
		tel = rs.getString("tel");
		out.print("변경하기 전 회원정보입니다.<br>");
		out.print("아이디: "+id+"  패스워드: "+pw+"  주소: "+addr+"  전화번호: "+tel);
	}
%>
<div id="memberUpdate">
<h1>회원 수정</h1>
<form action="memberUpdate.jsp" method="get">
	<ul>
		<li><label for="아이디">아&nbsp;&nbsp;이&nbsp;&nbsp;디</label>
				<input type="text" name="id" size="20" maxlength="20" autofocus="autofocus" required="required" placeholder="변경할아이디를입력하세요.">
				<input type="hidden" name="updateId" value="<%=updateId%>">
			</li>
			<li><label for="패스워드">패스워드&nbsp;</label>
				<input type="password" name="pw" size="20" maxlength="" placeholder="변경할패스워드입력">
			</li>
			<li><label for="주소">&nbsp;&nbsp;&nbsp;주&nbsp;&nbsp;&nbsp;소&nbsp;</label>
				<input type="text" name="addr" size="20" maxlength="100" placeholder="변경할주소입력">
			</li>
			<li><label for="핸드폰">핸&nbsp;&nbsp;드&nbsp;&nbsp;폰</label>
				<input type="text" name="tel" placeholder="010-xxxx-xxxx">
			</li>
			<li><input type="image" src="../images/update.png" class="kh01">
				<input type="reset" value="되돌리기" class="reset">
			</li>
	</ul>
</form>
</div>
</body>
</html>