package org.EstelleRay.servlet;

import java.io.Console;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.EstelleRay.bean.User;
import org.EstelleRay.dao.UserDao;

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

		response.setCharacterEncoding("utf-8");
		String stuId = request.getParameter("stuId");
		String password = request.getParameter("password");

		boolean result = false;
		
		UserDao userDao = new UserDao();
		User user = userDao.query(stuId);

		if(user!=null && user.getPassword().equals(password)) {
			result = true;
		}
		
		//请求转发
		RequestDispatcher rDispatcher = request.getRequestDispatcher("result.jsp");
		request.setAttribute("resMessage", result==true?"登陆成功":"登陆失败");
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
