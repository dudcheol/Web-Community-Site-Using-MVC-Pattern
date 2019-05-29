package youngcheol_addr;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddrServlet
 */
@WebServlet("/AddrServlet")
public class AddrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd="";
		cmd=request.getParameter("key");
		
		if(cmd.equals("join")) {
			response.sendRedirect("join_form.html");
		}
		else if(cmd.equals("list")) {
			AddrDAO addrDAO = new AddrDAO();
			List<AddrVO> addrvoList = addrDAO.getAddrList();
			request.setAttribute("addressList", addrvoList);
			RequestDispatcher view = request.getRequestDispatcher("addr_list.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd="";
		cmd=request.getParameter("key");
		
		if(cmd.equals("join")) {
			AddrVO addrVO = new AddrVO();
			AddrDAO addrDAO = new AddrDAO();

			addrVO.setUsername(request.getParameter("username"));
			addrVO.setTel(request.getParameter("tel"));
			addrVO.setEmail(request.getParameter("email"));
			addrVO.setSex(request.getParameter("sex"));
			
			String temp="JOIN NOT OK";
			if(addrDAO.add(addrVO)) temp="JOIN OK";
			
			request.setAttribute("result", temp);
			request.setAttribute("address", addrVO);
			
			RequestDispatcher view  = request.getRequestDispatcher("join_result.jsp");
			view.forward(request, response);
		}
	}

}
