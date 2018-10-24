package org.EstelleRay.servlet;

import java.io.Console;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.EstelleRay.bean.User;
import org.EstelleRay.dao.UserDao;

import com.sun.org.apache.xml.internal.security.utils.Base64;

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
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String stuId = request.getParameter("stuId");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		boolean result = false;
		
		UserDao userDao = new UserDao();
		User user = userDao.query(stuId);

		if(user!=null && user.getPassword().equals(password)) {
			result = true;
			if(rememberMe != null && "on".equals(rememberMe)) {
				Cookie cookieStuId = new Cookie("stuId",Base64.encode(stuId.getBytes()));
				Cookie cookiePassword = new Cookie("password",Base64.encode(password.getBytes()));
				cookieStuId.setMaxAge(3600*24*365);
				cookiePassword.setMaxAge(3600*24*365);
				response.addCookie(cookieStuId);
				response.addCookie(cookiePassword);
			}else {
				Cookie[] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("stuId")||cookie.getName().equals("password")) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		
		//请求转发
		RequestDispatcher rDispatcher = request.getRequestDispatcher("result.jsp");
		request.setAttribute("resMessage", result==true?"登陆成功":"登陆失败");
		rDispatcher.forward(request, response);
	}

}
