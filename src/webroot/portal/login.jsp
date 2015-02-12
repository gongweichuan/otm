<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="../inc/common.jsp"%>

<%@page import="java.util.ResourceBundle"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<c:import charEncoding="UTF-8" url="/inc/css.jsp"></c:import>
</head>
<body>
<!-- 登陆 -->	
<div>
	<div>
		<ul>
			<li>
				<h1>xx登录 注册</h1>
			</li>
			<li> xxAD</li> 			
		</ul>
	</div>
	<!-- form -->
	<div>
		<form  id="regform" method="post" name="regform" action='<c:url value="/portal/addRegister.do"/>'>
		<dl>
			<dt>请输入</dt>
			<dd>id</dd>
			<dd><input id="regID" name="regID" type="text"/> </dd>
			<dd>name</dd>
			<dd><input id="regName" name="regName" type="password"/> </dd>
			
			<dt>验证码</dt>
			<dd>请输入验证码</dd>
			<dd><input id="regCode" name="regCode" type="text"/> </dd>
			<dd><img alt="验证码" src='<c:url value="/portal/image.jsp"/>'/></dd>
		</dl>
		<dl>
			<dt></dt>
			<dd>
				<input id="regSubmit" name="regSubmit"  type="submit" />
			</dd>
		</dl>
		</form>
	</div>
</div>	
	
	<div>
		<div>
			<h2>======================================================</h2>
		</div>
		<div>
			<table>
				<tr>
					<td>index</td>
					<td>id</td>
					<td>name</td>
				<tr>
				<c:if test="${not empty command}">
					<c:forEach var="out" items="${command}" varStatus="outindex" >
						<tr>
							<td><c:out value="${outindex.index}"></c:out></td>
							<td><c:out value="${out.id }"></c:out></td>
							<td><c:out value="${out.name }"></c:out></td>
						<tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty command}">
					<tr>
						<td colspan="3">无记录</td>					
					<tr>
				
				</c:if>
			</table>
		
		</div>
	
	</div>
	
	
<!-- Datepicker -->
<h2 class="demoHeaders">Datepicker</h2>

<div id="datepicker"></div>

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

$(document).ready(
	function(){
			$("#datepicker").datepicker(
			{
				inline:true
			}				
	);
		
});

</script>
</html>