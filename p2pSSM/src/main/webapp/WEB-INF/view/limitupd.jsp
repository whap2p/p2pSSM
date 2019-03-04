<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="<%=basePath%>assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="<%=basePath%>assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>assets/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>assets/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>assets/lineicons/style.css">
<!-- Custom styles for this template -->
<link href="<%=basePath%>assets/css/style.css" rel="stylesheet">
<link href="<%=basePath%>assets/css/style-responsive.css"
	rel="stylesheet">

<script src="<%=basePath%>assets/js/chart-master/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
    	function manage(){
    		var lis=$("input:checkbox");
			for(var i=0;i<3;i++){
				lis[i].checked=true;
			}
    	}
    	function manage1(){
			var lis=$("input:checkbox");
			for(var i=0;i<3;i++){
				lis[i].checked=false;
			}
    	}
    	function caiwu(){
    		var lis=$("input:checkbox");
			for(var i=3;i<9;i++){
				lis[i].checked=true;
			}
    	}
    	function caiwu1(){
    		var lis=$("input:checkbox");
			for(var i=3;i<9;i++){
				lis[i].checked=false;
			}
    	}
    	function renzhengxiang(){
    		var lis=$("input:checkbox");
			for(var i=9;i<14;i++){
				lis[i].checked=true;
			}
    	}
    	function renzhengxiang1(){
    		var lis=$("input:checkbox");
			for(var i=9;i<14;i++){
				lis[i].checked=false;
			}
    	}

    	function jiedai(){
    		var lis=$("input:checkbox");
			for(var i=14;i<24;i++){
				lis[i].checked=true;
			}
    	}
    	function jiedai1(){
    		var lis=$("input:checkbox");
			for(var i=14;i<24;i++){
				lis[i].checked=false;
			}
    	}

    </script>
    <script>
	function sub(){
		document.getElementById("frm").submit();
	}
</script>
</head>
<body>
	<!-- 导航栏 --><jsp:include page="common.jsp"></jsp:include>
	<!--main content start-->
	<section id="main-content"> <section class="wrapper">

	<!-- 内容开始 -->
	<div class="col-md-12 mt">
		<div class="content-panel">
			<form action="<%=basePath%>limit/upd" method="post" name="frm">
				<input type="hidden" name="did" value="${did }">
                <%
                    List lists=(List)request.getAttribute("listss");
                %>
                    <dl class="permission-list">
                        <dt><label class="middle"><input name="inp" <% if (lists.contains("1000")) {%>checked="checked" <%}%> value="1000" class="ace" type="checkbox" ><h4 class="lbl">后台管理系统</h4></label></dt>
                        <dd>
                            <dl class="cl permission-list2">
                                <dt><label class="middle"><input type="checkbox" <% if (lists.contains("10011")) {%>checked="checked" <%}%> value="1001" class="ace"  name="inp"  ><span class="lbl">管理组</span></label></dt>
                                <dd>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10011")) {%>checked="checked" <%}%> value="10011" class="ace" name="inp"  ><span class="lbl">部门管理</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10012")) {%>checked="checked" <%}%> value="10012" class="ace" name="inp"  ><span class="lbl">员工管理</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10013")) {%>checked="checked" <%}%> value="10013" class="ace" name="inp"  ><span class="lbl">用户管理</span></label>
                                </dd>
                            </dl>
                            <dl class="cl permission-list2">
                                <dt><label class="middle"><input type="checkbox" <% if (lists.contains("1002")) {%>checked="checked" <%}%> value="1002" class="ace"  name="inp" > <span class="lbl">网站内容管理</span></label></dt>
                                <dd>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10021")) {%>checked="checked" <%}%> value="10021" class="ace" name="inp" ><span class="lbl">添加网站通知</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10022")) {%>checked="checked" <%}%> value="10022" class="ace" name="inp" ><span class="lbl">查询网站通知</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10023")) {%>checked="checked" <%}%> value="10023" class="ace" name="inp"  ><span class="lbl">添加网站首页图片</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10024")) {%>checked="checked" <%}%> value="10024" class="ace" name="inp"  ><span class="lbl">查询首页图片</span></label>
                                </dd>
                            </dl>
                            <dl class="cl permission-list2">
                                <dt><label class="middle"><input type="checkbox" <% if (lists.contains("1003")) {%>checked="checked" <%}%> value="1003" class="ace"  name="inp"  > <span class="lbl">财务管理</span></label></dt>
                                <dd>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10031")) {%>checked="checked" <%}%> value="10031" class="ace" name="inp"  ><span class="lbl">提现管理</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10032")) {%>checked="checked" <%}%> value="10032" class="ace" name="inp"  ><span class="lbl">银行卡管理</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10033")) {%>checked="checked" <%}%> value="10033" class="ace" name="inp"  ><span class="lbl">充值记录</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10034")) {%>checked="checked" <%}%> value="10034" class="ace" name="inp"  ><span class="lbl">手续费记录</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10035")) {%>checked="checked" <%}%> value="10035" class="ace" name="inp"  ><span class="lbl">交易记录</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10036")) {%>checked="checked" <%}%> value="10036" class="ace" name="inp"  ><span class="lbl">借贷信息列表</span></label>
                                </dd>
                            </dl>
                            <dl class="cl permission-list2">
                                <dt><label class="middle"><input type="checkbox" <% if (lists.contains("1004")) {%>checked="checked" <%}%> value="1004" class="ace"  name="inp"  > <span class="lbl">借贷管理</span></label></dt>
                                <dd>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10041")) {%>checked="checked" <%}%> value="10041" class="ace" name="inp"  ><span class="lbl">投标列表</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10042")) {%>checked="checked" <%}%> value="10042" class="ace" name="inp"  ><span class="lbl">添加投标</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10043")) {%>checked="checked" <%}%> value="10043" class="ace" name="inp"  ><span class="lbl">标种列表</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10044")) {%>checked="checked" <%}%> value="10044" class="ace" name="inp"  ><span class="lbl">添加标种</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10045")) {%>checked="checked" <%}%> value="10045" class="ace" name="inp"  ><span class="lbl">所有借款</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10046")) {%>checked="checked" <%}%> value="10046" class="ace" name="inp"  ><span class="lbl">待审核的借款</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10047")) {%>checked="checked" <%}%> value="10047" class="ace" name="inp"  ><span class="lbl">招标中的借款</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10048")) {%>checked="checked" <%}%> value="10048" class="ace" name="inp"  ><span class="lbl">还款</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10049")) {%>checked="checked" <%}%> value="10049" class="ace" name="inp"  ><span class="lbl">满标借款</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("100141")) {%>checked="checked" <%}%> value="100141" class="ace" name="inp"  ><span class="lbl">还款方式</span></label>
                                </dd>
                            </dl>
                            <dl class="cl permission-list2">
                                <dt><label class="middle"><input type="checkbox" <% if (lists.contains("1005")) {%>checked="checked" <%}%> value="1005" class="ace"  name="inp"  > <span class="lbl">认证项管理</span></label></dt>
                                <dd>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10051")) {%>checked="checked" <%}%> value="10051" class="ace" name="inp"  ><span class="lbl">新用户认证资料</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10052")) {%>checked="checked" <%}%> value="10052" class="ace" name="inp"  ><span class="lbl">用户资料认证</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10053")) {%>checked="checked" <%}%> value="10053" class="ace" name="inp"  ><span class="lbl">认证资料统计</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10054")) {%>checked="checked" <%}%> value="10054" class="ace" name="inp"  ><span class="lbl">信用额度申请</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10055")) {%>checked="checked" <%}%> value="10055" class="ace" name="inp"  ><span class="lbl">认证项设置</span></label>
                                </dd>
                            </dl>
                            <dl class="cl permission-list2">
                                <dt><label class="middle"><input type="checkbox" <% if (lists.contains("1006")) {%>checked="checked" <%}%> value="1006" class="ace"  name="user-Character-0-1"  > <span class="lbl">权限管理</span></label></dt>
                                <dd>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10061")) {%>checked="checked" <%}%> value="10061" class="ace" name="inp"  ><span class="lbl">权限列表</span></label>
                                    <label class="middle"><input type="checkbox" <% if (lists.contains("10062")) {%>checked="checked" <%}%> value="10062" class="ace" name="inp"  ><span class="lbl">菜单列表</span></label>
                                </dd>
                            </dl>
                        </dd>
                    </dl>
                    &nbsp;&nbsp;&nbsp;&nbsp;<button onClick="sub();" class="btn btn-success" type="submit">
					 保存
				</button>&nbsp;&nbsp;
				<a href="javascript:history.go(-1)" style="text-decoration: none;"><button class="btn btn-primary">返回</button></a>
			</form>

		</div>
	</div>
	<!-- 内容结束 --> </section> </section>
	<!-- /MAIN CONTENT -->
