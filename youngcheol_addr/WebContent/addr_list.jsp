<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="youngcheol_addr.*, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 주소록</title>
<link rel="stylesheet" href="resources/address.css" type="text/css"></link>
</head>
<body>
<div id="menuCenter">
<div class="shadow text1">Study Club AddressBook List</div>
<div class="whiteColor text2 margin script"><span><a href="http://localhost:8080/youngcheol_addr/club_main.html" class="button-3d text5">메인 페이지 이동</a></span></div></div>

	<table>
		<tr><th>이름</th><th>전화번호</th><th>이메일</th><th>성별</th></tr>
		<%
			List<AddrVO> addrList = (List<AddrVO>)request.getAttribute("addressList");
			for(AddrVO vo : addrList){
		%>
		<tr>
			<td><%=vo.getUsername() %></td>
			<td><%=vo.getTel() %></td>
			<td><%=vo.getEmail() %></td>
			<td><%=vo.getSex() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>