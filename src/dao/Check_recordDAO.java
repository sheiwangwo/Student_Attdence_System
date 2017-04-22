package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import dbc.DatabaseConnection;
import vo.check_record;

public class Check_recordDAO {
//插入	
	public int insert(check_record check_record)
	{
		int num=0;
		PreparedStatement ps=null;
		 Connection conn=null;
		
		try{
			
			 conn=DatabaseConnection.getConnection();//获取连接();
			 String sql="INSERT into check_record values(?,?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1,check_record.getU_name());
				ps.setString(2,check_record.getA_name());
				ps.setDate(3,check_record.getDate());
				ps.setTime(3,check_record.getDate1());
				ps.setString(4,check_record.getState());
				ps.setString(5,check_record.getCode());
				ps.setString(6, check_record.getName());
				num=ps.executeUpdate();//执行插入操作
		}
		catch (Exception e) {
            e.printStackTrace();
        }finally
		{
			DatabaseConnection.close();
		}
		return num;
		
	}
	
//修改学生状态
		public int updata(String state ,String aname,String uname,String code)
		{
			int num=0;
			Connection conn=null;
			PreparedStatement ps=null;
			try
			{
				conn=DatabaseConnection.getConnection();//获取连接
				String sql="update check_record set state=?"+" where u_name=? and a_name=?  and code=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, state);
				ps.setString(2,uname);
				ps.setString(3, aname);
				ps.setString(4, code);
				num=ps.executeUpdate();//执行修改操作
				System.out.println(num);
			}
			catch (Exception e) {
	            e.printStackTrace();
	        }finally
			{
				DatabaseConnection.close();
			}
			
			return num;
		}	
	
}
