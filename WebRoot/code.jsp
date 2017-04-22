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
	<table class="table table-hover">
		<thead>
			<tr>
				<th>教师姓名</th>
				<th>学生姓名</th>
				<th>签到类型</th>
				<th>时间</th>
				<th>状态</th>
				<th>验证码</th>
				<th>编辑修改</th>
			</tr>
		</thead>


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
		%>
		<tbody>

			<tr class="info">
				<td><%=check_record1.getA_name()%></td>
				<td><%=check_record1.getU_name()%></td>
				<td><%=check_record1.getName()%></td>
				<td><%=check_record1.getDate()+" "+check_record1.getDate1()%></td>
				<td><%=check_record1.getState()%></td>
				<td><%=check_record1.getCode()%></td>
				<td><a id="a"
					href="updata.jsp?
		uname=<%=check_record1.getU_name()%>
		&aname=<%=check_record1.getA_name()%>
		&date=<%=check_record1.getDate()+" "+check_record1.getDate1()%>
		&state=<%=check_record1.getState()%>
		&code=<%=check_record1.getCode()%>">
						编辑修改</a></td>
			</tr>


			<%
				}
												//session.removeAttribute("check_record");
											}
			%>
		</tbody>
	</table>

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
			String cname="数据结构";
			String aname=(String)session.getAttribute("Admin_name");
				System.out.println("课程签到统计");
				//System.out.println(username);
				CountDAO countDAO=new CountDAO();
				List<user_count> ucts=countDAO.getCourseCounts(cname, aname);
				int totalCounts = countDAO.getCourseTotalCounts(cname, aname);
				ArrayList<user_count> list1 = (ArrayList<user_count>)ucts;
				if(list1!=null)
				{
			for(int i=0;i<list1.size();i++){
				user_count uct=(user_count)list1.get(i);
		%>

		<tbody>

			<tr class="info">
				<td><%=uct.getName()%></td>
				<td><%=totalCounts%></td>
				<td><%=uct.getCounts()%></td>
			</tr>


			<%
				}
												//session.removeAttribute("check_record");
											}
			%>
		</tbody>
	</table>

	<h1 class="text-center">课程签到统计</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>学生姓名</th>
				<th>是否签到</th>
			</tr>
		</thead>
		<%
			cname="数据结构";
			aname=(String)session.getAttribute("Admin_name");
			String stime = "2017-02-27 23:43:01";
			String stats;
			System.out.println("课程签到统计");
				//System.out.println(username);
			countDAO=new CountDAO();
			ucts=countDAO.getCourseCheck(cname, aname, stime);
			list1 = (ArrayList<user_count>)ucts;
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
												//session.removeAttribute("check_record");
											}
			%>
		</tbody>
	</table>










	<form action="Code.action" method="post">
		<div class="form-group has-success has-feedback">
			<label class="control-label">签到类型:</label> <input type="text"
				class="form-control input-lg" name="style" />
		</div>
		<div class="form-group has-success has-feedback">
			<label class="control-label">开始时间:</label> <input type="text"
				class="some_class form-control input-lg" value="" id="some_class_1"
				name="stime" />
		</div>
		<div class="form-group has-success has-feedback">
			<label class="control-label">结束时间:</label> <input type="text"
				class="some_class form-control input-lg" value="" id="some_class_2"
				name="etime" />
		</div>

		<div class="input-group has-success has-feedback">
			<div class="input-group-addon">
				<label class="control-label">验证码:</label>
			</div>
			<img src="kaptcha.jpg" alt="图片" class="img-rounded">
		</div>
		<br>
		<div class="form-group has-success has-feedback">
			<input type="text" class="form-control input-lg" name="vcode">
		</div>
		<div class="form-group ">
			<input class="btn btn-info btn-block active input-lg" type="submit"
				value="确定">
		</div>


	</form>

