package aaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUnit {
	//数据库用户连接内容
	static String user = "root";
	static String password ="";
	static String url = "jdbc:mysql://localhost:3306/javaweb?characterEncoding=UTF-8&useSSL=true";
	
	//查找是否存在jdbc
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载成功！！");
		}catch(ClassNotFoundException e){
			e.getException();
		}
	}
	
	//建立连接
	public static Connection getConneciton() {
		Connection connection = null;
		
		try {
//			System.out.println();
//			System.out.println(user);
//			System.out.println(url);
//			System.out.println(password);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("成功地获取数据库连接！！");
		}catch(SQLException e) {
			System.out.println("创建数据库连接失败！");
			e.getStackTrace();
		}
		return connection;
	}
	
}
