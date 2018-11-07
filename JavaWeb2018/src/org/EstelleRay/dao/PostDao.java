package org.EstelleRay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
