<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="vo.check_record"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.UserDAO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>学生签到信息</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/fileinput.css" media="all" rel="stylesheet"
	type="text/css" />
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/fileinput.js" type="text/javascript"></script>
<script src="js/fileinput_locale_zh.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

</head>

<body style="margin:50px" class="table-responsive">
	<h1 class="text-center">学生签到信息</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>学生姓名</th>
				<th>教师姓名</th>
				<th>签到类型</th>
				<th>时间</th>
				<th>状态</th>
				<th>验证码</th>
			</tr>
		</thead>
		<%
			String username=(String)session.getAttribute("u_name");
		System.out.println("学生查询全部信息");
		System.out.println(username);
		UserDAO UserDAO=new UserDAO();
		List<check_record> check_record=UserDAO.getcheck(username);
		ArrayList<check_record> list=null;
		list=(ArrayList<check_record>)check_record;
		String name=null;
		name=(String)session.getAttribute("u_name");
		if(list!=null)
		{
			for(int i=0;i<list.size();i++){
				check_record check_record1=(check_record)list.get(i);
			  
			   System.out.println(name);
		%>

		<tbody>

			<tr class="info">
				<td><%=check_record1.getU_name()%></td>
				<td><%=check_record1.getA_name()%></td>
				<td><%=check_record1.getName()%></td>
				<td><%=check_record1.getDate()+" "+check_record1.getDate1()%></td>
				<td><%=check_record1.getState()%></td>
				<td><%=check_record1.getCode()%></td>
			</tr>


			<%
				}
				//session.removeAttribute("check_record");
			}
			%>
		</tbody>
	</table>

	<form action="Sign.action" method="post" enctype="multipart/form-data">
		<input type="text" name="u_name" value=<%=name%> style="display:none">
		<div class="form-group has-success has-feedback">
			<label class="control-label">教师姓名:</label> <input type="text"
				class="form-control input-lg" placeholder="请输入教师姓名" name="a_name">

		</div>
		<div class="form-group has-success has-feedback">
			<label class="control-label">验证码 :</label> <input type="text"
				class="form-control input-lg" placeholder="请输入验证码 " name="code">
		</div>
		<div class="form-group">
			<input id="file-1" type="file" multiple class="file"
				data-overwrite-initial="false" data-min-file-count="2" name="photo">
		</div>
		<div class="form-group ">
			<input class="btn btn-info btn-block active input-lg" type="submit"
				value="签到">
		</div>
	</form>






</body>
<script>
	$("#file-1").fileinput({
		uploadUrl : '#', // you must set a valid URL here else you will get an error
		allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
		overwriteInitial : false,
		showUpload : false, //是否显示上传按钮
		maxFileSize : 3000,
		maxFilesNum : 10,
		//allowedFileTypes: ['image', 'video', 'flash'],
		slugCallback : function(filename) {
			return filename.replace('(', '_').replace(']', '_');
		}
	});

	$(document).ready(function() {
		$("#test-upload").fileinput({
			'showPreview' : false,
			'allowedFileExtensions' : [ 'jpg', 'png', 'gif' ],
			'elErrorContainer' : '#errorBlock'
		});
		/*
		$("#test-upload").on('fileloaded', function(event, file, previewId, index) {
		    alert('i = ' + index + ', id = ' + previewId + ', file = ' + file.name);
		});
		 */
	});
</script>
</html>
