<%@ page session="false" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
a {
    background-color: #4CAF50;
  color: white;
  padding: 1em 1.5em;
  text-decoration: none;
font-size: 14px;
}
input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
</style>
	<title>Home</title>
</head>
<body>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <c:set var="contextPath" value="${pageContext.request.contextPath}" />


<form action="${contextPath}/user/login.htm" method="POST">
 <fieldset>
 <legend><img src="https://www.northeastern.edu/guidelines/images/page/AltLogo_S_bR.png"></legend>
<h3>User Name <input type="text" name="userName"/>
<h3>Password <input type="password" name="password"/>
<br/>
<br/>
<input  type="submit" name="Submit" value="submit"/>
<br/>
 </h3>
 <h8><a href="${contextPath}/user/createStudent.htm">Register here (Student)</a> </h8>
 <h8><a href="${contextPath}/user/createCoop.htm">Register here (Coop Faculty)</a> </h8>
 <br><br>
 </h3>
 </fieldset>
  </form>
</body>
</html>
