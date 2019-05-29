package free.domain;

public class MemberVO {

	// 회원 정보 멤버 변수
	private String userName;
	private String userEmail;
	
	public MemberVO(String userName,String userEmail) {
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	// 기본 생성자인 경우 다음과 같이 신규 정보로 초기화
	public MemberVO() {
		userName="default";
		userEmail="default";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
}