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
<title>JobView - Students</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.button {
 background-color: #4CAF50;
}
</style>
</head>
<body>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<fieldset>
<legend><img src="https://www.northeastern.edu/guidelines/images/page/AltLogo_S_bR.png"></legend>
<a href="${contextPath}/user/student/profile.htm" class="w3-button w3-black">Profile</a>
<a href="${contextPath}/user/student/jobs.htm" class="w3-button w3-black">View Jobs</a>
<a href="${contextPath}/user/student/applications.htm" class="w3-button w3-black">Applications</a>
<a href="${contextPath}/user/student/logout.htm" class="w3-button w3-black">Logout</a>



<form action="${contextPath}/user/student/Apply.htm" method="POST">
 <table >
 <tr>
  <th>Select</th>
  <th>ID</th>
  <th>Company Name</th>
  <th>Title</th>
  <th>Openings</th>
  <th>Length</th>
  <th>City</th>
  <th>Country</th>
  <th>Description</th>
  <th>Wage Type</th>
  <th>Minimum Wage</th>
  <th>Maximum Wage</th>
 </tr>
  <c:forEach items="${requestScope.map.jobList}" var="j">
 <tr>
 <c:if test = "${requestScope.map.student.coopFaculty == null}">
 <td><button disabled class="button" type="submit" name ="jobSelected" value='${j.ID}'>Apply</button></td>
 </c:if>
<%--  <c:forEach items="${requestScope.map.application}" var="a">
  <c:if test = "${a.job.ID} == ${j.ID} ">
 <td><button disabled class="button" type="submit" name ="jobSelected" value='${j.ID}'>Apply</button></td>
 </c:if>
 </c:forEach> --%>
 <c:if test = "${requestScope.map.student.coopFaculty != null}">
 <td><button  class="button" type="submit" name ="jobSelected" value='${j.ID}'>Apply</button></td>
 </c:if>

 <td>${j.ID}</td>
  <td>${j.companyName}</td>
   <td>${j.title}</td>
    <td>${j.openings}</td>
     <td>${j.length}</td>
      <td>${j.city}</td>
       <td>${j.country}</td>
        <td>${j.description}</td>
         <td>${j.wageType}</td>
          <td>${j.minWage}</td>
           <td>${j.maxWage}</td>
           
           
      
 </tr>
 </c:forEach>
 </table>

</fieldset>
</body>
</html>