<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/base.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>p2p网贷登陆</title>
    <%--<link rel="stylesheet" href="https://res.wx.qq.com/connect/zh_CN/htmledition/style/impowerApp3696b4.css">--%>
</head>
<body>
<div>
    <div class="loginPanel normalPanel">
        <div class="title">微信登录</div>
        <div class="waiting panelContent">
            <div class="wrp_code"><img class="qrcode lightBorder" src="${ctx}/users/code/${uuid}" /></div>
            <div class="info">
                <div  id="wx_default_tip">
                    <p id="msg">请使用微信扫描二维码登录</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


<script type="text/javascript" src="${ctx}/Jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
    $(function(){
        // 向服务器发起开启轮询验证通知， 第一波验证二维码被扫状态
        $.ajax({
            url:"${ctx}/users/validate",
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
                        url:"${ctx}/users/validate",
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
                                    window.location.href ="${ctx}/notice/query";
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
</html>