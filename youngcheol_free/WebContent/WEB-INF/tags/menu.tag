<%@ tag language="java" pageEncoding="UTF-8"%>
<nav class="nav center">
	<ul>
		<li><a href="homeMenu.jsp">Home</a></li>
		<li><a href="http://localhost:8080/youngcheol_free/freeServlet?key=home">Board</a></li>
		<li><a href="http://localhost:8080/youngcheol_free/freeServlet?key=memberList">Member</a></li>
		<li><a href="gallery.jsp">Gallery</a></li>
		<li>
			<%
				if (session.getAttribute("userEmail") == null || session.getAttribute("userEmail") == "") {
			%> <a href="join_form.html" style="color: #58ACFA;"><span>Log In</span></a> <%
 	} else {
 %> <a href="javascript:void(0)" style="color: #FA5858;"
			onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'"><span>Log
					Out</span></a> <%} %>
		</li>
	</ul>
</nav>

<div id="light" class="white_content font_noto w300">
	<image src="https://image.flaticon.com/icons/svg/194/194279.svg"
		width="50px" height="50px">
	<h1>로그아웃하시겠습니까?</h1>
	<br />
	<div class="script" style="float: right">
		<a href="http://localhost:8080/youngcheol_free/freeServlet?key=logout" class="button-3d" style="font-size: 12pt"
			onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">예</a>
		<a href="javascript:void(0)" class="button-3d" style="font-size: 12pt"
			onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">아니오</a>
	</div>
</div>
<div id="fade" class="black_overlay"></div>