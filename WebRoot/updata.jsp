<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link href="css/bootstrap.min.css" rel="stylesheet">
<title>修改学生签到信息</title>

  </head>
  <%


String state = new String(request.getParameter("state").getBytes("ISO-8859-1"),"utf-8"); 
String aname = new String(request.getParameter("aname").getBytes("ISO-8859-1"),"utf-8");
String uname = new String(request.getParameter("uname").getBytes("ISO-8859-1"),"utf-8");
String date = new String(request.getParameter("date").getBytes("ISO-8859-1"),"utf-8");
String code = new String(request.getParameter("code").getBytes("ISO-8859-1"),"utf-8");
%>
  <body>
   <div class="container ">
            <div class="page-header">
            <h1 lass="text-center">学生注册界面</h1>
          
            </div>
  
  <form action="Updata.action" method="post" >
  <div class="form-group has-success has-feedback">
  <input class="form-control input-lg" type="text" placeholder="教师姓名:<%=aname %>" readonly>
  </div>
<input type="text" name="aname" value=<%=aname %> style="display:none;"> 
<div class="form-group has-success has-feedback">
  <input class="form-control input-lg" type="text" placeholder="学生姓名:<%=uname %>" readonly>
  </div>
<input type="text" name="uname" value=<%=uname %> style="display:none;"> 
<div class="form-group has-success has-feedback">
  <input class="form-control input-lg" type="text" placeholder="签到时间:<%=date %> " readonly>
  </div>

<input type="text" name="date" value=<%=date %> style="display:none;"> 
<div class="form-group has-success has-feedback">
  <input class="form-control input-lg" type="text" placeholder="验证码:<%=code %>" readonly>
  </div>
<input type="text" name="code" value=<%=code %> style="display:none;"> 
<div class="form-group has-success has-feedback">
 <select class="form-control" name="state" >
		<option>是</option>
		<option>否</option>
	</select>
  </div>

 <input class="btn btn-info btn-block active input-lg" type="submit" value= "确定">  
</form>
</div>
  </body>
</html>
