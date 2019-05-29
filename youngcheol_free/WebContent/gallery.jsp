<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="free.persistence.boardDAO"%>
<%@ page import="free.domain.boardVO"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I LOVE DOG</title>
<link rel="stylesheet" href="resources/gallery.css" type="text/css">
<myTag:modalCSS></myTag:modalCSS>
</head>
<body>
	<%-- <myTag:SessionTag /> --%>

	<br>
	<br>
	<myTag:menu></myTag:menu>

	<section class="container">
	<h1 style="font-size: 20pt">* Dog Gallery *</h1>
	<article class="half">
	<div class="hover01 column">
		<c:forEach var="i" begin="1" end="39">
			<div style="margin: 5px">
				<figure> <img src="image/dog${i}.jpg"
					style="cursor: pointer" height="300" /> </figure>
			</div>
		</c:forEach>
	</div>
	</article> </section>
</body>
</html>