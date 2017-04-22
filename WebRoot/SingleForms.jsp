<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.check_record"%>
<%@ page import="vo.user_count"%>
<%@ page import="dao.CountDAO"%>
<%@ page import="dao.AdminDAO"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">  
<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="jq/jquery.datetimepicker.css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
.custom-date-style {
	background-color: red !important;
}

.input {
	
}

.input-wide {
	width: 500px;
}
</style>
</head>

  
<body style="margin:50px" class="table-responsive">

	<h1 class="text-center">课程签到统计</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>学生姓名</th>
				<th>是否签到</th>
			</tr>
		</thead>
		<%
			String aname = "方芳";
			String cname=(String)session.getAttribute("course");
			//String aname=(String)session.getAttribute("Admin_name");
			String stime=(String)session.getAttribute("time");
			System.out.println(aname);
			System.out.println(cname);
			System.out.println(stime);
			//String stime = "2017-02-27 23:43:01";
			String stats;
			System.out.println("课程签到统计");
				//System.out.println(username);
			CountDAO countDAO=new CountDAO();
			List<user_count> ucts=countDAO.getCourseCheck(cname, aname, stime);
			ArrayList<user_count> list1 = (ArrayList<user_count>)ucts;
			if(list1!=null)
			{
				for(int i=0;i<list1.size();i++){
					user_count uct=(user_count)list1.get(i);
					if ( uct.getCounts() == 1)
						stats = "是";
					else
						stats = "否";
		%>

		<tbody>

			<tr class="info">
				<td><%=uct.getName()%></td>
				<td><%=stats%></td>
			</tr>


			<%
				}
											}
			%>
		</tbody>
	</table>











</body>

</html>
