<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>KH정보교육원</title>
<style>
body {
	font-family: Arial, sans-serif;
	font-size: 14px;
	line-height: 1.6;
}

#news1{
	position:absolute;
	top: 120px; left:640px;
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
	right:0px; top:0px;
	width:150px; hegith:100px;
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
				<li><a href="index.jsp?page=haksaInfo">학사소개</a></li>
				<li><a href="index.jsp?page=board/boardList">커뮤니티</a></li>
				<li><a href="#">모집과정</a></li>
				<li><a href="#">KH반클래스</a></li>
				<li><a href="#">포트폴리오</a></li>
			</ul>
		</div>
	</div>
	
	<div id="homeregister">
      <a href="index.jsp">홈|</a>
      <a href="#">회원가입|</a>
      <a href="#">로그인</a>
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
	
</body>
</html>