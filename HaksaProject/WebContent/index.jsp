<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.innerfade.js"></script>

<style type="text/css">
#kh01{
	position: absolute;
	top: 150px; left: 400px;
	width: 1000px; height:1000px;
	}
#khmaintitle{
	position: absolute;
	width: 100%; height: 100px;
	top: 90px; left: 320px;
	font-size: 10px;
}
#news1{
	position:absolute;
	top:90px; left:1400px;
	width: 500px; height: 100px;
	font-size: 10px;
}
#khmember{
	position: absolute;
	top: 0px; right: 0px;
	width:300px; height:100px;
	font-size: 7px;
}

.khlogo{width:300px; height: 100px;}
.khmain{width:1000px; height:1000px;}


ul{list-style-type: none;}
li{float:left; margin:20px;}
a{text-decoration: none; color: black; font-size:2em;}
a:hover{text-decoration: underline;}
hr{border: 10px solid skyblue;}
body{background-image: url(images/back02.jpg)}

</style>

<!-- <link rel="stylesheet" type="text/css" href="css/khstyle.css"> -->
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>

<h1><img src="images/kh.png" class="khlogo"></h1>

<div id="khmember">
	<a href="#">홈|</a>
	<a href="#">회원가입|</a>
	<a href="#">로그인</a>
</div>

<div id="khmaintitle">
	<ul>
		<li><a href="haksaInfo.jsp">학사소개</a></li>
		<li><a href="#">커뮤니티</a></li>
		<li><a href="#">모집과정</a></li>
		<li><a href="#">KHBCLASS</a></li>
	</ul>
</div>
<hr>
<div id="kh01">
	<ul id="portfolio"> 
		<li>
			<a href="#">
				<img src="images/cat.jpg" title="image1" class="khmain"/>
			</a>
		</li>
		<li>
			<a href="#">
				<img src="images/cat2.jpg" title="image2" class="khmain"/>
			</a>
		</li> 
		<li>
			<a href="#">
				<img src="images/cat3.jpg" title="image3" class="khmain"/>
			</a>
		</li> 
		<li>
			<a href="#">
				<img src="images/cat4.jpg" title="image4" class="khmain"/>
			</a>
		</li> 
		<li>
			<a href="#">
				<img src="images/cat3.jpg" title="image5" class="khmain"/>
			</a>
		</li> 
	</ul>
</div>

<div id="news1">	
	<ul id="news">
		<li>
			<a href="#n1">1 KH정보교육원</a>
		</li>
		<li>
			<a href="#n2">2 서울시 영등포구 당산지원</a>
		</li>
		<li>
			<a href="#n3">3 이제 수업 그만해</a>
		</li>
		<li>
			<a href="#n4">4 그만할 때 됐어</a>
		</li>
		<li>
			<a href="#n5">5 KHBCLASS</a>
		</li>
		<li>
			<a href="#n6">6 고양이는 귀엽지</a>
		</li>
		<li>
			<a href="#n7">7 그러나 키우고 싶진않다.</a>
		</li>
		<li>
			<a href="#n8">8 털이 많으니까.</a>
		</li>
	</ul>
</div>

<script>
	$('#portfolio').innerfade({
		speed: 'slow',
		timeout: 4000,
		type: 'sequence',
		containerheight: '220px'
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