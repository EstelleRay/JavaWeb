package org.EstelleRay.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.EstelleRay.bean.User;
import org.EstelleRay.dao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String stuId = request.getParameter("stuId");
		String stuName = request.getParameter("stuName");
		String password = request.getParameter("password");
		String avatar = request.getParameter("avatar");
		String gender = request.getParameter("gender");
		String bio = request.getParameter("bio");
		String gitUrl = request.getParameter("gitUrl");
		
		UserDao userDao = new UserDao();
		User user = new User(stuId,stuName,password,avatar,gender,bio,gitUrl);
		boolean result = userDao.create(user);
		
		
		RequestDispatcher rDispatcher = request.getRequestDispatcher("result.jsp");
		request.setAttribute("resMessage", result==true?"×¢²á³É¹¦":"×¢²áÊ§°Ü");
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
