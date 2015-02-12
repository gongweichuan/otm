<%--在所有的jsp最前面含该文件，所以该文件只能放所有jsp都需要的东西，但不应放置javascript、css，避免破坏html的文档结构 --%>

<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="java.text.*"%>

<%
response.addHeader("pragma", "no-store,no-cache");//HTTP 1.0
response.addHeader("cache-control", "no-cache, no-store,must-revalidate, max-age=-1"); // HTTP 1.1
response.addHeader("expires", "-1");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%
String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
request.setAttribute("currentDate",currentDate);

String ctx = request.getContextPath();

String scheme = "https";
String pauiCtx = scheme + "://" + ("ui.address.domain.name");
String version = "1.0.0";//("static.content.version")
%>
