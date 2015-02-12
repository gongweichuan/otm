<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="../inc/common.jsp"%>

<%@page import="java.util.ResourceBundle"%>
<%@page import="com.cvo.erp.pfl.gwc.net.cn.g.etc.PropertiesConfiger"%>

<% 
    String publickey=PropertiesConfiger.get("w.loginsafe.rsa.soft.publickey");   
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<c:import charEncoding="UTF-8" url="/inc/css.jsp"></c:import>
</head>
<body>
<div id="wrapper">
	<!-- header 头部
	<div id="wrapper-header">
			<ul>
				<li>inside header</li>
			</ul>
	</div> -->
	<!-- End header 头部-->
	<c:import charEncoding="UTF-8" url="/inc/header-inside.jsp"></c:import>
		
	<!-- 注册 功能-->	
	<div id="main">
		<form action='<c:url value="/portal/register.do" />' id="myForm" method="post">
		<table width="100%" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th colspan="2">
						<h2>用户注册</h2>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td width="30%" align="right">用户名：</td>
					<td width="70%">
					<input type="text" id="username" name="username" autocomplete="off" class="input" 
					vld="{required:true,rangelength:[3,20],username:true,remote:'<c:url value="/portal/usernameUnique.do" />',messages:{remote:'用户名已存在！'}}"/>
					</td>
				</tr>
				<tr>
					<td align="right">密　码：</td>
					<td>&nbsp;<input type="password" name="password" id="password" class="input required"/></td>
				</tr>
				<tr>
					<td align="right">确认密码：</td>
					<td>&nbsp;<input type="password"  equalto="#password" class="input"/></td>
				</tr>
				<tr>
					<td align="right">E-mail：</td>
					<td>&nbsp;<input type="text" name="email" vld="{remote:'<c:url value="/portal/emailUnique.do" />',messages:{remote:'email已经被使用！'}}" class="input required email" /></td>
				</tr>
				<tr>
					<td align="right">验证码：</td>
					<td>&nbsp;<input type="text" name="captcha" id="captcha"  vld="{required:true}"/>
						&nbsp;<img src='<c:url value="/portal/image.jsp" />' onclick="this.src='<c:url value="/portal/image.jsp" />?t='+new date()"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="同意以下协议并提交" name="submit" class="btn"/>
					</td>					
				</tr>
				<tr>
					<td colspan="2" align="center">
						<textarea rows="10" cols="180" readonly="readonly">注册协议
						注册协议
						注册协议
						注册协议
						注册协议
						注册协议
						注册协议
						</textarea>
						<input type="hidden" name="encPassword4RSA" id="encPaswordd4RSA"/>
						<input type="hidden" name="encPassword4MD5" id="encPasword4MD5"/>
					</td>					
				</tr>
			</tbody>		
		</table>		
		</form>
	</div>

	<!-- footer 底部
	<div id="wrapper-footer">
			<ul>
				<li>inside footer</li>
			</ul>
	</div>-->
	<c:import charEncoding="UTF-8" url="/inc/footer-inside.jsp"></c:import>
</div>
</body>
<c:import charEncoding="UTF-8" url="/inc/ui.jsp"></c:import>

<script language="javascript" type="text/javascript">
//判断jquery引入是否成功？
if (typeof jQuery == 'undefined')
{
	alert(typeof jQuery == 'undefined');
	alert($);
	document.write("<script src=http:\/\/ajax.googleapis.com\/ajax\/libs\/jquery\/1.4.2\/jquery.min.js><\/script>");
}

//保持会话
function keepsession()
{
	$.post("/portal/keepSession.do?minute=10&interval=5",{},function(data){},"json");
	setTimeout("keepsession()",1000*60*5);
}
keepsession();

//用rsa加密的
function rsaChg()
{
    var PublicKey ='<%=publickey%>';
    var pwd=$("#password").val();
    var RSA = new RSAKey();
    RSA.setPublic(PublicKey, "10001");
    var Res = RSA.encrypt(pwd);
    $("#encPassword4RSA").val(Res);
    pwd=$("#password").val("******");
}

//用MD5加密的
function md5Chg()
{
   
    var hash = MD5($("#password").value);    
    $("#encPassword4MD5").val(hash);
    pwd=$("#password").val("******");
}

//form 校验
$(document).ready(
	function(){
			rsaChg();
			md5Chg();
			$("myForm").validate();
	);		
});

</script>
</html>