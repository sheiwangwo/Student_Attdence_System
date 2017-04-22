package action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import vo.code;

import com.opensymphony.xwork2.ActionContext;

import dao.CodeDAO;

public class ViewAttdence {
	private String aname;
	private String course;
	private String time;
	
	
	public String getAname() {
		return aname;
	}


	public void setAname(String aname) {
		this.aname = aname;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String execute() throws Exception {
		
		if(/*aname != "" &&*/ course != null && time != null){
			ActionContext.getContext().getSession().put("course", course);
			ActionContext.getContext().getSession().put("time", time);
			return "singleforms";
		}
			
		else if(/*aname != "" &&*/ course != ""){
			ActionContext.getContext().getSession().put("course", course);
			return "sumforms";
		}
		else
			return "fail";
		
	}
}
