<%@page import="com.cvo.erp.pfl.gwc.net.cn.g.etc.PropertiesConfiger"%>
<%@ page import="java.io.PrintWriter;"%>
<%
    String checkcode = request.getParameter("validCode");
    String sRand = (String) request.getSession().getAttribute("LOGIN_VERIFICATION_CODE");
    PrintWriter pw = response.getWriter();

    String isCodeCheck=PropertiesConfiger.get("login.codecheck.enable");
    if(isCodeCheck==null||isCodeCheck.equals("0")){//不检查验证码
        pw.print("true");
        return;
    }
    if (checkcode.equals(sRand)){
        pw.print("true");
    }else{
        pw.print("false");
    }
%>