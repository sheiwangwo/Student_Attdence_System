package dao;
import vo.code;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.jdbc.ResultSet;

import dbc.DatabaseConnection;

public class CodeDAO {
	//插入Vcode
		public int register(code code)
		{
			int num=0;
			PreparedStatement ps=null;
			 Connection conn=null;
			
			try{
				
				 conn=DatabaseConnection.getConnection();//获取连接();
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
//查询
		public String search_stime(String aname,String code)
		{
			int num=0;

			PreparedStatement ps=null;
			 Connection conn=null;
			String flag=null;
			 try {  
		            String sql="select stime from code"+" where aname=? and vcode=?";
		            conn=DatabaseConnection.getConnection();//获取连接();
		            ps=conn.prepareStatement(sql);//实例化操作  
		            ps.setString(1,aname);  
		            ps.setString(2, code);
		            ResultSet rSet=(ResultSet) ps.executeQuery();//取得结果   
		            if(rSet.next()){ 
		            	
		                flag= rSet.getString(1);//取得初始时间       
		            }  
		  
		        } catch (Exception e) {  
		        	  e.printStackTrace();
		        }finally{  
		        	DatabaseConnection.close(); //关闭操作  
		           
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
		            conn=DatabaseConnection.getConnection();//获取连接();
		            ps=conn.prepareStatement(sql);//实例化操作  
		            ps.setString(1,aname);  
		            ps.setString(2, code);
		            ResultSet rSet=(ResultSet) ps.executeQuery();//取得结果   
		            if(rSet.next()){ 
		            	
		                flag= rSet.getString(1);//取得初始时间       
		            }  
		  
		        } catch (Exception e) {  
		        	  e.printStackTrace();
		        }finally{  
		        	DatabaseConnection.close(); //关闭操作  
		           
		        }  
		              
		        
			 return flag;
		}
		//查询课程名称
		public String search_style(String aname,String code)
		{
			//int num=0;

			PreparedStatement ps=null;
			 Connection conn=null;
			String flag=null;
			 try {  
		            String sql="select name from code"+" where aname=? and vcode=?";
		            conn=DatabaseConnection.getConnection();//获取连接();
		            ps=conn.prepareStatement(sql);//实例化操作  
		            ps.setString(1,aname);  
		            ps.setString(2, code);
		            ResultSet rSet=(ResultSet) ps.executeQuery();//取得结果   
		            if(rSet.next()){ 
		            	
		                flag= rSet.getString(1);//取得初始时间       
		            }  
		  
		        } catch (Exception e) {  
		        	  e.printStackTrace();
		        }finally{  
		        	DatabaseConnection.close(); //关闭操作  
		           
		        }  
		              
		        
			 return flag;
			
		}
}
