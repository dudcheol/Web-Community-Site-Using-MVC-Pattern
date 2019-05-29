package free.Service;

import free.persistence.*;

public class LoginAction {
	/*
	String userEmail = null;
	if(session.getAttribute("userEmail")!=null){
		userEmail = (String)session.getAttribute("userEmail");
	}
	if(userEmail!=null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어있습니다.')");
		script.println("location.href='homeMenu.jsp'");
		script.println("</script>");
	}
	*/
	//DB에 저장된 유저 비밀번호와 유저가 폼에서 입력한 비밀번호가 일치하는가?
	public int comparePW(String userEmail, String userPassword) {
		UserDAO userDAO = new UserDAO();
		// 이메일과 일치하는 비밀번호  받아옴
		String userEmail_equals_PW = userDAO.login(userEmail);
		if (userEmail_equals_PW == null) {
			return -2; // db오류
		} else if (userEmail_equals_PW.equals("error_NotFoundEmail")) {
			return -1; // 일치하는 이메일 찾을 수 없음
		} else if(userEmail_equals_PW.equals(userPassword)) {
			return 1; // 일치함
		} else return 0; // 불일치
	}
}
