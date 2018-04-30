<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Applications - Coop</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.button {
 background-color: #4CAF50;
}
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

<body>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<fieldset>
<legend><img src="https://www.northeastern.edu/guidelines/images/page/AltLogo_S_bR.png"></legend>
<a href="${contextPath}/user/coop/profile.htm"" class="w3-button w3-black">PROFILE</a>
<a href="${contextPath}/user/coop/jobs.htm"" class="w3-button w3-black">JOBS</a>
<a href="${contextPath}/user/coop/applications.htm" class="w3-button w3-black">APPLICATIONS</a>
<a href="${contextPath}/user/coop/students.htm"" class="w3-button w3-black">STUDENTS</a>
<a href="${contextPath}/user/coop/stats.htm"" class="w3-button w3-black">STATISTICS</a>
<a href="${contextPath}/user/coop/logout.htm"" class="w3-button w3-black">Logout</a>
<br/>
<h3><em><b><u>All Applications</u></b></em></h3>
</fieldset>



<div id="appInfo">
<form action="${contextPath}/user/student/viewPDF.htm" method="POST">
<table >
 <tr>

  <th>ID</th>
  <th>Company Name</th>
  <th>Title</th>
  <th>Description</th>
  <th>Technical Skills</th>
  <th>Work Experience</th>
  <th>Current University</th>
  <th>Student Name</th>
  <th>View PDF</th>
</tr>
<c:forEach items="${requestScope.map.aList}" var="a">
<tr>
<td>${a.appId}</td>
<td>${a.job.companyName}</td>
<td>${a.job.title}</td>
<td>${a.job.description}</td>
<td>${a.technicalSkills}</td>
<td>${a.workExperience}</td>
<td>${a.currentUniversity}</td>
<td>${a.student.fName}</td>
<td><button class="button" type="submit" name ="viewPDF" value='${a.appId}'>View PDF</button></td>
</tr>
</c:forEach>
</table>
</form>
</div>
</body>
</head>
<body>

</body>
</html>