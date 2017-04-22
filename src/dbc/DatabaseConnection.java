package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection conn = null;

	// �����ַ���
	static String url = "jdbc:mysql://localhost:3306/student?user=root&password=&useUnicode=true&characterEncoding=gbk";

	public static Connection getConnection() {
		// ����������
		String driverName = "com.mysql.jdbc.Driver";
		// ��������
		try {
			Class.forName(driverName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ��������
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("���ӳɹ�");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close() {
		try {

			if (conn != null && (!conn.isClosed())) {
				conn.close();// �ر�Connection����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
