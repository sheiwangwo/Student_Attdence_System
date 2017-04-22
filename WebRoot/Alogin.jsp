<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>学生签到系统</title>
 
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/fort.css">

<script src="js/fort.js"></script>
    <script type="text/javascript">
       
    </script>
</head>
<body>

<div class="form-wrapper" >
  <div class="top"><div class="colors"></div></div>
   <center><h1 style="color: white">教师登陆</h1></center>
	<form name="login"  action="Alogin.action" method="post" >
		<div class="form" >
            <div id="error" style="color: red"></div>
			<div class="form-item">
				<input type="text" id="username" name="username"  placeholder="Username" autocomplete="off">
			</div>
			<div class="form-item">
				<input type="password" id="password" name="password"  placeholder="Password" autocomplete="off">
			</div>
			<div class="button-panel">
     			<input type="submit" class="button" title="login" value="login" >
			</div>
            
		</div>
	</form>
</div>
<div class="footer-banner" style="width:728px; margin:200px auto 0"></div>
<script>
    flash();
</script>

</body>
</html>
