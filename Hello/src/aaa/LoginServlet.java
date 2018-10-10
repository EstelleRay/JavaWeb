package aaa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setCharacterEncoding("utf-8");
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//		
//		response.getWriter().println("<!DOCTYPE html>\r\n" + 
//				"<html>\r\n" + 
//				"<head>\r\n" + 
//				"<meta charset=\"UTF-8\">\r\n<body>\r\n");
//		if(username.equals("333") && password.equals("333")) {
//			response.getWriter().println("µÇÂ¼³É¹¦£¡");
//		} else {
//			response.getWriter().println("µÇÂ¼Ê§°Ü£¡");
//		}
//			response.getWriter().println("</body>\r\n"+"</html>");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Connection connection = DBUnit.getConneciton();
		String sql = "SELECT COUNT(*) FROM users WHERE username=? AND password=?";
		ResultSet resultSet = null;
		int result = 0;
		try {
			PreparedStatement pStatment = connection.prepareStatement(sql);
			pStatment.setString(1, username);
			pStatment.setString(2, password);
			resultSet = pStatment.executeQuery();
			if(resultSet.next()) {
				result = resultSet.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rDispatcher = request.getRequestDispatcher("result.jsp");
		request.setAttribute("resMessage", result==1?"µÇÂ½³É¹¦":"µÇÂ½Ê§°Ü");
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
