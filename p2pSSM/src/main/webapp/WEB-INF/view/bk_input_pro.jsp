<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="Dashboard">
	<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

	<title>DASHGUM - FREE Bootstrap Admin Template</title>

	<!-- Bootstrap core CSS -->
	<link href="<%=basePath%>assets/css/bootstrap.css" rel="stylesheet">
	<!--external css-->
	<link href="<%=basePath%>assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/css/zabuto_calendar.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/js/gritter/css/jquery.gritter.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/lineicons/style.css">

	<!-- Custom styles for this template -->
	<link href="<%=basePath%>assets/css/style.css" rel="stylesheet">
	<link href="<%=basePath%>assets/css/style-responsive.css" rel="stylesheet">

	<script src="<%=basePath%>assets/js/chart-master/Chart.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>

<body>
<!-- 导航栏 --><jsp:include page="common.jsp"></jsp:include>
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- 内容开始 -->
		<div class="showback">
			<h4>
				<i class="fa fa-angle-right">
					<a href="<%=basePath%>dept/findall">部门列表</a>
				</i>
				<i class="fa fa-angle-right">
					<a  href="javascript:history.go(-1)">返回</a>
				</i>
			</h4>
			<!-- 页面内容 -->

			<form class="form-horizontal style-form" method="post"
				  action="<%=basePath%>hhjproduct/add" enctype="multipart/form-data">

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">预期年化收益：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入预期年化收益</span>
						<input type="text" class="form-control" name="pincome" maxlength="10">

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">项目期限：</label>
					<div class="col-sm-10">
						<span class="help-block">请选择项目期限</span>
						<input type="date" class="form-control" name="ptime">

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label"> 类型：</label>
					<div class="col-sm-10">
						<span class="help-block">请选择项目类型</span>
						<select class="form-control" name="ptype">
							<option>请选择</option>
							<c:forEach items="${biaovalue}" var="bb">
								<option value="${bb.id}">${bb.bname}</option>
							</c:forEach>
						</select>

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">还款方式：</label>
					<div class="col-sm-10">
						<span class="help-block">请选择还款方式</span>
						<select class="form-control" name="pway">
							<option value="">请选择</option>
							<option value="到期还本付息">到期还本付息</option>
							<option value="按月付息">按月付息</option>
							<option value="到期还本">到期还本</option>
							<option value="等额本息">等额本息</option>
						</select>

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">借款期限：</label>
					<div class="col-sm-10">
						<span class="help-block">请选择期限期限</span>
						<input type="date" class="form-control" name="pcount" maxlength="10">

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">投资进度：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入投资进度</span>
						<input type="text" class="form-control" name="progress" maxlength="10">

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">保障方式：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入保障方式</span>
						<input type="text" class="form-control" name="psaveway" maxlength="10">

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">需还本息：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入需还本息</span>
						<input type="text" class="form-control" name="prateben" maxlength="10">

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">产品名称：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入产品名称</span>
						<input type="text" class="form-control" name="pname" maxlength="10">

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">募集资金：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入募集资金</span>
						<input type="text" class="form-control" name="ptotalmoney" maxlength="10">

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">投资范围：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入投资范围</span>
						<input type="text" name="prange1">到<input type="text" name="prange2">

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">资金用途：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入资金用途</span>
						<input type="text" class="form-control" name="puse" maxlength="10">

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">封面：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入封面</span>
						<input type="file" class="form-control" name="dname" maxlength="10">

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">保障措施：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入保障措施</span>
						<input type="text" class="form-control" name="psaveway" maxlength="10">

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">项目描述：</label>
					<div class="col-sm-10">
						<span class="help-block">请输入描述.(不超过50个汉字)</span>
						<textarea rows="3" cols="30" class="form-control" name="pdesc" maxlength="50">
									</textarea>

					</div>
				</div>


				<button type="submit" class="btn btn-primary btn-lg btn-block">提交</button>
			</form>

			<!-- 页面内容 -->
		</div>
		<!-- 内容结束 -->
	</section><! --/wrapper -->
</section><!-- /MAIN CONTENT -->
</body>

<!--custom switch-->
<!-- js placed at the end of the document so the pages load faster -->
<script src="<%=basePath%>assets/js/jquery.js"></script>
<script src="<%=basePath%>assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="<%=basePath%>assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="<%=basePath%>assets/js/jquery.scrollTo.min.js"></script>
<script src="<%=basePath%>assets/js/jquery.nicescroll.js" type="text/javascript"></script>


<!--common script for all pages-->
<script src="<%=basePath%>assets/js/common-scripts.js"></script>

