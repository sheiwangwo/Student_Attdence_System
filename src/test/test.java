package test;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import vo.user;
import dao.UserDAO;
import dbc.DatabaseConnection;
import dao.CodeDAO;
import dao.FaceDAO;
import dao.AdminDAO;
import dao.ImageDAO;
import vo.admin;
import dao.Recognize;
public class test {
	 public static void main(String[] args)
	 {
		/*Connection conn=null;
		 conn=DatabaseConnection.getConnection();//获取连接
		 UserDAO UserDAO=new UserDAO();
		 CodeDAO CodeDAO=new CodeDAO();
		 String stime,etime;
		 stime=null;
		 etime=null;
		stime= CodeDAO.search_stime("方芳", "434nb");
		etime= CodeDAO.search_etime("方芳", "434nb");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time=df.format(new Date());// new Date()为获取当前系统时间
		System.out.println(time);
		try {
			Date a=df.parse(stime);
			Date a1=df.parse(etime);
			Date a2=df.parse(time);
			System.out.println(a2.getTime());
			System.out.println(a1.getTime());
			if(a2.getTime()-a1.getTime()>0)
			{System.out.println("****");}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(stime);
		 System.out.println(etime);
		/* user user=new user();
		 user.setName("加小俊");
		 user.setPassword("1");
		boolean a=UserDAO.login(user);
		 System.out.println(a);
		 AdminDAO AdminDAO=new AdminDAO();
		 admin admin=new admin();
		 admin.setName("方芳");
		 admin.setPassword("1");
		 a=AdminDAO.login(admin);
		 System.out.println(a);
		 FaceDAO  FaceDAO=new FaceDAO();
		int a= FaceDAO.Face( "D:\\face\\1.jpg");
		System.out.println(a);*/
		 /*String path = "E:\\data\\1.jpg";
	     String path1 = "E:\\data\\2.jpg";
	     
	     Recognize Recognize=new Recognize();
	    double a= Recognize.Face_Recognize(path, path1);
	     System.out.println(a);
	    */
		 ImageDAO  ImageDAO=new  ImageDAO();
	    ImageDAO.change("D:/data/test/","12.jpg");
	     ImageDAO.spin("D:/data/test/12.jpg");
	     ImageDAO.change("D:/data/test/","12.jpg");
	 }
}
