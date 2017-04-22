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
	<h1 class="text-center">学生签到信息</h1>

	<h1 class="text-center">课程签到统计（总）</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>学生姓名</th>
				<th>应签到次数</th>
				<th>成功签到次数</th>
			</tr>
		</thead>
		<%
			String cname=(String)session.getAttribute("course");
			//String cname = "数据结构";
			//String aname=(String)session.getAttribute("Admin_name");
			String aname = "方芳";
			//System.out.println("课程签到统计");
			//System.out.println(username);
			CountDAO countDAO = new CountDAO();
			List<user_count> ucts = countDAO.getCourseCounts(cname, aname);
			int totalCounts = countDAO.getCourseTotalCounts(cname, aname);
			ArrayList<user_count> list1 = (ArrayList<user_count>) ucts;
			if (list1 != null) {
				for (int i = 0; i < list1.size(); i++) {
					user_count uct = (user_count) list1.get(i);
		%>

		<tbody>

			<tr class="info">
				<td><%=uct.getName()%></td>
				<td><%=totalCounts%></td>
				<td><%=uct.getCounts()%></td>
			</tr>


			<%
				}
				}
			%>
		</tbody>
	</table>




	</form>

</body>

</html>
