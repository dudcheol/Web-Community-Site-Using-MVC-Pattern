<%@ tag language="java" import="java.io.PrintWriter" pageEncoding="UTF-8"%>

<%
	// 세션확인
	if(session.getAttribute("userEmail")==null || session.getAttribute("userEmail")==""){
		PrintWriter script=response.getWriter();
		script.println("<script>");
		script.println("alert('회원만 접근 가능합니다. 로그인 해주세요.')");
		script.println("location.href='join_form.html'");
		script.println("</script>");
	}
%>