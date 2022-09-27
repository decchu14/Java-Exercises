<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DISPLAY SESSIONS AND COOKIES</title>
</head>
<body>
<%
out.println("DSIPLAYING SESSION DETAILS"+"<br>");
 
String fname=session.getAttribute("fname").toString();
String lname=session.getAttribute("lname").toString(); 

out.println("SESSION ID :" + session.getId()+"<br>");
out.println("FIRST NAME : "+fname+"<br>");
out.println("LAST NAME : "+lname+"<br>");

out.println("DISPLAYING COOKIE DETAILS <br>");


Cookie cookie=null;
Cookie cookies[]=null;
cookies=request.getCookies();
if(cookies!=null)
{
	out.println("cookiess found");
	for(int i=0;i<cookies.length;i++)
	{
		cookie = cookies[i];
		out.println("COOKIE NAME : "+cookie.getName()+"<br>");
		out.println("COOKIE VALUE : "+cookie.getValue()+"<br>");
	}
}
else
{
	out.println("cookiess not found");
}
%>

</body>
</html>