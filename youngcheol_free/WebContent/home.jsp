<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="free.persistence.boardDAO"%>
<%@ page import="free.domain.boardVO"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag"%>
<% ArrayList<boardVO> list = (ArrayList<boardVO>)request.getAttribute("list"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I LOVE DOG</title>
<link rel="stylesheet" href="resources/home.css" type="text/css">
<myTag:modalCSS></myTag:modalCSS>
</head>
<body>
	<myTag:SessionTag />

	<br>
	<br>
	<myTag:menu></myTag:menu>
	<section class="container"> <article class="half">
	<div class="font_noto w900" style="color: #263238; float: left;"><%=(String) session.getAttribute("userName")%></div>
	<div class="font_noto w300">님 안녕하세요! 제목을 클릭하면 게시글을 확인할 수 있습니다.</div>
	<br>
	<div class="font_noto w900"
		style="color: #263238; float: left; font-size: 15pt; text-align: center">게시판</div>
	<br>
	<!-- Table Header -->
	<table width="100%" cellspacing='0'>
		<!-- cellspacing='0' is important, must stay -->

		<!-- Table Header -->
		<thead>
			<tr>
				<th style="width: 5%; font-size: 12pt">no</th>
				<th style="width: 55%; font-size: 12pt">제목</th>
				<th style="width: 20%; font-size: 12pt">작성자</th>
				<th style="width: 20%; font-size: 12pt">작성일</th>
			</tr>
		</thead>
		<!-- Table Header -->

		<!-- Table Body -->
		<tbody>
			<%
				for (int i = 0; i < list.size(); i++) {
					if (i % 2 == 1) {
			%>
			<tr>
				<td><%=list.get(i).getBoardID()%></td>
				<td><a
					href="http://localhost:8080/youngcheol_free/freeServlet?key=view&boardID=<%=list.get(i).getBoardID()%>"><%=list.get(i).getBoardTitle()%></a></td>
				<td><%=list.get(i).getUserName()%></td>
				<td><%=list.get(i).getBoardDate().substring(0, 11)%></td>
			</tr>
			<%
				} else {
			%>
			<tr class="even">
				<td><%=list.get(i).getBoardID()%></td>
				<td><a
					href="http://localhost:8080/youngcheol_free/freeServlet?key=view&boardID=<%=list.get(i).getBoardID()%>"><%=list.get(i).getBoardTitle()%></a></td>
				<td><%=list.get(i).getUserName()%></td>
				<td><%=list.get(i).getBoardDate().substring(0, 11)%></td>
			</tr>
			<%
				}
				}
			%>
		</tbody>
		<!-- Table Body -->
	</table>
	<a href="write.jsp" class="navybtn" style="float: right; width: 15%;">글쓰기</a>
	</article> </section>
</body>
</html>