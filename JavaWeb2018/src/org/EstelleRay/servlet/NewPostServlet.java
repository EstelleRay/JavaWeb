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
 * Servlet implementation class NewPostServlet
 */
@WebServlet("/NewPostServlet")
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		PrintWriter out = response.getWriter();
		String author = ((User)request.getSession().getAttribute("User")).getStuId();
		String title = request.getParameter("postTitle");
		String content = request.getParameter("postContent");
		
		PostDao postDao = new PostDao();
		Post post = new Post();
		post.setAuthor(author);
		post.setTitle(title);
		post.setContent(content);
		post.setPv(0);
				
		boolean result = postDao.create(post);
		
		if(result) {
			out.print("<script>alert('post successfully.');window.location='index.jsp';</script>");
		}else {
			out.print("<script>alert('post failed.');window.location='javascript:history.go(-1);'</script>");
		}
		

	}

}
