package org.EstelleRay.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.EstelleRay.bean.User;
import org.EstelleRay.dao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
@MultipartConfig
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
		response.sendRedirect("register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
		
		String stuId = request.getParameter("stuId");
		String stuName = request.getParameter("stuName");
		String password = request.getParameter("password");
//		String avatar = request.getParameter("avatar");
		String gender = request.getParameter("gender");
		String bio = request.getParameter("bio");
		String gitUrl = request.getParameter("gitUrl");
		
		//获取上传文件
		Part part = request.getPart("avatar");
		//向服务器请求实际目录
		String filePath = getServletContext().getRealPath("/img/upload");
		String fileName = part.getSubmittedFileName();
		String newFileName = UUID.randomUUID().toString() + "_" + fileName;
		File f = new File(filePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		part.write(filePath+"/"+part.getSubmittedFileName());
		String avatar = newFileName;
		
		
		
		UserDao userDao = new UserDao();
		User user = new User(stuId,stuName,password,avatar,gender,bio,gitUrl);
		boolean result = userDao.create(user);
		
		//请求转发
		RequestDispatcher rDispatcher = request.getRequestDispatcher("result.jsp");
		request.setAttribute("resMessage", result==true?"注册成功":"注册失败");
		rDispatcher.forward(request, response);
	}

}