</body>
<!--custom switch-->
<!-- js placed at the end of the document so the pages load faster -->
<script src="<%=basePath%>assets/js/jquery.js"></script>
<script src="<%=basePath%>assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
	src="<%=basePath%>assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="<%=basePath%>assets/js/jquery.scrollTo.min.js"></script>
<script src="<%=basePath%>assets/js/jquery.nicescroll.js"
	type="text/javascript"></script>


<!--common script for all pages-->
<script src="<%=basePath%>assets/js/common-scripts.js"></script>

<!--script for this page-->
<script src="<%=basePath%>assets/js/jquery-ui-1.9.2.custom.min.js"></script>

<!--custom switch-->
<script src="<%=basePath%>assets/js/bootstrap-switch.js"></script>

<!--custom tagsinput-->
<script src="<%=basePath%>assets/js/jquery.tagsinput.js"></script>

<!--custom checkbox & radio-->

<script type="text/javascript"
	src="<%=basePath%>assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="<%=basePath%>assets/js/bootstrap-daterangepicker/date.js"></script>
<script type="text/javascript"
	src="<%=basePath%>assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>

<script type="text/javascript"
	src="<%=basePath%>assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>


<script src="<%=basePath%>assets/js/form-component.js"></script>

<script type="text/javascript"
	src="<%=basePath%>My97DatePickers/WdatePicker.js"></script>
<script>
    /*按钮选择*/
    $(function(){
        $(".permission-list dt input:checkbox").click(function(){
            $(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
        });
        $(".permission-list2 dd input:checkbox").click(function(){
            var l =$(this).parent().parent().find("input:checked").length;
            var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
            if($(this).prop("checked")){
                $(this).closest("dl").find("dt input:checkbox").prop("checked",true);
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
            }
            else{
                if(l==0){
                    $(this).closest("dl").find("dt input:checkbox").prop("checked",false);
                }
                if(l2==0){
                    $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
                }
            }

        });
    });

</script>
</html>