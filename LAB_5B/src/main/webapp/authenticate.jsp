<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error1.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username = request.getParameter("u");
    String password = request.getParameter("p");
    int age = Integer.parseInt(request.getParameter("age"));
    
    if(username.isBlank() || password.isBlank())
    {
    	throw new Exception("Please fill all the fields");
    }
    else if(age>=18 && age<=50)
    	out.println("Eligible");
    else 
    	out.println("Not Eligible");

%>

</body>
</html>