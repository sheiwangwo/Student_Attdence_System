package action;
import java.sql.Connection;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import vo.admin;
import vo.check_record;
import vo.user;
import dao.AdminDAO;
import dao.UserDAO;
import dbc.DatabaseConnection;
public class Alogin {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception
	{
		Connection conn=null;
		conn=DatabaseConnection.getConnection();//获取连接
		AdminDAO AdminDAO=new AdminDAO();
		admin admin=new admin();
		admin.setName(username);
		admin.setPassword(password);
		System.out.println(username);
		System.out.println(password);
		boolean flag=AdminDAO.login(admin);
		if(flag==true){
			List<check_record> check_record=AdminDAO.getcheck(username);
			ActionContext.getContext().getSession().put("check_record", check_record);
			ActionContext.getContext().getSession().put("Admin_name",username);
			String a=(String)ActionContext.getContext().getSession().get("Admin_name");
			System.out.println(a);
			return "success";}
		else
			return "fail";
	}
}
