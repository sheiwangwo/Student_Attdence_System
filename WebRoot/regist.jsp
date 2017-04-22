<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="UTF-8"/>
        <title>学生注册界面</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
        <script src="js/jquery-2.0.3.min.js"></script>
        <script src="js/fileinput.js" type="text/javascript"></script>
        <script src="js/fileinput_locale_zh.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container ">
            <div class="page-header">
            <h1 lass="text-center">学生注册界面</h1>
          
            </div>
            
          
            <form  action="Regist.action" method="post" enctype="multipart/form-data">
            <div class="form-group has-success has-feedback">
			<label class="control-label">姓名:</label>
			<input type="text" class="form-control input-lg" placeholder="请输入学生姓名" name="name">	
			</div>
			<div class="form-group has-success has-feedback">
		    <label class="control-label">密码:</label>
		    <input type="text" class="form-control input-lg" placeholder="请输入学生密码" name="password">	
            </div>
            <div class="form-group">
            <input id="file-1" type="file" multiple class="file" data-overwrite-initial="false" data-min-file-count="2" name="photo">
             </div>
             <div class="form-group ">
             <input class="btn btn-info btn-block active input-lg"  type="submit"  value= "注册">
            </div>   
            </form>
        </div>
       

    </body>
	<script>

    $("#file-1").fileinput({
        uploadUrl: '#', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['jpg', 'png','gif'],
        overwriteInitial: false,
        showUpload: false, //是否显示上传按钮
        maxFileSize: 2000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
	});
    
    
    $(document).ready(function() {
        $("#test-upload").fileinput({
            'showPreview' : false,
            'allowedFileExtensions' : ['jpg', 'png','gif'],
            'elErrorContainer': '#errorBlock'
        });
        /*
        $("#test-upload").on('fileloaded', function(event, file, previewId, index) {
            alert('i = ' + index + ', id = ' + previewId + ', file = ' + file.name);
        });
        */
    });
    
	</script>
</html>
 <!--<form action="Regist.action" method="post" enctype="multipart/form-data">
          姓名:<input type="text" name="name"/><br/>
         密码  ：<input type="text" name="password"/><br/>   
         
         
         照片:<input type="file"  name="photo"/><br/>
    <input type="submit"  value= "提交">
    </form>-->