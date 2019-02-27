<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="z" uri="/zking" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亿人网--合作伙伴</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="<%=basePath%>css/common.css" rel="stylesheet" />
<link href="<%=basePath%>css/about.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>script/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>script/common.js"></script>
</head>
<body>
 <!-- 导航栏 --><jsp:include page="head.jsp"></jsp:include>


<!--关于我们-->
<div class="bg">
  <div class="contain" id="tabs" style="margin:0 auto;">
  
    <!--关于我们--><jsp:include page="my_ue.jsp"></jsp:include>
    
    <div class="text-box">
			<div class="text-content" id="text-content">
				<h1 class="title">合作伙伴</h1>
				<ul class="clearfix partner">
					<c:forEach items="${listss}" var="notice">
					<li class="mt10 partner-item clearfix">
						<a href="" class="logo" style="margin-top:50px">
							<img src="${notice.noticepicture}" style="height: 200px;width: 330px" ><%--style="vertical-align:middle "--%>
						</a>
						<div class="text">
							<h5>				
								${notice.noticetitle }
							</h5>
							<p class="cn_line" style="text-indent:0;">
								${notice.noticecontent }
							</p>
						</div>
					</li>
					</c:forEach>
				</ul>
				<div class="page">
					<div class="page">
						<z:page pageBean="${pageBean }"></z:page>
					</div>
					</div>
				</div>
			</div>
		</div>
  </div>
</div>
<!-- 导航栏 --><jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>