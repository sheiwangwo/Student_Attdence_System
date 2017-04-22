package dao;
import vo.code;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.jdbc.ResultSet;

import dbc.DatabaseConnection;

public class CodeDAO {
	//����Vcode
		public int register(code code)
		{
			int num=0;
			PreparedStatement ps=null;
			 Connection conn=null;
			
			try{
				
				 conn=DatabaseConnection.getConnection();//��ȡ����();
				 String sql="INSERT into code values(?,?,?,?,?,?)";
					ps=conn.prepareStatement(sql);
					ps.setInt(1, code.getId());
					ps.setString(2,code.getAname());
					ps.setString(3, code.getVcode());
					ps.setTimestamp(4,code.getTimestamp());
					
					System.out.println("*****");
					System.out.println(code.getTimestamp1());
					ps.setTimestamp(5,code.getTimestamp1());
					//ps.setTime(5, code.getEtime1());
					ps.setString(6, code.getName());
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
//��ѯ
		public String search_stime(String aname,String code)
		{
			int num=0;

			PreparedStatement ps=null;
			 Connection conn=null;
			String flag=null;
			 try {  
		            String sql="select stime from code"+" where aname=? and vcode=?";
		            conn=DatabaseConnection.getConnection();//��ȡ����();
		            ps=conn.prepareStatement(sql);//ʵ��������  
		            ps.setString(1,aname);  
		            ps.setString(2, code);
		            ResultSet rSet=(ResultSet) ps.executeQuery();//ȡ�ý��   
		            if(rSet.next()){ 
		            	
		                flag= rSet.getString(1);//ȡ�ó�ʼʱ��       
		            }  
		  
		        } catch (Exception e) {  
		        	  e.printStackTrace();
		        }finally{  
		        	DatabaseConnection.close(); //�رղ���  
		           
		        }  
		              
		        
			 return flag;
		}
		
		public String search_etime(String aname,String code)
		{
			int num=0;

			PreparedStatement ps=null;
			 Connection conn=null;
			String flag=null;
			 try {  
		            String sql="select etime from code"+" where aname=? and vcode=?";
		            conn=DatabaseConnection.getConnection();//��ȡ����();
		            ps=conn.prepareStatement(sql);//ʵ��������  
		            ps.setString(1,aname);  
		            ps.setString(2, code);
		            ResultSet rSet=(ResultSet) ps.executeQuery();//ȡ�ý��   
		            if(rSet.next()){ 
		            	
		                flag= rSet.getString(1);//ȡ�ó�ʼʱ��       
		            }  
		  
		        } catch (Exception e) {  
		        	  e.printStackTrace();
		        }finally{  
		        	DatabaseConnection.close(); //�رղ���  
		           
		        }  
		              
		        
			 return flag;
		}
		//��ѯ�γ�����
		public String search_style(String aname,String code)
		{
			//int num=0;

			PreparedStatement ps=null;
			 Connection conn=null;
			String flag=null;
			 try {  
		            String sql="select name from code"+" where aname=? and vcode=?";
		            conn=DatabaseConnection.getConnection();//��ȡ����();
		            ps=conn.prepareStatement(sql);//ʵ��������  
		            ps.setString(1,aname);  
		            ps.setString(2, code);
		            ResultSet rSet=(ResultSet) ps.executeQuery();//ȡ�ý��   
		            if(rSet.next()){ 
		            	
		                flag= rSet.getString(1);//ȡ�ó�ʼʱ��       
		            }  
		  
		        } catch (Exception e) {  
		        	  e.printStackTrace();
		        }finally{  
		        	DatabaseConnection.close(); //�رղ���  
		           
		        }  
		              
		        
			 return flag;
			
		}
}
