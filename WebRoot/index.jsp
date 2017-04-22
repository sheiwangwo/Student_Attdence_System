<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>学生签到系统</title>
 
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/fort.css">

<script src="js/fort.js"></script>
    <script type="text/javascript">
       
    </script>
</head>
<body>

<div class="form-wrapper" >
  <div class="top"><div class="colors"></div></div>
   <center><h1 style="color: white">学生签到系统 </h1></center>
	
		<div class="form" >
            <div id="error" style="color: red"></div>
			<div class="button-panel">
     			<input   value="学生登录 " class="button" title="学生登录" onclick="window.open('login.jsp')">
			</div>
			<div class="button-panel">
     			<input   value="教师登录 " class="button"  title="教师登录" onclick="window.open('Alogin.jsp')">
			</div>
			<div class="button-panel">
     			<input   value="注册" class="button"  title="注册" onclick="window.open('regist.jsp')">
			</div>
            
		</div>
	
</div>
<div class="footer-banner" style="width:728px; margin:200px auto 0"></div>
<script>
    flash();
</script>

</body>
</html>
