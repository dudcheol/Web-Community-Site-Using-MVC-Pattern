<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="free.persistence.UserDAO" %>
<%@ page import="free.domain.UserVO" %>
<%@ page import="free.domain.MemberVO" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I LOVE DOG</title>
<link rel="stylesheet" href="resources/home.css" type="text/css">
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
			<div class="font_noto w300">님! 다른 회원의 이메일을 참고해보세요.</div> 
			<br>
			<div class="font_noto w900" style="color:#263238; float:left; font-size:15pt; text-align:center">회원 목록</div>
			<br>
			<!-- Table Header -->
	<table width="100%" cellspacing='0'> <!-- cellspacing='0' is important, must stay -->

	<!-- Table Header -->
	<thead>
		<tr>
			<th style="width:5%; font-size:12pt">no</th>
			<th style="width:65%;font-size:12pt">회원 이메일</th>
			<th style="width:30%;font-size:12pt">회원 닉네임</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
		<%-- <%
			UserDAO userDAO = new UserDAO();
			ArrayList<UserVO> list = userDAO.getUserList();
			for(int i=0; i<list.size(); i++){
				if(i%2==1){
		%> --%>
		<c:forEach var="member" items="${members }" varStatus="status" >
			<c:if test="${status.count%2==1 }">
				<tr>
					<td><c:out value="${status.count }"/></td>
					<td><c:out value="${member.userEmail }" escapeXml="false">
						<font color=#CB8686> * 관리자의 이메일은 95_pyc@naver.com 입니다. *</font>
						</c:out>
					</td>
					<td><c:out value="${member.userName }">
						</c:out>
					</td>
				</tr>
			</c:if>
			<c:if test="${status.count%2==0 }">
				<tr class="even">
					<td><c:out value="${status.count }"/></td>
					<td><c:out value="${member.userEmail }" escapeXml="false">
						<font color=#CB8686> * 관리자의 이메일은 95_pyc@naver.com 입니다. *</font>
						</c:out>
					</td>
					<td><c:out value="${member.userName }">
						</c:out>
					</td>
				</tr>
			</c:if>
		</c:forEach>
				<%-- <tr>
					<td><%=i+1 %></td>
					<td><%= list.get(i).getUserEmail() %></td>
					<td><%= list.get(i).getUserName() %></td>
				</tr>
		<%
				}
				else {
		%>
				<tr class="even">
					<td><%=i+1 %></td>
					<td><%= list.get(i).getUserEmail() %></td>
					<td><%= list.get(i).getUserName() %></td>
				</tr>
		<%
				}
			}
		%> --%>
	</tbody>
	<!-- Table Body -->
</table>
		</article>
</section>
</body>
</html>