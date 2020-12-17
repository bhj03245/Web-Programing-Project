<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pagefile=request.getParameter("page");
	if(pagefile==null){
	pagefile="kh";
}
%>   
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.innerfade.js"></script>
<style>
	#top{
		position: absolute;
		top:0px; left:580px;
	}
	
	#left{
		position: absolute;
		top:300px; left:0px;
	}
	
	#center{
		position: absolute;
		top:200px; left:580px;
		width:300px; height:300px;
	}
	
	#bottom{
		position: absolute;
		top:500px; 
	}
	
</style>
<meta charset="UTF-8">
<title>KH정보교육원</title>
</head>
<body>
<div id="top">
	<jsp:include page="top.jsp"/>
</div>

<div id="left"></div>
	<jsp:include page="left.jsp"/>
</div>

<div id=""ceneter">
	<jsp:include page='<%=pagefile+".jsp" %>'></jsp:include>
</div>

<div id="bottom">
	<jsp:include page="bottom.jsp"/>
</div>
</body>
</html>