<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  padding: 1em 1.5em;
  text-decoration: none;
font-size: 14px;
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
<title>Register Student</title>
</head>
<body>
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />

	

	
	<div class="container">
	<form:form action="${contextPath}/user/register1" commandName="user"
		method="post">
<fieldset>
<legend><h2>Registration Student</h2></legend>
<!-- Select Role
 <select name="role1" id="role1" >
  <option value="student">Student</option>
  <option value="coopFaculty">Coop Faculty</option>
</select>  -->
	
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="fName" size="30" name = "fName" required="required" />
					<font color="red"><form:errors path="fName" /></font></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="lName" size="30" name = "lsName" required="required" />
					<font color="red"><form:errors path="lName" /></font></td>
			</tr>


			<tr>
				<td>User Name:</td>
				<td><form:input path="userName" name = "uName" size="30" required="required" />
					<font color="red"><form:errors path="userName" /></font></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="30"
						name ="password" required="required" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>
			
			<tr>
				<td>Email:</td>
				<td><form:input name = "email" path="email" size="30"
						required="required" /> <font color="red"><form:errors
							path="email" /></font></td>
			</tr>
			
			<tr>
				<td>Mobile:</td>
				<td><form:input name = "mobile" path="mobile" size="30"
						required="required" /> <font color="red"><form:errors
							path="mobile" /></font></td>
			</tr>
			
		</table>	
<div id='student'>
		<table>
			<tr>
				<td>Course:</td>
				<td><form:select path="courseName">
            <form:option value="0" label="Engineering Management" />
            <form:option value="1" label="Information Systems" />
            <font color="red"><form:errors path="courseName" /></font>
			</form:select>
			
			</td>
			</tr>
			
				<tr>
				<td>Car Availability:</td>
				<td>
				<form:radiobutton path="carAvail" value="Yes" label="Yes" /> 
            <form:radiobutton path="carAvail" value="No" label="No" />
				<font color="red"><form:errors path="carAvail" /></font>
							</td>
			</tr>

			
						<tr>
				<td>Linkedin URL:</td>
				<td><form:input name = "linkedinUrl" path="linkedinUrl" size="30"
						required="required" /> <font color="red"><form:errors
							path="linkedinUrl" /></font></td>
			</tr>
			
									<tr>
				<td>Skype ID:</td>
				<td><form:input name = "skypeID" path="skypeID" size="30"
						required="required" /> <font color="red"><form:errors
							path="skypeID" /></font></td>
			</tr>
</table>
			</div>
<table>
		<%-- 	<tr>
				<td>Email Id:</td>
				<td><form:input path="email.emailAddress" size="30"
						type="email" required="required" /> <font color="red"><form:errors
							path="email.emailAddress" /></font></td>
			</tr> --%>
	<tr>
				<td colspan="2"><input type="submit" value="Register Student" /> <a href="${contextPath}" >Go Back</a><br/></td>
				
			</tr>
			
		</table>
		</fieldset>
	</form:form>
	</div>





</body>
</html>