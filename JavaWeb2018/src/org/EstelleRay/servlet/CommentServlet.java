package org.EstelleRay.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.EstelleRay.bean.Comment;
import org.EstelleRay.bean.User;
import org.EstelleRay.dao.CommentDao;
import org.EstelleRay.dao.UserDao;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String postid = request.getParameter("postid");
		CommentDao commentDao = new CommentDao();
		
		if(action.equals("listcomments")) {
			if(null!=postid && !"".equals(postid)) {
				List<Comment> comments = commentDao.queryByPostId(Integer.parseInt(postid));
				Map<String, User> commentAuthors = getCommentAuthors(comments);
				request.setAttribute("comments", comments);
				request.setAttribute("commentAuthors", commentAuthors);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Map<String ,User> getCommentAuthors(List<Comment> comments){
		Map<String , User> map = new HashMap<String, User>();
		UserDao userDao = new UserDao();
		for(Comment comment : comments) {
			User user = userDao.query(comment.getAuthor());
			if(user != null) {
				user.setPassword("");
				map.put(user.getStuId(), user);
			}
		}
		return map;
	}

}
