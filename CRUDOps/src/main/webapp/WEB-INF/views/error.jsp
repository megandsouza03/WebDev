<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style >input[type=submit]  {
    background-color: #4CAF50;
  color: white;
  padding: 1em 1.5em;
  text-decoration: none;
font-size: 14px;
}</style>
<title>Error Page</title>
</head>
<body>

<h1>Error Page</h1>
<p>${errorMessage}</p>
<form action="${contextPath}" method="post">
<input type='submit' value="Go Back">
</form>
<img alt="" src="https://kuwaitlifestyleblog.files.wordpress.com/2016/07/windows_bug6-100581894-primary-idge.jpg"/s>

</body>
</html>