package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.admin;
import com.mysql.jdbc.ResultSet;

import dbc.DatabaseConnection;
import vo.admin;
import vo.check_record;
import vo.user;

public class AdminDAO {
	// 登陆验证
	public boolean login(admin user) {
		int num = 0;
		PreparedStatement ps = null;
		Connection conn = null;
		boolean flag = false;
		try {
			String sql = "select name from admin"
					+ " where name=? and password=?";
			conn = DatabaseConnection.getConnection();// 获取连接();
			ps = conn.prepareStatement(sql);// 实例化操作
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ResultSet rSet = (ResultSet) ps.executeQuery();// 取得结果
			if (rSet.next()) {
				user.setName(rSet.getString(1));// 取得用户名
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(); // 关闭操作

		}

		return flag;
	}

	// 查询签到详情
	public List<check_record> getcheck(String name) {
		List<check_record> check_record = new ArrayList<check_record>();// 用于存储用户列表
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DatabaseConnection.getConnection();// 获取连接
			String sql = "select *from check_record" + " where a_name=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = (ResultSet) ps.executeQuery();// 获取结果集
			System.out.println("1111");
			while (rs.next()) {
				System.out.println("1111");
				Date a = rs.getDate("time");
				Date a1 = rs.getTime("time");

				check_record check_record1 = new check_record();
				check_record1.setA_name(rs.getString("a_name"));
				check_record1.setU_name(rs.getString("u_name"));
				check_record1.setCode(rs.getString("code"));
				check_record1.setDate(new java.sql.Date(a.getTime()));
				check_record1.setDate1(new java.sql.Time(a1.getTime()));
				check_record1.setState(rs.getString("state"));
				check_record1.setName(rs.getString("name"));
				check_record.add(check_record1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(); // 关闭操作

		}

		return check_record;
	}

	// 查询签到课程
	public List<String> getCourse(String aname) {
		List<String> courses = new ArrayList<String>();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DatabaseConnection.getConnection();// 获取连接
			// SELECT distinct name FROM code WHERE aname LIKE '方芳'
			String sql = "SELECT distinct name FROM code WHERE aname LIKE ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, aname);
			rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				courses.add(rs.getString("name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(); // 关闭操作

		}

		return courses;
	}

	// 查询签到课程时间
	public List<String> getCheckTime(String cname, String aname) {
		List<String> checktime = new ArrayList<String>();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DatabaseConnection.getConnection();
			// SELECT stime name FROM code WHERE name LIKE '数据结构' AND aname LIKE
			// '方芳'
			String sql = "SELECT stime FROM code WHERE name LIKE ? AND aname LIKE ?  ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, aname);
			rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				checktime.add(rs.getString("stime"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(); // 关闭操作

		}

		return checktime;
	}

}
