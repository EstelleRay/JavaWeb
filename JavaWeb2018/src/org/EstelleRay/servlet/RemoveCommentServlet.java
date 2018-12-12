package org.EstelleRay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.EstelleRay.bean.Comment;
import org.EstelleRay.bean.User;
import org.EstelleRay.dao.CommentDao;

/**
 * Servlet implementation class RemoveCommentServlet
 */
@WebServlet("/RemoveCommentServlet")
public class RemoveCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String commentid = request.getParameter("commentid");
		if(commentid == null || "".equals(commentid)) {
			out.print("<script type='text/javascript'>");
			out.print("alert('miss commentid parameter')");
			out.print("window.location='posts.jsp';");
			out.print("</script>");
			return;
		}
		
		String author = ((User)request.getSession().getAttribute("User")).getStuId();
		CommentDao commentDao = new CommentDao();
		Comment comment = commentDao.queryById(Integer.parseInt(commentid));
		if(!author.equals(comment.getAuthor())) {
			out.print("<script type='text/javascript'>");
			out.print("alert('permission denied.');");
			out.print("window.location='posts.jsp';");
			out.print("</script>");
			return;
		}
		boolean result = commentDao.delete(comment.getCommentId());
		
		if(result) {
			out.print("<script type='text/javascript'>");
			out.print("alert('remove comment successfully');");
			out.print("window.location='post.jsp?postid=" + comment.getPostId() + "';");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('remove comment successfully');");
			out.print("window.location='post.jsp?postid=" + comment.getPostId() + "';");
			out.print("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
