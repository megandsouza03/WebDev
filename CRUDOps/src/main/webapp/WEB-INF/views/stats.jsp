<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style >
div {
	color: #4CAF50;
    text-indent: 50px;
    text-align: justify;
    letter-spacing: 3px;
     font-style: oblique;
}</style>
<script>
    function ajaxEvent() {

        var xmlHttp;
        try // Firefox, Opera 8.0+, Safari
        {	//alert("2");
            xmlHttp = new XMLHttpRequest();
        } catch (e) {
            try // Internet Explorer
            {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    alert("Your browser does not support AJAX!");
                    return false;
                }
            }
        }
        var queryString = document.getElementById("search").value;
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4) {
            	//alert("1");
                document.getElementById("pageInfo").innerHTML = "Number of "+queryString+" "+xmlHttp.responseText;
            }
        }
        
        
      //  alert(queryString);
      //  xmlHttp.setContentType("application/json");
        xmlHttp.open("POST", "../ajaxservice.htm?search="+queryString, true);
        xmlHttp.send();
    }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<a href="${contextPath}/user/coop/profile.htm"" class="w3-button w3-black">PROFILE</a>
<a href="${contextPath}/user/coop/jobs.htm"" class="w3-button w3-black">JOBS</a>
<a href="${contextPath}/user/coop/applications.htm" class="w3-button w3-black">APPLICATIONS</a>
<a href="${contextPath}/user/coop/students.htm"" class="w3-button w3-black">STUDENTS</a>
<a href="${contextPath}/user/coop/logout.htm"" class="w3-button w3-black">STATISTICS</a>
<a href="${contextPath}/user/coop/logout.htm"" class="w3-button w3-black">Logout</a>
<br/><select id="search">
    <option value="Applications">Applications</option>
    <option value="Students">Students</option>
    <option value="Jobs">Jobs</option>
    <option value="Faculty">Faculty</option>
  <!--   <option value="saab">Saab</option>
    <option value="fiat">Fiat</option>
    <option value="audi">Audi</option> -->
  </select>
  <br><br>
  <button type="submit" onclick="ajaxEvent()">Submit</button>

<h4></h4><div id ="pageInfo">

</div></h4>
</fieldset>
</body>
</html>