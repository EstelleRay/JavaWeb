package org.EstelleRay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.EstelleRay.bean.User;

import org.EstelleRay.util.DBUnit;


public class UserDao {
	
	public boolean create(User user) {
		Connection connection = DBUnit.getConneciton();
		String sql = "INSERT INTO tb_user VALUES(?,?,?,?,?,?,?)";
		int result =0;
		
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,user.getStuId());
			pStatement.setString(2, user.getStuName());
			pStatement.setString(3, user.getPassword());
			pStatement.setString(4, user.getAvatar());
			pStatement.setString(5, user.getGender());
			pStatement.setString(6, user.getBio());
			pStatement.setString(7, user.getGitUrl());
			result = pStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return result==1;
	}
	
	public User query(String stuId) {
		Connection connection = DBUnit.getConneciton();
		String sql = "SELECT * FROM tb_user WHERE stuId=? ";
		ResultSet rs = null;
		User user = null;
		try {
			PreparedStatement pStatment = connection.prepareStatement(sql);
			pStatment.setString(1, stuId);
			rs = pStatment.executeQuery();
			//System.out.print(stuId);
			if(rs.next()) {
				user = new User();
				user.setStuId(rs.getString(1));
				user.setStuName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAvatar(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setBio(rs.getString(6));
				user.setGitUrl(rs.getString(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public boolean update(User user) {
		String sql = "UPDATE tb_user SET stuName=?, password=?, avatar=?, gender=?, bio=?, gitUrl=? WHERE stuId=?";
		Connection connection = DBUnit.getConneciton();
		PreparedStatement pStatement = null;
		int result = 0;
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user.getStuName());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.getAvatar());
			pStatement.setString(4, user.getGender());
			pStatement.setString(5, user.getBio());
			pStatement.setString(6, user.getGitUrl());
			pStatement.setString(7, user.getStuId());
			result = pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUnit.closeJDBC(null, pStatement, connection);
		}
		return (result==1);
	}
}
