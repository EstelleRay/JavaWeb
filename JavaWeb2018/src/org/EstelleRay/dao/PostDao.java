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

public class PostDao {
	public boolean create(Post post) {
		Connection connection = DBUnit.getConneciton();
		String sql = "INSERT INTO tb_posts(author,title,content,pv) VALUES(?,?,?,?)";
		int result =0;
		
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,post.getAuthor());
			pStatement.setString(2, post.getTitle());
			pStatement.setString(3, post.getContent());
			pStatement.setInt(4, post.getPv());
			result = pStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return result==1;
	}
	public List<Post> queryAll() {
		Connection connection = DBUnit.getConneciton();
		String sql = "SELECT * FROM tb_posts";
		ResultSet rs = null;
		List<Post> posts =new ArrayList<>();
		try {
			PreparedStatement pStatment = connection.prepareStatement(sql);
			rs = pStatment.executeQuery();
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
		}
		
		return posts;
	}
}
