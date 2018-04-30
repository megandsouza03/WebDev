<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile-Faculty</title>
</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<body>

 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<fieldset>
<legend><img src="https://www.northeastern.edu/guidelines/images/page/AltLogo_S_bR.png"></legend>
<a href="${contextPath}/user/coop/profile.htm"" class="w3-button w3-black">Profile</a>
<a href="${contextPath}/user/coop/jobs.htm"" class="w3-button w3-black">JOBS</a>
<a href="${contextPath}/user/coop/applications.htm"" class="w3-button w3-black">APPLICATIONS</a>
<a href="${contextPath}/user/coop/students.htm"" class="w3-button w3-black">STUDENTS</a>
<a href="${contextPath}/user/coop/stats.htm"" class="w3-button w3-black">STATISTICS</a>
<a href="${contextPath}/user/coop/logout.htm" class="w3-button w3-black">Logout</a>

<div id ="pageInfo">
<br/><br/>
<table >
<tr>
<th>UserId</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Mobile</th>
</tr>
<tr>
<c:set var="cp" value="${requestScope.coop}"/>
<td>${cp.id}</td>
<td>${cp.fName}</td>
<td>${cp.lName}</td>
<td>${cp.email}</td>
<td>${cp.mobile}</td>
</tr>

</table>

</fieldset>
</body>
</html>