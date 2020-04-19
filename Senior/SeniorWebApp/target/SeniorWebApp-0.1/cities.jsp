<%-- 
    Document   : cities
    Created on : Feb 12, 2020, 9:01:38 PM
    Author     : Senior Steps
--%>

<%@page import="net.seniorsteps.senior.web.AuthManager"%>
<%@page import="net.seniorsteps.senior.common.bean.CityBean"%>
<%@page import="java.util.List"%>
<%@page import="net.seniorsteps.bll.SeniorBLGateway"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
	// declaration tag
	private final SeniorBLGateway seniorBLGateway = new SeniorBLGateway();
	private final AuthManager authManager = new AuthManager();
%>
<%
	if (!authManager.isAuthorized(request)) {
		response.sendRedirect("login.jsp");
	}
	//Scriptlet tag ..... processRequest(request, response)
	List<CityBean> findCities = seniorBLGateway.findCities();
	String message = "Test some data";
	String status = request.getParameter("s");
	if (status != null) {
		if ("true".equals(status)) {
			message = "Added Successfully";
		} else {
			message = "Error in Adding";
		}
	}
	request.setAttribute("findCities", findCities);
	request.setAttribute("msg",message);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
		<p><c:out value="${msg}" /></p>
		<table border=1>
			<tr>
				<th>ID</th>
				<th>Name (AR)</th>
				<th>Name (EN)</th>
				<th colspan="3">Actions</th>
			</tr>
			<c:forEach items="${findCities}" var="iCity">
				<tr>
					<td><c:out value="${iCity.id}" /></td>
					<td><c:out value="${iCity.nameAr}" /></td>
					<td><c:out value="${iCity.nameEn}" /></td>
					<td><a href="viewCity.jsp?id=<c:out value="${iCity.id}" />">View</a></td>
					<td><a href="editCity.jsp?id=<c:out value="${iCity.id}" />">Edit</a></td>
					<td><a href="deleteCity?id=<c:out value="${iCity.id}" />" 
						   onclick="if (confirm('Are you sure?')) {
									   return true
								   } else {
									   return false
								   }"> Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href='newCity.html'>Add New City</a>
		<c:remove var="findCities"/>
    </body>
</html>
