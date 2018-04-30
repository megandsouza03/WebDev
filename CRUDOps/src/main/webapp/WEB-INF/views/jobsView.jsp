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
<title>Jobs - Dasboard</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<fieldset>
<legend><img src="https://www.northeastern.edu/guidelines/images/page/AltLogo_S_bR.png"></legend>
<a href="${contextPath}/user/coop/profile.htm"" class="w3-button w3-black">PROFILE</a>
<a href="${contextPath}/user/coop/jobs.htm"" class="w3-button w3-black">JOBS</a>
<a href="${contextPath}/user/coop/applications.htm"" class="w3-button w3-black">APPLICATIONS</a>
<a href="${contextPath}/user/coop/students.htm"" class="w3-button w3-black">STUDENTS</a>
<a href="${contextPath}/user/coop/stats.htm"" class="w3-button w3-black">STATISTICS</a>
<a href="${contextPath}/user/coop/logout.htm"" class="w3-button w3-black">Logout</a>

<br/> <br/> <br/>

<a href="${contextPath}/user/coop/jobs/create.htm"" class="w3-button w3-black">Create Job</a>

<c:set var="jobList" value="${requestScope.map.jobList}" />
<form action="${contextPath}/user/coop/delete.htm" method="POST">
 <table >
 <tr>
  <th></th>
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
 
    <td> <input type="checkbox" name="jobID" value="${j.ID}"> </td>
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
 <br/>
 <h6>
 <input type="submit" value="Delete" name="Delete"/></h6>
 
 </form>     
</fieldset>
</body>
</html>