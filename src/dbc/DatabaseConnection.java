package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection conn = null;

	// 连接字符串
	static String url = "jdbc:mysql://localhost:3306/student?user=root&password=&useUnicode=true&characterEncoding=gbk";

	public static Connection getConnection() {
		// 驱动程序名
		String driverName = "com.mysql.jdbc.Driver";
		// 加载驱动
		try {
			Class.forName(driverName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 建立连接
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("连接成功");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close() {
		try {

			if (conn != null && (!conn.isClosed())) {
				conn.close();// 关闭Connection对象
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
