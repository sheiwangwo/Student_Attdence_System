package dao;
import vo.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.ResultSet;
import dbc.DatabaseConnection;
import vo.check_record;

public class UserDAO {
//ע��
	public int register(user user)
	{
		int num=0;
		PreparedStatement ps=null;
		 Connection conn=null;
		
		try{
			
			 conn=DatabaseConnection.getConnection();//��ȡ����();
			 String sql="INSERT into user values(?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, user.getId());
				ps.setString(2,user.getName());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getImage());
				num=ps.executeUpdate();//ִ�в������
		}
		catch (Exception e) {
            e.printStackTrace();
        }finally
		{
			DatabaseConnection.close();
		}
		return num;
		
	}
//��½��֤
	public boolean login(user user)
	{
		int num=0;
		PreparedStatement ps=null;
		 Connection conn=null;
		boolean flag =false;
		 try {  
	            String sql="select name from user"+" where name=? and password=?";
	            conn=DatabaseConnection.getConnection();//��ȡ����();
	            ps=conn.prepareStatement(sql);//ʵ��������  
	            ps.setString(1,user.getName());  
	            ps.setString(2, user.getPassword());
	            ResultSet rSet=(ResultSet) ps.executeQuery();//ȡ�ý��   
	            if(rSet.next()){  
	                user.setName(rSet.getString(1));//ȡ���û���  
	                flag=true;        
	            }  
	  
	        } catch (Exception e) {  
	        	  e.printStackTrace();
	        }finally{  
	        	DatabaseConnection.close(); //�رղ���  
	           
	        }  
	              
	        
		 return flag;
	}
//��ѯ
	public static  List<check_record> getcheck(String name)
	{
		List<check_record> check_record=new ArrayList<check_record>();//���ڴ洢�û��б�
		PreparedStatement ps=null;
		Connection conn=null;
		ResultSet rs=null;
		try{
			conn=DatabaseConnection.getConnection();//��ȡ����
			String sql="select *from check_record"+" where u_name=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			rs=(ResultSet) ps.executeQuery();//��ȡ�����
			System.out.println("1111");
			while(rs.next())
			{System.out.println("1111");
			    Date a=rs.getDate("time");
			    Date a1=rs.getTime("time");
			    
				check_record check_record1=new check_record();
				check_record1.setA_name(rs.getString("a_name"));
				check_record1.setU_name(rs.getString("u_name"));
				check_record1.setCode(rs.getString("code"));
				check_record1.setDate(new java.sql.Date(a.getTime()));
				check_record1.setDate1(new java.sql.Time(a1.getTime()));
				check_record1.setState(rs.getString("state"));
				check_record1.setName(rs.getString("name"));
				check_record.add(check_record1);
				
			}
		}
		catch (Exception e) {  
      	  e.printStackTrace();
      }finally{  
      	DatabaseConnection.close(); //�رղ���  
         
      }  
		
		
		return check_record;
	}

//��ѯͼ��λ��
	public String getpath(user user)
	{
		String path=null;
		PreparedStatement ps=null;
		Connection conn=null;
		try{
			conn=DatabaseConnection.getConnection();//��ȡ����
			String  sql="select image from user"+" where name=? and password=?";
			
			conn=DatabaseConnection.getConnection();//��ȡ����();
            ps=conn.prepareStatement(sql);//ʵ��������  
            ps.setString(1,user.getName());  
            ps.setString(2, user.getPassword());
            ResultSet rSet=(ResultSet) ps.executeQuery();//ȡ�ý��   
            if(rSet.next()){  
              path=rSet.getString(1);//ȡ���û���  
              System.out.println(path);
            }  
  
        } catch (Exception e) {  
        	  e.printStackTrace();
        }finally{  
        	DatabaseConnection.close(); //�رղ���  
           
        }  
		
		
		return path;
	}
}
