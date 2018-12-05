package org.EstelleRay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.EstelleRay.bean.Post;
import org.EstelleRay.bean.User;
import org.EstelleRay.util.DBUnit;

import com.sun.org.apache.bcel.internal.generic.DDIV;

public class PostDao {
	public boolean create(Post post) {
		Connection connection = DBUnit.getConneciton();
		String sql = "INSERT INTO tb_posts(author,title,content) VALUES(?,?,?)";
		int result =0;
		
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,post.getAuthor());
			pStatement.setString(2, post.getTitle());
			pStatement.setString(3, post.getContent());
			result = pStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return result==1;
	}
	public List<Post> queryAll() {
		Connection connection = DBUnit.getConneciton();
		String sql = "SELECT * FROM tb_posts ORDER BY posttime DESC";
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		List<Post> posts =new ArrayList<>();
		try {
			pStatement = connection.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while(rs.next()) {
				Post post = new Post();
				post.setPostId(rs.getInt(1));
				post.setAuthor(rs.getString(2));
				post.setTitle(rs.getString(3));
				post.setContent(rs.getString(4));
				post.setPosttime(rs.getTimestamp(5));
				post.setPv(rs.getInt(6));
				posts.add(post);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUnit.closeJDBC(null, pStatement, connection);
		}
		
		return posts;
	}
	
	public List<Post> queryByAuthor(String author){
		Connection connection = DBUnit.getConneciton();
		String sql = "SELECT * FROM tb_posts WHERE author=? ORDER BY posttime DESC";
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		List<Post> posts = new ArrayList<Post>();
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, author);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				Post post = new Post();
				post.setPostId(rs.getInt(1));
				post.setAuthor(rs.getString(2));
				post.setTitle(rs.getString(3));
				post.setContent(rs.getString(4));
				post.setPosttime(rs.getTimestamp(5));
				post.setPv(rs.getInt(6));
				posts.add(post);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUnit.closeJDBC(null, pStatement, connection);
		}
		return posts;
	}
	
	public Post queryById(int id, boolean addpv) {
		Connection connection = DBUnit.getConneciton();
		String sql = "SELECT * FROM tb_posts WHERE Id=?";
		String sql2 = "UPDATE tb_posts SET pv=pv+1 WHERE Id=?";
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		int result = 0;
		Post post =null;
		try {
			connection.setAutoCommit(false);
			if(addpv) {
				pStatement = connection.prepareStatement(sql2);
				pStatement.setInt(1, id);
				result = pStatement.executeUpdate();
				if(result == 0) throw new Exception("update pv failed!");
				
				pStatement.close();
			}
			
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			
			if(rs.next()) {
				post = new Post();
				post.setPostId(rs.getInt(1));
				post.setAuthor(rs.getString(2));
				post.setTitle(rs.getString(3));
				post.setContent(rs.getString(4));
				post.setPosttime(rs.getTimestamp(5));
				post.setPv(rs.getInt(6));
			}
			
			connection.commit();
		}catch(Exception e) {
			try {
				connection.rollback();
			}catch(Exception e1) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUnit.closeJDBC(null, pStatement, connection);
		}
		return post;
	}
}
