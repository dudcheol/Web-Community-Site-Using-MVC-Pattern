package free.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import free.domain.boardVO;

public class boardDAO {
	private Connection conn=null;
	private ResultSet rs;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?useSSL=false&serverTimezone=UTC";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook","passwd");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시판을 올린 시간 받아오기
	public String getDate() {
		connect();
		String SQL="select now()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	//게시글번호가 1번부터 1씩 늘어나야 하기 때문에 마지막에 더한 값에 더해서 올려야함
	public int getNext() {
		connect();
		String SQL="select boardID from board order by boardID desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 1; // 첫번째  게시글
	}
	
	// 게시판에 글쓰기
	public int write(String boardTitle, String userName, String boardContent) {
		connect();
		String SQL="insert into board values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext()); //몇번째게시글인지
			pstmt.setString(2, boardTitle); //글제목
			pstmt.setString(3, userName); //유저이름
			pstmt.setString(4, getDate()); //날짜받아옴
			pstmt.setString(5, boardContent); //게시글내용
			pstmt.setInt(6, 1); //페이지에서 존재하는글인지 삭제된글인지
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //db오류
	}
	
	public ArrayList<boardVO> getList(){
		connect();
		String SQL="select  * from board where boardID < ? and boardAvailable = 1 order by boardID desc";
		ArrayList<boardVO> list = new ArrayList<boardVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			rs = pstmt.executeQuery();
				while(rs.next()) {
					boardVO bVO = new boardVO();
					bVO.setBoardID(rs.getInt(1));
					bVO.setBoardTitle(rs.getString(2));
					bVO.setUserName(rs.getString(3));
					bVO.setBoardDate(rs.getString(4));
					bVO.setBoardContent(rs.getString(5));
					bVO.setBoardAvailable(rs.getInt(6));
					list.add(bVO);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list; 
	}
	
	public boardVO getBoard(int boardID) {
		connect();
		String SQL="select * from board where boardID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, boardID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardVO bVO = new boardVO();
				bVO.setBoardID(rs.getInt(1));
				bVO.setBoardTitle(rs.getString(2));
				bVO.setUserName(rs.getString(3));
				bVO.setBoardDate(rs.getString(4));
				bVO.setBoardContent(rs.getString(5));
				bVO.setBoardAvailable(rs.getInt(6));
				return bVO;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null; // 첫번째  게시글
	}
}
