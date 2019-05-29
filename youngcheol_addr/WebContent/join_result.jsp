<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="youngcheol_addr.AddrVO" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% AddrVO vo = (AddrVO)request.getAttribute("address"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>가입 결과</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/join_result.css" type="text/css"></link>

</head>
<body>
<div id="wrapper">
<div class="bubble">
<div class="rectangle"><h2>주소록 등록을 축하합니다.</h2></div>
<div class="triangle-l"></div>
<div class="triangle-r"></div>
	<div class="info">
	<div class="table-responsive">
	<table class="table table-striped">
	<tr>
		<th>이름</th>
		<td><%=vo.getUsername() %></td></tr>
	<tr>
		<th>전화번호</th>
		<td><%=vo.getTel() %></td></tr>
	<tr>
		<th>이메일</th>
		<td><%=vo.getEmail() %></td></tr>
	<tr>
		<th>성별</th>
		<td><%=vo.getSex() %></td></tr>
	</table>
	</div>
	</div>
	</div>
	<div class="center margin">
	<a href="http://localhost:8080/youngcheol_addr/AddrServlet?key=list" class="button-3d text3">전체 주소록 보기</a>
	</div>
	</div>
</body>
</html>