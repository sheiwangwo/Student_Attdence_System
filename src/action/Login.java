package action;
import java.sql.Connection;
import vo.user;
import dao.UserDAO;
import dbc.DatabaseConnection;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import vo.check_record;
public class Login {
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
		UserDAO UserDAO=new UserDAO();
		user user=new user();
		user.setName(username);
		user.setPassword(password);
		boolean flag=UserDAO.login(user);
		
		if(flag==true){
			List<check_record> check_record=UserDAO.getcheck(username);
			String path1=UserDAO.getpath(user);
			ActionContext.getContext().getSession().put("check_record", check_record);
			ActionContext.getContext().getSession().put("u_name",username);
			ActionContext.getContext().getSession().put("path",path1);
			return "success";
			}
		else
			return "fail";
		
		
		
		
	}
	
}
