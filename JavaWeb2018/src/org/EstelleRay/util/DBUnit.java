package org.EstelleRay.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUnit {
	//���ݿ��û���������
	static String user = "root";
	static String password ="";
	static String url = "jdbc:mysql://localhost:3306/javaweb?characterEncoding=UTF-8&useSSL=true";
	
	//�����Ƿ����jdbc
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���ݿ��������سɹ�����");
		}catch(ClassNotFoundException e){
			e.getException();
		}
	}
	
	//��������
	public static Connection getConneciton() {
		Connection connection = null;
		
		try {
//			System.out.println();
//			System.out.println(user);
//			System.out.println(url);
//			System.out.println(password);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("�ɹ��ػ�ȡ���ݿ����ӣ���");
		}catch(SQLException e) {
			System.out.println("�������ݿ�����ʧ�ܣ�");
			e.getStackTrace();
		}
		return connection;
	}
	
	
	public static void closeJDBC(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
