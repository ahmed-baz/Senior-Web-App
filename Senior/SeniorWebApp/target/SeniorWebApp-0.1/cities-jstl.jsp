<%-- 
    Document   : cities-jstl
    Created on : Feb 26, 2020, 8:04:27 PM
    Author     : Senior Steps
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String javaString = "JAVA";
	request.setAttribute("javaString", javaString);
%>
<c:set var="test" value="${requestScope.javaString}" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:out value="${test}"/>
    </body>
</html>