</body>
<script src="jq/jquery.js"></script>
<script src="build/jquery.datetimepicker.full.js"></script>
<script>
	/*
	window.onerror = function(errorMsg) {
	$('#console').html($('#console').html()+'<br>'+errorMsg)
	}*/

	$.datetimepicker.setLocale('en');

	$('#datetimepicker_format').datetimepicker({
		value : '2015/04/15 05:03',
		format : $("#datetimepicker_format_value").val()
	});
	console.log($('#datetimepicker_format').datetimepicker('getValue'));

	$("#datetimepicker_format_change").on("click", function(e) {
		$("#datetimepicker_format").data('xdsoft_datetimepicker').setOptions({
			format : $("#datetimepicker_format_value").val()
		});
	});
	$("#datetimepicker_format_locale").on("change", function(e) {
		$.datetimepicker.setLocale($(e.currentTarget).val());
	});

	$('#datetimepicker').datetimepicker({
		dayOfWeekStart : 1,
		lang : 'en',
		disabledDates : [ '1986/01/08', '1986/01/09', '1986/01/10' ],
		startDate : '1986/01/05'
	});
	$('#datetimepicker').datetimepicker({
		value : '2015/04/15 05:03',
		step : 10
	});

	$('.some_class').datetimepicker();

	$('#default_datetimepicker').datetimepicker({
		formatTime : 'H:i',
		formatDate : 'd.m.Y',
		//defaultDate:'8.12.1986', // it's my birthday
		defaultDate : '+03.01.1970', // it's my birthday
		defaultTime : '10:00',
		timepickerScrollbar : false
	});

	$('#datetimepicker10').datetimepicker({
		step : 5,
		inline : true
	});
	$('#datetimepicker_mask').datetimepicker({
		mask : '9999/19/39 29:59'
	});

	$('#datetimepicker1').datetimepicker({
		datepicker : false,
		format : 'H:i',
		step : 5
	});
	$('#datetimepicker2').datetimepicker({
		yearOffset : 222,
		lang : 'ch',
		timepicker : false,
		format : 'd/m/Y',
		formatDate : 'Y/m/d',
		minDate : '-1970/01/02', // yesterday is minimum date
		maxDate : '+1970/01/02' // and tommorow is maximum date calendar
	});
	$('#datetimepicker3').datetimepicker({
		inline : true
	});
	$('#datetimepicker4').datetimepicker();
	$('#open').click(function() {
		$('#datetimepicker4').datetimepicker('show');
	});
	$('#close').click(function() {
		$('#datetimepicker4').datetimepicker('hide');
	});
	$('#reset').click(function() {
		$('#datetimepicker4').datetimepicker('reset');
	});
	$('#datetimepicker5').datetimepicker(
			{
				datepicker : false,
				allowTimes : [ '12:00', '13:00', '15:00', '17:00', '17:05',
						'17:20', '19:00', '20:00' ],
				step : 5
			});
	$('#datetimepicker6').datetimepicker();
	$('#destroy').click(function() {
		if ($('#datetimepicker6').data('xdsoft_datetimepicker')) {
			$('#datetimepicker6').datetimepicker('destroy');
			this.value = 'create';
		} else {
			$('#datetimepicker6').datetimepicker();
			this.value = 'destroy';
		}
	});
	var logic = function(currentDateTime) {
		if (currentDateTime && currentDateTime.getDay() == 6) {
			this.setOptions({
				minTime : '11:00'
			});
		} else
			this.setOptions({
				minTime : '8:00'
			});
	};
	$('#datetimepicker7').datetimepicker({
		onChangeDateTime : logic,
		onShow : logic
	});
	$('#datetimepicker8').datetimepicker({
		onGenerate : function(ct) {
			$(this).find('.xdsoft_date').toggleClass('xdsoft_disabled');
		},
		minDate : '-1970/01/2',
		maxDate : '+1970/01/2',
		timepicker : false
	});
	$('#datetimepicker9').datetimepicker(
			{
				onGenerate : function(ct) {
					$(this).find('.xdsoft_date.xdsoft_weekend').addClass(
							'xdsoft_disabled');
				},
				weekends : [ '01.01.2014', '02.01.2014', '03.01.2014',
						'04.01.2014', '05.01.2014', '06.01.2014' ],
				timepicker : false
			});
	var dateToDisable = new Date();
	dateToDisable.setDate(dateToDisable.getDate() + 2);
	$('#datetimepicker11').datetimepicker(
			{
				beforeShowDay : function(date) {
					if (date.getMonth() == dateToDisable.getMonth()
							&& date.getDate() == dateToDisable.getDate()) {
						return [ false, "" ]
					}

					return [ true, "" ];
				}
			});
	$('#datetimepicker12').datetimepicker(
			{
				beforeShowDay : function(date) {
					if (date.getMonth() == dateToDisable.getMonth()
							&& date.getDate() == dateToDisable.getDate()) {
						return [ true, "custom-date-style" ];
					}

					return [ true, "" ];
				}
			});
	$('#datetimepicker_dark').datetimepicker({
		theme : 'dark'
	})
</script>
</html>
