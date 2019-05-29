package free.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import free.Service.JoinAction;
import free.Service.LoginAction;
import free.Service.WriteAction;
import free.domain.*;
import free.persistence.*;

/**
 * Servlet implementation class freeServlet
 */
@WebServlet("/freeServlet")
public class freeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public freeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String cmd = "";
		cmd = request.getParameter("key");

		if (cmd.equals("join")) {
			response.sendRedirect("homeMenu.jsp");
		}

		// 로그아웃 세션처리
		if (cmd.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='homeMenu.jsp'");
			script.println("</script>");
		}
		
		// 멤버리스트
		if(cmd.equals("memberList")) {
			UserDAO userDAO = new UserDAO();
			ArrayList<MemberVO> dataList = userDAO.getUserList();
			dataList.add(new MemberVO("관리자 : 박영철",null));
			
			request.setAttribute("members", dataList);
			RequestDispatcher view = request.getRequestDispatcher("memberList.jsp");
			view.forward(request, response);
		}
		
		// 게시판 홈
		if(cmd.equals("home")) {
			boardDAO bDAO = new boardDAO();
			ArrayList<boardVO> list = bDAO.getList();
			
			request.setAttribute("list", list);
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
		}

		// 게시글 조회
		if (cmd.equals("view")) {
			// 세션확인
			int boardID = 0;
			if (request.getParameter("boardID") != null) {
				boardID = Integer.parseInt(request.getParameter("boardID"));
			}
			if (boardID == 0) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('<error> 유효하지 않은 글입니다.')");
				script.println("location.href='home.jsp'");
				script.println("</script>");
			}
			
			boardVO bVO = new boardDAO().getBoard(boardID);
			
			request.setAttribute("board", bVO);
			RequestDispatcher view = request.
					getRequestDispatcher("view.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String cmd = "";
		cmd = request.getParameter("key");
		// 로그인 시 처리
		if (cmd.equals("login")) {
			UserVO userVO = new UserVO();
			UserDAO userDAO = new UserDAO();
			String userEmail = null;
			String userPassword = null;
			String userName = null;
			LoginAction loginAction = new LoginAction();

			// 세션을 먼저 확인하자
			HttpSession session = request.getSession();
			if (session.getAttribute("userEmail") != null) {
				userEmail = (String) session.getAttribute("userEmail");
			}
			if (userEmail != null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 로그인이 되어있습니다.')");
				script.println("location.href='homeMenu.jsp'");
				script.println("</script>");
			} else {
				// 로그인 폼에서 받은 데이터 변수에 저장
				userEmail = request.getParameter("userEmail");
				userPassword = request.getParameter("userPassword");

				// db의 비밀번호와 유저가 폼으로 받은 비밀번호 비교
				int result = loginAction.comparePW(userEmail, userPassword);
				// db 오류
				if (result==-2) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('<Error> 데이터베이스 오류가 발생했습니다.')");
					script.println("history.back()");
					script.println("</script>");
				// 존재하지 않는 계정
				} else if (result==-1) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('<Error> 존재하지 않는 계정입니다.')");
					script.println("history.back()");
					script.println("</script>");
				// 로그인 성공
				} else if (result==1) {
					// 세션을 넣어주자
					session.setAttribute("userEmail", userEmail);
					userName = userDAO.findName(userEmail);
					session.setAttribute("userName", userName);
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href='homeMenu.jsp'");
					script.println("</script>");
				// 로그인 실패
				} else if (result==0){
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('<Error> 비밀번호가 틀립니다!')");
					script.println("history.back()");
					script.println("</script>");
				} else {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('<Error> 알 수 없는 오류.')");
					script.println("history.back()");
					script.println("</script>");
				}
			}
		}

		// 회원가입 시 처리
		if (cmd.equals("join")) {
			String userEmail=null;
			String userPassword=null;
			String userName=null;
			JoinAction joinAction = new JoinAction();
			
			// 세션을 먼저 확인하자
			HttpSession session = request.getSession();
			if (session.getAttribute("userEmail") != null) {
				userEmail = (String) session.getAttribute("userEmail");
			}
			if (userEmail != null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 로그인이 되어있습니다.')");
				script.println("location.href='homeMenu.jsp'");
				script.println("</script>");
			} else {
				userEmail = request.getParameter("userEmail");
				userPassword = request.getParameter("userPassword");
				userName = request.getParameter("userName");
				
				int result=joinAction.joinAction(userEmail,userPassword,userName);
				
				if(result == -1){
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('<Error> 이미 존재하는 이메일입니다.')");
					script.println("history.back()");
					script.println("</script>");
				}
				else {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('<회원가입완료> 로그인해주세요!')");
					script.println("location.href='join_form.html'");
					script.println("</script>");
				}
			}

		}
		
		// 게시글 작성
		if(cmd.equals("write")) {
			HttpSession session = request.getSession();
			String userEmail = null;
			WriteAction writeAction = new WriteAction();
			
			if(session.getAttribute("userEmail") != null){
				userEmail = (String)session.getAttribute("userEmail");
			}
			if(userEmail == null){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('로그인 하세요.')");
				script.println("location.href='join_form.html'");
				script.println("</script>");
			} else {
				
				String userName = (String)session.getAttribute("userName");
				String boardTitle = request.getParameter("boardTitle");
				String boardContent = request.getParameter("boardContent");
						
				int result = writeAction.write(boardTitle, userName, boardContent);
				
				if(result == -1) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('<Error> 글쓰기에 실패했습니다 T.T')");
					script.println("history.back()");
					script.println("</script>");
				} else if(result == 0) {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('<Error> 제목과 내용에 빈 칸 없이 작성하세요.')");
					script.println("history.back()");
					script.println("</script>");
				}
				else {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('해당 글이 작성되었습니다.')");
					script.println("location.href='http://localhost:8080/youngcheol_free/freeServlet?key=home'");
					script.println("</script>");
				}
			}
		}
		
	}

}
