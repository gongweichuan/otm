<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../inc/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='<c:url value="/otm/createmessage.do"/>' method="post">
	<!-- 温馨提示的div -->
	<div>
	
	</div>
	<!-- 留言内容的div -->
	<div>
	
	</div>
	<!-- 留言设置的div -->
	<div>
	
	</div>
	<!-- AD的div -->
	<div>
	
	</div>
</form>
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