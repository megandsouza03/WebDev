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
<title>Students</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<fieldset>
<legend><img src="https://www.northeastern.edu/guidelines/images/page/AltLogo_S_bR.png"></legend>
<a href="${contextPath}/user/coop/profile.htm" class="w3-button w3-black">PROFILE</a>
<a href="${contextPath}/user/coop/jobs.htm" class="w3-button w3-black">JOBS</a>
<a href="${contextPath}/user/coop/applications.htm" class="w3-button w3-black">APPLICATIONS</a>
<a href="${contextPath}/user/coop/students.htm" class="w3-button w3-black">STUDENTS</a>
<a href="${contextPath}/user/coop/stats.htm"" class="w3-button w3-black">Statistics</a>
<a href="${contextPath}/user/coop/logout.htm" class="w3-button w3-black">Logout</a>

<br/> <br/>

<a href="${contextPath}/user/coop/myStudents.htm" class="w3-button w3-black">My Students</a>
<a href="${contextPath}/user/coop/unassignedStudents.htm" class="w3-button w3-black">Unassigned Students</a>
  <c:choose>
    <c:when test="${requestScope.map.msgtype eq 'myStudents'}">
          <h3>My Students</h3>
           <table >
			<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Course Name</th>
			<th>Email</th>
			<th>Mobile</th>
			</tr>
			 <c:forEach items="${requestScope.map.studentList}" var="student">
			 <tr>
			 <td>${student.fName}</td>
			  <td>${student.lName}</td>
			   <td>${student.courseName}</td>
			   <td>${student.email}</td>
			   <td>${student.mobile}
			 </tr>
			
			</c:forEach>
			</table>
        </c:when>
            
    
       <c:when test="${requestScope.map.msgtype eq 'uStudents'}">
			<br/>
			<h3>Unassigned Students</h3>
			<br/>
			 <form action="${contextPath}/user/coop/selectStudent.htm" method="POST">
			<table >
			<tr>
			<th>Select</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Course Name</th>
			<th>Email</th>
			<th>Mobile</th>
			</tr>
			 <c:forEach items="${requestScope.map.studentList}" var="student">
			 <tr>
			 <td> <input type="checkbox" name="studentID" value="${student.id}"/></td>
			 <td>${student.fName}</td>
			  <td>${student.lName}</td>
			   <td>${student.courseName}</td>
			   <td>${student.email}</td>
			   <td>${student.mobile}
			 </tr>
			
			</c:forEach>
			</table>
			 <input type="submit" value="Select" name="Select"/></h6>
			</form>
        </c:when>
        </c:choose>

</fieldset>
</body>
</html>