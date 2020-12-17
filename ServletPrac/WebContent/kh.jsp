<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.innerfade.js"></script>
<style>
	body{background-image: url(images/back02.jpg)}
	#kh01{
		position: absolute;
		top: 200px; left: 540px;
		width: 100px; height:100px;
	}
	
	.khmain{width:750px; height:530px;}
	
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="kh01">
	<ul id="portfolio"> 
		<li>
			<a href="index.jsp?page=haksaInfo">
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
<script>
	$('#portfolio').innerfade({
		speed: 'slow',
		timeout: 3000,
		type: 'sequence',
		containerheight: '220px'
	});
</script>
</body>
</html>