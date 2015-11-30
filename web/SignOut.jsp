<%--
    Document   : register
    Created on : Apr 26, 2014, 2:08:22 AM
    Author     : COLLEGE PROJECT
--%>


<%@page import="java.text.*" import=" java.util.*"  import="com.mongodb.*" import="org.bson.Document" language="java"%>
<%
session.invalidate();
response.sendRedirect("index.html?err=You have been signed out of the application");
%>
<%-- 
    Document   : SignOut
    Created on : Nov 28, 2015, 9:22:19 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
