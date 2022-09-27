<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Session</title>
</head>
<body>
<%
Date createtime = new Date(session.getCreationTime());
Date lasttime = new Date(session.getLastAccessedTime());

String fname = request.getParameter("fname");
String lname = request.getParameter("lname");

session.setAttribute("fname",fname);
session.setAttribute("lname",lname);

out.println("SESSION CREATION TIME : "+createtime+"<br>");
out.println("SESSION LAST ACCESS TIME : "+lasttime+"<br>");
out.println("session values has been set <br>");

Cookie first = new Cookie("fname",fname);
first.setMaxAge(60);
response.addCookie(first);
out.println("Cookie values added successfully <br>");
%>
<br><a href="display.jsp">DISPLAY SESSION & COOKIE IVALUES</a>
</body>
</html>