<%-- 
    Document   : cities
    Created on : Feb 12, 2020, 9:01:38 PM
    Author     : Senior Steps
--%>

<%@page import="net.seniorsteps.senior.common.bean.CityBean"%>
<%@page import="java.util.List"%>
<%@page import="net.seniorsteps.bll.SeniorBLGateway"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
	// declaration tag
	private final SeniorBLGateway seniorBLGateway = new SeniorBLGateway();
%>
<%
	//Scriptlet tag ..... processRequest(request, response)
	List<CityBean> findCities = seniorBLGateway.findCities();
	String message = "";
	String status = request.getParameter("s");
	if (status != null) {
		if ("true".equals(status)) {
			message = "Added Successfully";
		} else {
			message = "Error in Adding";
		}
	}

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
		<p><%= message%></p>
		<table border=1>
			<tr>
				<th>Name</th>
				<th>ID</th>
			</tr>
			<% for (CityBean iCityBean : findCities) {%>
			<tr>
				<td><%= iCityBean.getName()%></td>
				<td><%= iCityBean.getId()%></td>
				<td>DELETE</td>
			</tr>
			<% }%>
		</table>
		<a href='newCity.html'>Add New City</a>
    </body>
</html>
