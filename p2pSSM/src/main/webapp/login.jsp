<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="<%=basePath%>css/common.css" rel="stylesheet" />
<link href="<%=basePath%>css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>script/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>script/common.js"></script>
<script src="<%=basePath%>script/login.js" type="text/javascript"></script>
	<script type="text/javascript" src="${basePath}/Jquery/jquery-2.1.4.min.js"></script>
	<script src="<%=basePath%>script/login.js" type="text/javascript"></script>
	<script type="text/javascript">
        $(function() {
        })
        $(function(){
            // 向服务器发起开启轮询验证通知， 第一波验证二维码被扫状态
            $.ajax({
                url:"${pageContext.request.contextPath}/users/validate",
                method: "post",
                data:{
                    uuid:"${uuid}",
                },
                success:function(res){
                    var state = res.state;
                    $("#msg").html('');
                    if( state == -3){
                        $("#msg").append("二维码已经失效");
                    }
                    else if(state == 1){
                        $("#msg").append("请在手机上确认登录");

                        // 第二波验证登录状态
                        $.ajax({
                            url:"${pageContext.request.contextPath}/users/validate",
                            method: "post",
                            data:{
                                uuid:"${uuid}",
                            },
                            success:function(res){
                                var state = res.state;
                                $("#msg").html('');
                                if( state == -3){
                                    $("#msg").append("二维码已经失效");
                                }
                                if(state == 2){
                                    $("#msg").append("登录成功，正在跳转。。。");
                                    setInterval(function(){
                                        window.location.href ="${pageContext.request.contextPath}/user/login?unickname=用户&&upassword=1234";
                                    }, 1*1000)
                                }
                                else if(state == -2){
                                    $("#msg").append("取消登录");
                                }
                            }
                        });
                    }
                }
            });
        });

	</script>
</head>
<body>
	<!-- 导航栏 --><jsp:include page="head.jsp"></jsp:include>


	<!--登陆-->
	<div class="wrap">
		<form id="LonginForm" name="LonginForm" action="<%=basePath%>user/login" method="post">
			<div class="tdbModule loginPage">
				<div class="registerTitle">用户登录</div>



				<div class="registerCont">
					<ul>
						<li class="error"><span id="prrintInfo" data-info=""><span>${status}</span></span>

							<div class="loginPanel normalPanel" style="margin-left: 320px">
							<div class="title">微信登录</div>
							<div class="waiting panelContent">
								<div class="wrp_code"><img class="qrcode lightBorder" src="${pageContext.request.contextPath}/users/code/${uuid}" /></div>
								<div class="info">
									<div  id="wx_default_tip">
										<p id="msg">请使用微信扫描二维码登录</p><a style="" href="${pageContext.request.contextPath}/users/index">刷新</a>
									</div>
								</div>
							</div>
				</div>

						</li>
						<li><span class="dis">用户名：</span><input class="input"
							type="text" onblur="userNameJy()" name="unickname" id="userName"
							maxlength="24" tabindex="1" autocomplete="off">  </li>
						<li><span class="dis">密码：</span><input class="input"
							type="password" name="upassword" id="password" maxlength="24"
							tabindex="1" autocomplete="off">  </li>
						<li class="btn"><input type="submit" class="radius1"
							value="立即登录" ></li>
					</ul>
				</div>
			</div>
		</form>
	</div>


	</div>
	
<!--网站底部-->
 <jsp:include page="bottom.jsp"></jsp:include>
 </body>

</html>
