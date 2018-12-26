package org.EstelleRay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.EstelleRay.bean.Post;
import org.EstelleRay.bean.User;
import org.EstelleRay.dao.PostDao;
import org.EstelleRay.dao.UserDao;


/**
 * Servlet implementation class EditPostServlet
 */
@WebServlet("/EditPostServlet")
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("postContent");
		String postid = request.getParameter("postid");
		String author = ((User)request.getSession().getAttribute("User")).getStuId();
		PostDao postDao = new PostDao();
		Post post = postDao.queryById(Integer.parseInt(postid), false);	
		if (!author.equals(post.getAuthor())) {
			out.print("<script type='text/javascript'>");
			out.print("alert('permission denied.');");
			out.print("history.go(-1);");
			out.print("</script>");
			return;
		}
		post.setTitle(title);
		post.setContent(content);
		boolean result = postDao.update(post);
		
		if (result) {
			out.print("<script type='text/javascript'>");
			out.print("alert('edit post successfully');");
			out.print("window.location='post.jsp?postid="+postid+"';");
			out.print("</script>");
		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('edit post failed');");
			out.print("window.location='javascript:history.go(-1);';");
			out.print("</script>");
		}
	}

}
