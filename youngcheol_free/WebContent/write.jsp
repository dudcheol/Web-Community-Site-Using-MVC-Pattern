<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter" %>
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
<section class="container">
		<article class="half">
			<div class="font_noto w900" style="color:#263238; float:left;"><%=(String)session.getAttribute("userName")%></div>
			<div class="font_noto w300">님! 글을 올리고 싶다면 내용을 입력하고, [ 작성 완료 ]버튼을 클릭하세요.</div> 
			<br>
			<div class="font_noto w900" style="color:#263238; float:left; font-size:15pt; text-align:center">글 작성</div>
			<br>
			
			<form method="post" action="http://localhost:8080/youngcheol_free/freeServlet?key=write">
				<!-- Table Header -->
				<table width="100%" cellspacing='0'>
					<!-- Table Header -->
					<thead>
						<tr>
							<th colspan="1" style="width:15%; font-size:12pt">제목</th>
							<th colspan="2">
							<input type="text" class="form-control" placeholder="제목을 입력하세요." name="boardTitle" maxlength="50" style="width:100%; border:0; background-color:transparent; font-size:20pt">
							</th>
						</tr>
					</thead>
					<!-- Table Header -->
	
					<!-- Table Body -->
					<tbody>
						<tr>
						<td colspan="1" style="width:15%;">내용</td>
						<td style="background:white">
						<textarea class="form-control" placeholder="내용을 입력하세요." name="boardContent" maxlength="2048" style="width:100%; height:350px; border:0; font-size: 15pt"></textarea>
						</td>
						</tr><!-- Table Row -->
					</tbody>
					<!-- Table Body -->
				</table>
				<input type="submit" class="navybtn" value="작성 완료" style="float:right; width:15%;">
			</form>
		</article>
</section>
</body>
</html>