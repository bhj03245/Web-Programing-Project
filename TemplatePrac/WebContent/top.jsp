<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>KH정보교육원</title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.innerfade.js"></script>
<style>
body {
	font-family: Arial, sans-serif;
	font-size: 14px;
	line-height: 1.6;
}

#news1{
	position:absolute;
	top: 120px; left:600px;
	width: 500px; height: 100px;
	font-size: 15px;
}

#ALL {
	width: 700px;
	margin: 30px auto;
	background: #FFF;
	padding: 20px;
}

.menu {
	height: 45px;
	background: #000;
}

.menu ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

.menu ul li {
	float: left;
	overflow: hidden;
	text-align: center;
	line-height: 45px;
}

.menu ul li a {
	position: relative;
	display: block;
	width: 110px;
	height: 45px;
	color: #FFF;
	font-family: Arial;
	font-size: 11px;
	font-weight: bold;
	letter-spacing: 1px;
	text-transform: uppercase;
	text-decoration: none;
	cursor: pointer;
}

.menu ul li a span {
	position: absolute;
	top: 0px;
	left: 0;
	width: 110px;
}

.menu ul li a span.over {
	top: -45px;
}

.menu ul li a span.over {
	background: #FFF;
	color: #000;
}

#homeregister{
	position: absolute;
	right:10px; top:0px;
	width:250px; hegith:100px;
	/*border:1px solid red;*/
	font-size:15px;
}
ul{list-style-type: none;}
a{text-decoration: none; color: black;}
a:hover{text-decoration: underline;}
</style>
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
					out.print("<a href=index.jsp?page=board/boardList>커뮤니티</a>");
				}
				else{
					out.print("<a href=index.jsp onclick=alert('로그인하세요')>커뮤니티</a>");
				}	
				%>
				</li>
				<li><a href="#">모집과정</a></li>
				<li><a href="#">KH반클래스</a></li>
				<li><a href="#">포트폴리오</a></li>
			</ul>
		</div>
	</div>
	
	<div id="homeregister">
      <a href="index.jsp">홈|</a>
      <%
      	if(id!=null){
      		out.print("<a href=member/logout.jsp>로그아웃|</a>");
      		out.print("<a href='index.jsp?page=member/memberList'>회원목록|</a>");
      		out.print("<a href='member/memberoutForm.jsp'  onclick=confirm('정말 탈퇴하시겠습니까?')>회원탈퇴</a><br>");	
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
	
	<script type="text/javascript">
		$(function() {

			$(".menu li a").wrapInner('<span class="out"></span>');

			$(".menu li a").each(
					function() {
						$('<span class="over">' + $(this).text() + '</span>')
								.appendTo(this);
					});

			$(".menu li a").hover(function() {
				$(".out", this).stop().animate({
					'top' : '45px'
				}, 200);
				$(".over", this).stop().animate({
					'top' : '0px'
				}, 200);

			}, function() {
				$(".out", this).stop().animate({
					'top' : '0px'
				}, 200);
				$(".over", this).stop().animate({
					'top' : '-45px'
				}, 200);
			});

		});
		
		$('#news').innerfade({
	         animationtype: 'slide',
	         speed: 750,
	         timeout: 2000,
	         type: 'sequence',
	         containerheight: '1em'
	      });
	</script>
</body>
</html>