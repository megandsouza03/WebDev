<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
a {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Appy here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
<% 
if(session.getAttribute("username").equals(null)){
response.sendRedirect("./home.jsp");
}
%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
 <fieldset>
<legend><img src="https://www.northeastern.edu/guidelines/images/page/AltLogo_S_bR.png"></legend>
<a href="${contextPath}/user/student/profile.htm" class="w3-button w3-black">Profile</a>
<a href="${contextPath}/user/student/jobs.htm" class="w3-button w3-black">View Jobs</a>
<a href="${contextPath}/user/student/applications.htm"" class="w3-button w3-black">Applications</a>
<a href="${contextPath}/user/student/logout.htm"" class="w3-button w3-black">Logout</a>
<h5>Appy Here</h5>
<form:form action="${contextPath}/user/student/submit/application.htm" commandName="application"
		method="post">
		<%-- <c:set var="name" value="JobID" scope="session" /> --%>
		<h5>JobId <c:out value="${sessionScope.JobID}" /></h5>
<table>
			<tr>
				<td>Technical SKill:</td>
				<td><form:textarea path="technicalSkills" size="50" required="required" />
					<font color="red"><form:errors path="technicalSkills" /></font></td>
			</tr>
			
			<tr>
				<td>Work Experience:</td>
				<td><form:textarea path="workExperience" size="100" required="required" />
					<font color="red"><form:errors path="workExperience" /></font></td>
			</tr>
			
			<tr>
				<td>Current University:</td>
				<td><form:input path="currentUniversity" type="" size="30" required="required" />
					<font color="red"><form:errors path="currentUniversity" /></font></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
</table>
</form:form>
</fieldset>
</body>
</html>