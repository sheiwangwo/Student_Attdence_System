package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.user_count;

import com.mysql.jdbc.ResultSet;

import dbc.DatabaseConnection;

public class CountDAO {

	public static List<user_count> getCourseCounts(String cname, String aname) {
		List<user_count> user_counts = new ArrayList<user_count>();

		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DatabaseConnection.getConnection();// 获取连接

			String sql = "SELECT uname FROM student_course WHERE cname LIKE ? AND aname LIKE ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, aname);
			rs = (ResultSet) ps.executeQuery();// 获取结果集

			while (rs.next()) {

				user_count uct = new user_count();
				uct.setName(rs.getString("uname"));

				sql = "SELECT COUNT(*) FROM check_record WHERE u_name LIKE ? AND  name LIKE ? AND a_name LIKE ? AND state LIKE '是'";
				ps = conn.prepareStatement(sql);
				ps.setString(1, uct.getName());
				ps.setString(2, cname);
				ps.setString(3, aname);

				ResultSet rs1 = (ResultSet) ps.executeQuery();// 获取结果集

				while (rs1.next()) {
					System.out.println(rs1.getInt(1));
					uct.setCounts(rs1.getInt(1));

				}

				user_counts.add(uct);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(); // 关闭操作

		}

		return user_counts;
	}

	public static int getCourseTotalCounts(String cname, String aname) {

		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		int total = 0;

		try {
			conn = DatabaseConnection.getConnection();// 获取连接
			// SELECT * FROM code WHERE name LIKE '数据结构' AND aname LIKE '方芳'
			String sql = "SELECT COUNT(*) FROM code WHERE name LIKE ? AND aname LIKE ? ";

			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, aname);
			rs = (ResultSet) ps.executeQuery();// 获取结果集

			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(); // 关闭操作

		}

		return total;
	}

	public static List<user_count> getCourseCheck(String cname, String aname,
			String stime) {
		List<user_count> user_counts = new ArrayList<user_count>();

		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DatabaseConnection.getConnection();// 获取连接

			String sql = "SELECT uname FROM student_course WHERE cname LIKE ? AND aname LIKE ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, aname);
			rs = (ResultSet) ps.executeQuery();// 获取结果集

			while (rs.next()) {

				user_count uct = new user_count();
				uct.setName(rs.getString("uname"));
				//SELECT COUNT(*) FROM check_record WHERE u_name LIKE '加小俊' AND  name LIKE '数据结构' AND a_name LIKE '方芳' AND time = '2017-02-27 23:43:01' AND state LIKE '是'

				sql = "SELECT COUNT(*) FROM check_record WHERE u_name LIKE ? AND  name LIKE ? AND a_name LIKE ? AND time = ? AND state LIKE '是'";
				ps = conn.prepareStatement(sql);
				ps.setString(1, uct.getName());
				ps.setString(2, cname);
				ps.setString(3, aname);
				ps.setString(4, stime);

				ResultSet rs1 = (ResultSet) ps.executeQuery();// 获取结果集

				while (rs1.next()) {
					System.out.println(rs1.getInt(1));
					uct.setCounts(rs1.getInt(1));
				}

				user_counts.add(uct);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(); // 关闭操作

		}

		return user_counts;
	}
}
