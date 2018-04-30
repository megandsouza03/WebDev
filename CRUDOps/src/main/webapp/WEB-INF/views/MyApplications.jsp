<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>My Applications</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<fieldset>
<legend><img src="https://www.northeastern.edu/guidelines/images/page/AltLogo_S_bR.png"></legend>
<a href="${contextPath}/user/student/profile.htm" class="w3-button w3-black">Profile</a>
<a href="${contextPath}/user/student/jobs.htm"" class="w3-button w3-black">View Jobs</a>
<a href="${contextPath}/user/student/applications.htm" class="w3-button w3-black">Applications</a>
<a href="${contextPath}/user/student/logout.htm" class="w3-button w3-black">Logout</a>

<div>
<c:set var="appList" value="${requestScope.applications}" />
<form action="${contextPath}/user/student/delete.htm" method="GET">
<table >
 <tr>
	<th></th>
  <th>ID</th>
  <th>Company Name</th>
  <th>Title</th>
  <th>Description</th>
  <th>Technical Skills</th>
  <th>Work Experience</th>
  <th>Current University</th>
  
</tr>
<c:forEach items="${requestScope.applications}" var="a">
<tr>
 <td> <input type="checkbox" name="appID" value="${a.appId}"> </td>
<td>${a.appId}</td>
<td>${a.job.companyName}</td>
<td>${a.job.title}</td>
<td>${a.job.description}</td>
<td>${a.technicalSkills}</td>
<td>${a.workExperience}</td>
<td>${a.currentUniversity}</td>

<td></td>
</tr>
</c:forEach>
</table>
 <br/>
 <h6>
 <input type="submit" value="Delete" name="Delete"/></h6>
</form>
</div>
</fieldset>
</body>
</html>