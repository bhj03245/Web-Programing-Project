<%@page import="kr.co.kh.board.PageTo"%>
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
	PageTo to = (PageTo)request.getAttribute("page");
	int curPage = to.getCurPage();
	int perPage = to.getPerPage();
	int totalCount = to.getTotalCount();
	int totalPage = totalCount / perPage; //보여줄 페이지 개수
	if(totalCount % perPage != 0) totalPage++;
	
	for(int i=1;i<=totalPage;i++){
		if(curPage==i){
			out.print( "<font size=6 color='red'>"+i +"</font>" );   
		}else{
			 out.print( "<a href='boardList.bo?curPage="+i+"'>"+i  +"</a>&nbsp;" );
		}
	}
%>
</body>
</html>