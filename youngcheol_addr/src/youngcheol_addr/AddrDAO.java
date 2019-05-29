package youngcheol_addr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddrDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3306/jspdb?useSSL=false&serverTimezone=UTC";
	
	public boolean add(AddrVO ab) {
		connect(); //jdbc와 연결
		String sql="insert into address values (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ab.getUsername());
			pstmt.setString(2, ab.getTel());
			pstmt.setString(3, ab.getEmail());
			pstmt.setString(4, ab.getSex());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<AddrVO> getAddrList(){
		connect();
		ArrayList<AddrVO> addrlist = new ArrayList<AddrVO>();
		String sql = "select * from address ";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				AddrVO ab = new AddrVO();
				ab.setUsername(rs.getString("username"));
				ab.setTel(rs.getString("tel"));
				ab.setEmail(rs.getString("email"));
				ab.setSex(rs.getString("sex"));
				addrlist.add(ab);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return addrlist;
	}
	
	// jdbc와 연결 끊음
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

	// jdbc와 연결해주는 함수
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root","qnpfr115");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
