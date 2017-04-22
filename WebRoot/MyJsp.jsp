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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<%
	String username=(String)session.getAttribute("Admin_name");
		System.out.println(username);
		AdminDAO AdminDAO=new AdminDAO();
		List<check_record> check_record=AdminDAO.getcheck(username);
		ArrayList<check_record> list=null;
		list=(ArrayList<check_record>)check_record;

		String name=null;
		if(list!=null)
		{
			for(int i=0;i<list.size();i++){
				check_record check_record1=(check_record)list.get(i);
			   name=check_record1.getU_name();
			   }
	   }
%>

<script src="jq/jquery.js"></script>

<script>
	$.fn.extend({
		parent_select_change : function(province) {
			$("#child_select").empty();

			var parent = $("#parent_select").val();

			if (parent == '') {
				return false;
			}
			var cities = null;
			for (var i = 0; i < province.length; i++) {
				var p = province[i];
				if (p.id == parent) {
					cities = p.city;
					break;
				}
			}

			for (var i = 0; i < cities.length; i++) {
				city = cities[i];
				var o = new Option(city.name, city.cid);
				$("#child_select").append(o);
			}
		},

		show_province_items : function() {
			var resp = [ {
				"id" : 1,
				"name" : "山西",
				"city" : [ {
					"cid" : 1,
					"name" : "太原",
				}, {
					"cid" : 2,
					"name" : "临汾",
				} ],
			}, {
				"id" : 2,
				"name" : "陕西",
				"city" : [ {
					"cid" : 3,
					"name" : "榆林",
				}, {
					"cid" : 4,
					"name" : "西安",
				} ],
			}, ];

			//以上为模拟数据，可以用getJSON的方式，从服务器端取回来数据  
			//$.getJSON("/province", function(resp){  
			var html = ""
			var pro = resp
			html += "<option value=''> --请选择-- </option>"
			if (pro) {
				for (var i = 0; i < pro.length; i++) {
					var p = pro[i];
					html += "<option value='" + p.id + "'>" + p.name
							+ "</option>"
				}
			}

			$("#parent_select").empty();
			$("#parent_select").html(function(i, origText) {
				return html;
			});

			$("#parent_select").change(function() {
				$(this).parent_select_change(pro);
			});
			//});  
		}
	});

	$(document).ready(function() {
		$(this).show_province_items();
	});
</script>

</head>

<body>
	<center>
		<h1>级联列表</h1>
		省：<select id='parent_select' name='province'></select> 市：<select
			id='child_select' name='city'></select> <br>
	</center>
</body>
</html>
