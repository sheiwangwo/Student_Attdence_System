package action;
import dao.Check_recordDAO;

public class Updata {
	private String state;
	private String aname;
	private String uname;
	private String date;
	private String code;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String execute() throws Exception {
		Check_recordDAO  Check_recordDAO=new Check_recordDAO();
		int flag=Check_recordDAO.updata(state, aname, uname, code);
		if(flag!=0)
		return "success";
		else
		return "fail";
	}
	
	
	

}
