<%
String ctx = request.getContextPath();
String version4js = "1.0.0";
%>
<script language="javascript" type="text/javascript" src="<%=ctx%>/js/footer.js?v=<%=version4js%>"></script>
<script language="javascript" type="text/javascript" src="<%=ctx%>/js/jquery-1.9.1.js?v=<%=version4js%>"></script>
<script language="javascript" type="text/javascript" src="<%=ctx%>/js/jquery-ui-1.10.3.custom.js?v=<%=version4js%>"></script>
<%//RSA的js %>
<script language="javascript" type="text/javascript" src="<%=ctx%>/js/unionrsa.js?v=<%=version4js%>"></script>
<%//md5的js %>
<script language="javascript" type="text/javascript" src="<%=ctx%>/js/md5.js?v=<%=version4js%>"></script>
<script>
	//document.domain="";在存在js跨域的时候使用
</script>