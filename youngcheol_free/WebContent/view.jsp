<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="free.domain.boardVO"%>
<%boardVO bVO = (boardVO)request.getAttribute("board");%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I LOVE DOG</title>
<link rel="stylesheet" href="resources/write.css" type="text/css">
<myTag:modalCSS></myTag:modalCSS>
</head>
<body>
<myTag:SessionTag/>

	<br>
	<br>
	<myTag:menu></myTag:menu>
	<section class="container"> <article class="half">
	<div class="font_noto w900" style="color: #2F354C; float: left;"><%=bVO.getUserName() %></div>
	<div class="font_noto w300">님의 게시글입니다.</div>
	<br>
		<div class="font_noto w900" style="color:#263238; float:left; font-size:15pt; text-align:center">게시글</div>
	<br>
	<!-- Table Header -->
	<table width="100%" cellspacing='0'>
		<!-- Table Header -->
		<thead>
			<tr>
				<th colspan="1" style="width:15%; font-size:12pt;">제목</th>
				<th colspan="3" style="font-size:12pt;"><%=bVO.getBoardTitle() %></th>
			</tr>
		</thead>
		<!-- Table Header -->

		<!-- Table Body -->
		<tbody>
			<tr class="even">
				<td colspan="1" style="width:15%">작성자</td>
				<td colspan="1" style="width:35%"><%=bVO.getUserName() %></td>
				<td colspan="1" style="width:15%">작성일자</td>
				<td colspan="1" style="width:35%"><%=bVO.getBoardDate().substring(0,11) %></td>
			</tr>
			<tr>
				<td colspan="1">내용</td>
				<td colspan="3" valign="top" style="background:white"><%=bVO.getBoardContent() %></td>
			</tr>
			<!-- Table Row -->
		</tbody>
		<!-- Table Body -->
	</table>
	<a href="http://localhost:8080/youngcheol_free/freeServlet?key=home" class="navybtn" style="float:right; width:15%;">목록보기</a>
	 </article> </section>
</body>
</html>