<!--script for this page-->
<script src="<%=basePath%>assets/js/jquery-ui-1.9.2.custom.min.js"></script>

<!--custom switch-->
<script src="<%=basePath%>assets/js/bootstrap-switch.js"></script>

<!--custom tagsinput-->
<script src="<%=basePath%>assets/js/jquery.tagsinput.js"></script>

<!--custom checkbox & radio-->

<script type="text/javascript" src="<%=basePath%>assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/js/bootstrap-daterangepicker/date.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>

<script type="text/javascript" src="<%=basePath%>assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>


<script src="<%=basePath%>assets/js/form-component.js"></script>

<script type="text/javascript" src="<%=basePath%>My97DatePickers/WdatePicker.js"></script>
<script type="text/javascript">
	function maxTextValue(obj,maxlen)
	{
		if (obj.value.length>maxlen)
		{
			alert('文本框输入超出'+maxlen+'个长度');
			obj.value=obj.value.substring(0,maxlen);
		}
	}
	function jsdate() {
		var b = document.getElementsByName("qj.endtime");
		var s = document.getElementsByName("qj.startime");

		var bd = b[0].value;
		var sd = s[0].value;

		var arr = bd.split("-");
		var oldtime = new Date(arr[0], arr[1], arr[2]);
		var oldtimes = oldtime.getTime();

		var arrt = sd.split("-");
		var newtime = new Date(arrt[0], arrt[1], arrt[2]);
		var newtimes = newtime.getTime();

		var input = document.getElementById("in");

		if (b[0].value != "" && s[0].value != "") {
			if (newtimes > oldtimes) {
				confirm("MDZZ");
				return;
			} else {
				var diff = oldtimes - newtimes;
				var days = diff / (1000 * 60 * 60 * 24);
				input.value = days;
			}
		}
	}

	function zfs() {
		var zf=document.getElementById("zf").value;
		if (zf.length>30) {
			alert("发布内容请控制在20字以内");
			document.getElementById("zf").focus();
		}
	}

	function as() {
		var yg=document.getElementById("yg").value;
		var sz="";
		sz= yg.split(";");
		var dx=document.getElementById("dx").value;
		var dxid=document.getElementById("dxid").value;
		document.getElementById("dx").value=dx+";"+sz[1];
		document.getElementById("dxid").value=dxid+";"+sz[0];

	}
</script>

<script>
	function getTime()
	{
		var today=new Date();
		var h=today.getHours();
		var m=today.getMinutes();
		var s=today.getSeconds();
		// add a zero in front of numbers<10
		m=checkTime(m);
		s=checkTime(s);
		document.getElementById('showtime').innerHTML=h+":"+m+":"+s;
		t=setTimeout(function(){getTime()},500);
	}

	function checkTime(i)
	{
		if (i<10)
		{
			i="0" + i;
		}
		return i;
	}
</script>
<script type="text/javascript">
	function b3() {
		var currdate=new Date();
		var predate=new Date(currdate.getTime()-0*24*60*60*1000).toLocaleDateString();
		var pre=predate.replace("/","-");
		var	 pre=pre.replace("/","-");
		document.getElementById("d12").value=pre;

		var nextdate=new Date(currdate.getTime()+3*24*60*60*1000).toLocaleDateString();
		var next=nextdate.replace("/","-");
		var	 next=next.replace("/","-");
		document.getElementById("d13").value=next;

	}
</script>
<script type="text/javascript">
	function b4() {
		var currdate=new Date();
		var predate=new Date(currdate.getTime()-0*24*60*60*1000).toLocaleDateString();
		var pre=predate.replace("/","-");
		var	 pre=pre.replace("/","-");
		document.getElementById("d12").value=pre;

		var nextdate=new Date(currdate.getTime()+7*24*60*60*1000).toLocaleDateString();
		var next=nextdate.replace("/","-");
		var	 next=next.replace("/","-");
		document.getElementById("d13").value=next;

	}
</script>

<script type="text/javascript">
	function b5() {
		var currdate=new Date();
		var predate=new Date(currdate.getTime()-0*24*60*60*1000).toLocaleDateString();
		var pre=predate.replace("/","-");
		var	 pre=pre.replace("/","-");
		document.getElementById("d12").value=pre;

		var nextdate=new Date(currdate.getTime()+30*24*60*60*1000).toLocaleDateString();
		var next=nextdate.replace("/","-");
		var	 next=next.replace("/","-");
		document.getElementById("d13").value=next;

	}
</script>

<script>
	//custom select box

	$(function(){
		$('select.styled').customSelect();
	});

</script>
</html>
