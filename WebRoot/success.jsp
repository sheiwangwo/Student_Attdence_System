<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<script type="text/javascript">     
function countDown(secs,surl){     
 //alert(surl);     
 var jumpTo = document.getElementById('jumpTo');
 jumpTo.innerHTML=secs;  
 if(--secs>0){     
     setTimeout("countDown("+secs+",'"+surl+"')",1000);     
     }     
 else{       
     location.href=surl;     
     }     
 }  

</script> 
</head>
  
  <body >

<div align="center">注册成功！<span id="jumpTo">5</span>秒后自动跳转到登陆界面
<script type="text/javascript">countDown(5,'login.jsp');</script>  </div> 

</br>

 <div align="center"><img src="img/timg.jpg" ></div> 
</body>
</html>
