<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>KH정보교육원</title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.innerfade.js"></script>
<link href="css/top.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="ALL">
		<img src="images/kh.png">
		<div class="menu">
			<ul>
				<li><%String id = (String)session.getAttribute("id"); 
					if(id!=null){
					out.print("<a href=index.jsp?page=haksaInfo>학사소개</a>");
					}
					else{
						out.print("<a href=index.jsp onclick=alert('로그인하세요')>학사소개</a>");
					}
				%>
				</li>
					
				<li><%if(id!=null){
					out.print("<a href=boardList.bo>커뮤니티</a>");
				}
				else{
					out.print("<a href=index.jsp onclick=alert('로그인하세요')>커뮤니티</a>");
				}	
				%>
				</li>
				<li><a href="mailForm.jsp">자바메일</a></li>
				<li><a href="zoomkh.jsp">KH반클래스</a></li>
				<li><a href="thumbnail.jsp">포트폴리오</a></li>
			</ul>
		</div>
	</div>
	
	<div id="homeregister">
      <a href="index.jsp">홈|</a>
      <%
      	if(id!=null){
      		out.print("<a href=memberLogout.mb>로그아웃|</a>");
      		out.print("<a href=memberList.mb>회원목록|</a>");
      		out.print("<a href=member/memberoutForm.jsp onclick=confirm('정말 탈퇴하시겠습니까?')>회원탈퇴</a><br>");	
      	}
      	else{
      		out.print("<a href=index.jsp?page=member/memberForm>회원가입|</a>");
      		out.print("<a href='index.jsp?page=member/loginForm'>로그인</a>");
      	}
      %>
   	</div>
	
	<div id ="news1">
      <ul id="news">
         <li>
            <a href="#n1">1 손흥민 </a>
         </li>
         <li>
            <a href="#n2">2 박지성</a>
         </li>
         <li>
            <a href="#n3">3 페이커</a>
         </li>
         <li>
            <a href="#n4">4 월드컵</a>
         </li>
         <li>
            <a href="#n5">5 축구</a>
         </li>      
      </ul>
   </div>
	
<script src="js/top.js"></script>
</body>
</html>