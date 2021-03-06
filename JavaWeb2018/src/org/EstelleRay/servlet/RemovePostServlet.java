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

/**
 * Servlet implementation class RemovePostServlet
 */
@WebServlet("/RemovePostServlet")
public class RemovePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UFT-8");
		response.setContentType("text/html;charset=utf");
		PrintWriter out = response.getWriter();
		
		String postid = request.getParameter("postid");
		if(postid == null || "".equals(postid)) {
			out.print("<script type='text/javascript'>");
			out.print("alert('miss postid parameter.');");
			out.print("window.location='index.jsp';");
			out.print("</script>");
			return;
		}
		
		String author = ((User)request.getSession().getAttribute("User")).getStuId();
		PostDao postDao = new PostDao();
		Post post=postDao.queryById(Integer.parseInt(postid), false);
		if(!author.equals(post.getAuthor())) {
			out.print("<script type='text/javascript'>");
			out.print("alert('permission denied.');");
			out.print("window.location='index.jsp';");
			out.print("</script>");
			return;
		}
		boolean result = postDao.delete(post.getPostId());
		
		if(result) {
			out.print("<script type='text/javascript'>");
			out.print("alert('remove post successfully');");
			out.print("window.location='index.jsp';");
			out.print("</script>");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('remove post failed');");
			out.print("window.location='javascript:history.go(-1);';");
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
