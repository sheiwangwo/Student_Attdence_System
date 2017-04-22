package action;
import vo.code;
import com.opensymphony.xwork2.ActionContext;
import java.util.Date;  

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  
import vo.code;
import dao.CodeDAO;

public class Code {
private String stime;
private String etime;
private String vcode;
private String style;

public String getStyle() {
	return style;
}
public void setStyle(String style) {
	this.style = style;
}
public String getStime() {
	return stime;
}
public void setStime(String stime) {
	this.stime = stime;
}
public String getEtime() {
	return etime;
}
public void setEtime(String etime) {
	this.etime = etime;
}
public String getVcode() {
	return vcode;
}
public void setVcode(String vcode) {
	this.vcode = vcode;
}
public String execute() throws Exception {
	String tstime=stime.substring(stime.length()-5);
	String tetime=etime.substring(etime.length()-5);
	System.out.println(tstime);
	System.out.println(tetime);
	System.out.println(stime);
	System.out.println(etime);
	
	System.out.println(vcode);
	String k= (String)ActionContext.getContext().getSession()
			.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
	String admin=(String)ActionContext.getContext().getSession().get("Admin_name");
		    if(k.equals(vcode))
		    {    code code=new code();
		         Date date = new Date();
		         Date date1 = new Date();
		        
		         //注意format的格式要与日期String的格式相匹配
		         DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		         try {
		             date = sdf.parse(stime);
		             date1= sdf.parse(etime);
		             Timestamp tt=new Timestamp(date.getTime());
		             Timestamp tt1=new Timestamp(date1.getTime());
		         
		             System.out.println(tt);
		             System.out.println(tt1);
		             code.setTimestamp(tt);
		             code.setTimestamp1(tt1);
		            
		         } catch (Exception e) {
		             e.printStackTrace();
		         }
		    	 System.out.print("true");
		    	 System.out.print(admin);
		    	 code.setName(style);
		    	 code.setVcode(vcode);
		         code.setAname(admin);
		         code.setId(0);
		    	 CodeDAO CodeDAO=new CodeDAO();
		    	 int temp=CodeDAO.register(code);
		    	 if (temp==1)
		    		 return "success";
		    	 else
		    		 return "fail";
		    	 
		    }
		   
		    return "fail";
}
}
