<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%@ page import="dao.CountDAO"%>
<%@ page import="dao.AdminDAO"%>
<%@ page import="vo.check_record"%>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp2.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<%
	//String username = (String) session.getAttribute("Admin_name");
		String username = "方芳";
		AdminDAO AdminDAO = new AdminDAO();
		List<String> Courses = AdminDAO.getCourse(username);
		ArrayList<String> list =  (ArrayList<String>) Courses;

		String courses = "";
		String ctimes = "";
		if (list != null) {
	for (int i = 0; i < list.size(); i++) {
		String course = (String) list.get(i);
		courses = courses + course + "|";
		
		List<String> ctime = AdminDAO.getCheckTime(course, username);
		ArrayList<String> list1  = (ArrayList<String>) ctime;
		for(int j = 0;j < list1.size(); j++){
			ctimes = ctimes + (String) list1.get(j) + "|";
		}
		ctimes = ctimes + "%";
	}
		}
%>
<body>
	This is my JSP page.
	<br>
	<center>
		<form action="ViewAttdence.action" method="post" name="frm">


			<p>
				课程：<select name="course"
					onChange="redirec(document.frm.course.options.selectedIndex)">
					<option value="请选择" selected>请选择</option>


					<%
						for (int i = 0; i < list.size(); i++) {
									String course = (String) list.get(i);
					%>
					<option value=<%=course%>>
						<%=course%>
					</option>
					<%
						}
					%>

					<p>
				</select>
			</p>

			<p>
				时间：<select name="time">
					<option value="请选择" selected>请选择</option>
				</select>
			</p>
			<script language="javascript"> 
			
				var select1_len = document.frm.course.options.length;
				var select2 = new Array(select1_len);
				
							//把一级菜单都设为数组 
				for (i=0; i<select1_len; i++) 
				{ 
				select2[i] = new Array();} 
				//定义基本选项 
				var b="<%= courses%>";
				var c="<%= ctimes%>";
				var strs = new Array(); //定义一数组 
				strs = c.split("%"); //字符分割 

				for (i = 0; i < strs.length; i++) {
					var str = new Array(); //定义一数组 
					str = strs[i].split("|");
					for (j = 0; j < str.length - 1; j++) {
						select2[i + 1][j] = new Option(str[j], str[j]);
					}
				}
				//联动函数 
				function redirec(x) {
					var temp = document.frm.time;
					temp.length=0;
					for (i = 0; i < select2[x].length; i++) {
						temp.options[i] = new Option(select2[x][i].text,select2[x][i].value);
					}
					temp.options[0].selected = true;
				}
			</script>
			<br> <input type="submit" value="提交"> <input
				type="reset" value="清空">
		</form>
	</center>
</body>
</html>
