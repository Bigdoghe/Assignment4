<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout finish</title>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<body>
<center>
     <h1>Your Order Was successful </h1>
     To Buy again <a href="home.jsp">click here</a>
          Redirecting to home page after 5 seconds
     <% response.setHeader("Refresh", "5;url=home.jsp"); %>
</center>
</body>
</html>