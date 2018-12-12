package org.EstelleRay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.EstelleRay.bean.Comment;
import org.EstelleRay.bean.User;
import org.EstelleRay.dao.CommentDao;

/**
 * Servlet implementation class NewCommentServlet
 */
@WebServlet("/NewCommentServlet")
public class NewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String postid = request.getParameter("postid");
		String content = request.getParameter("comment");
		String author = ((User)request.getSession().getAttribute("User")).getStuId();
		CommentDao commentDao = new CommentDao();
		Comment comment = new Comment(0, author, content,Integer.parseInt(postid),(new Date()));
		boolean result = commentDao.create(comment);

		if(result) {
			out.print("<script type='text/javascript'>");
			out.print("alert('comment successfully');");
			out.print("window.location='post.jsp?postid="+postid+"';");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('comment failed');");
			out.print("window.location='javascript:history.go(-1);';");
			out.print("</script>");
		}
		
	}

}
