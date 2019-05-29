package free.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import free.domain.MemberVO;
import free.domain.UserVO;
import free.domain.boardVO;

public class UserDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?useSSL=false&serverTimezone=UTC";
	
	//연결설정
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook","passwd");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*//로그인
	public int login(String userEmail, String userPassword) {
		connect();
		String SQL="select userPassword from user where userEmail = ?";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공
				}
				else return 0; //비밀번호 불일치(로그인 실패)
			}
			return -1; //이메일 없음
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -2; //db오류
	}*/
	public String login(String userEmail) {
		connect();
		String SQL="select userPassword from user where userEmail = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
			return "error_NotFoundEmail";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; //db오류
	}
	
	
	public int join(String userEmail, String userPassword, String userName) {
		connect();
		String SQL="insert into user values (?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userEmail);
			pstmt.setString(2, userPassword);
			pstmt.setString(3, userName);
			return pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return -1; //db 오류
	}
	
	public String findName(String userEmail) {
		connect();
		String SQL="SELECT userName FROM user WHERE userEmail = ?";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,userEmail);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			else return "DB error";
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return "DB error";
	}
	
	public ArrayList<MemberVO> getUserList() {
		connect();
		String SQL="select * from user";
		ArrayList<MemberVO> userList = new ArrayList<MemberVO>();
		try {
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setUserEmail(rs.getString(1));
				member.setUserName(rs.getString(3));
				userList.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return userList;
	}
}
