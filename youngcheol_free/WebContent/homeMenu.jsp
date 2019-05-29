<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="free.persistence.boardDAO"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I LOVE DOG</title>
<link rel="stylesheet" href="resources/homeMenu.css" type="text/css">
<myTag:modalCSS></myTag:modalCSS>
</head>
<body>
	<%-- <myTag:SessionTag /> --%>

	<br>
	<br>
	<myTag:menu></myTag:menu>
		
	<div class="container1">

		<%
			if (session.getAttribute("userEmail") == null || session.getAttribute("userEmail") == "") {
		%>
		<div style=" text-align:center; width: 100%; text-align: center;">
			<div style=" display: inline-block;">
				<div class="font_noto w900" style="float:left; color: #2F354C; ">비회원</div>
				<div class="font_noto w300" style="float:left;">은 갤러리만 볼 수 있습니다.</div>
				<div><a href="join_form.html" class="navybtn" style="font-size:15pt;clear:both;">로그인</a></div>
			</div>
		</div>
		<%
			} else {
		%>
		<div style=" text-align:center; width: 100%; text-align: center;">
			<div style=" display: inline-block;">
				<div class="font_noto w900" style="float:left; color: #2F354C; "><%=session.getAttribute("userName")%></div>
				<div class="font_noto w300" style="float:left;">님 반갑습니다!</div>
			</div>
		</div>
		<%
			}
		%>
		<div class="gallery">
			<div class="gallery-item" onclick="location.href='http://localhost:8080/youngcheol_free/freeServlet?key=home'">
				<div class="gallery-item-image" style="text-align: center">
					<img src="https://image.flaticon.com/icons/svg/1034/1034249.svg"
						width="330">
				</div>
				<div class="gallery-item-description">
					<h3>BOARD</h3>
					<span>게시판에 글을 남길 수 있습니다.</span>
				</div>
			</div>

			<div class="gallery-item" onclick="location.href='http://localhost:8080/youngcheol_free/freeServlet?key=memberList'">
				<div class="gallery-item-image">
					<img src="https://image.flaticon.com/icons/svg/1006/1006004.svg"
						width="330">
				</div>
				<div class="gallery-item-description">
					<h3>MEMBER</h3>
					<span>우리 커뮤니티의 회원 목록을 보여줍니다.</span>
				</div>
			</div>
			<div class="gallery-item" onclick="location.href='gallery.jsp'">
				<div class="gallery-item-image">
					<img src="https://image.flaticon.com/icons/svg/194/194177.svg"
						width="400">
				</div>
				<div class="gallery-item-description">
					<h3>GALLERY</h3>
					<span>귀여운 강아지 사진을 모아놨습니다.</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>