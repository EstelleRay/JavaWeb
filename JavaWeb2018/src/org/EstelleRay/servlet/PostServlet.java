package org.EstelleRay.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.EstelleRay.bean.Comment;
import org.EstelleRay.bean.Post;
import org.EstelleRay.bean.User;
import org.EstelleRay.dao.CommentDao;
import org.EstelleRay.dao.PostDao;
import org.EstelleRay.dao.UserDao;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String author = request.getParameter("author");
		String postid = request.getParameter("postid");
		PostDao postDao = new PostDao();
		
		if(action.equals("listposts")){
			int postCount = 0;
			List<Post> posts = null;
			if(null != author && !"".equals(author)){
				posts = postDao.queryByAuthor(author);
			}else {
				posts = postDao.queryAll();
			}
			Map<String,User> postAuthors = getPostAuthors(posts);
			Map<Integer, Integer> postCommentCount = getPostCommentCount(posts);
			request.setAttribute("posts", posts);
			request.setAttribute("postAuthors", postAuthors);
			request.setAttribute("postCommentCount", postCommentCount);
			request.getRequestDispatcher("components/posts-content.jsp").include(request, response);
		}else if(action.equals("listpost")) {
			if(null != postid && !".".equals(postid)) {
				Post post = postDao.queryById(Integer.parseInt(postid),false);
				UserDao userDao = new UserDao();
				User postAuthor = userDao.query(post.getAuthor());
				request.setAttribute("post", post);
				request.setAttribute("postAuthors", postAuthor);
			}
		}else if (action.equals("editpost")) {
			if(null != postid && !"".equals(postid)) {
				Post post = postDao.queryById(Integer.parseInt(postid),false);
				request.setAttribute("post", post);
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
	
	private Map<String, User> getPostAuthors(List<Post> posts){
		Map<String, User> map =new HashMap<String, User>();
		UserDao userDao =new UserDao();
		for(Post post : posts) {
			User user = userDao.query(post.getAuthor());
			if(user != null) {
				user.setPassword("");
				map.put(user.getStuId(), user);
			}
		}
		
		return map;
	}
	
	private Map<Integer, Integer> getPostCommentCount(List<Post> posts){
		Map<Integer, Integer> map =new HashMap<Integer, Integer>();
		CommentDao commentDao =new CommentDao();
		for(Post post : posts) {
			List<Comment> list = commentDao.queryByPostId(post.getPostId());
			map.put(post.getPostId(), list.size());
		}
		
		return map;
	}

}
