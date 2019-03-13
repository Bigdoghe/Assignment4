<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
     <link rel="stylesheet" type="text/css" href="css/style.css">
     <title>logout Page</title>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>

</head>
<body>
     <%     
         session.removeAttribute("username");
         session.removeAttribute("password");
         session.invalidate(); 
         
     %>
<center>
     <h1>You have successfully logged out</h1>
     To login again <a href="login.jsp">click here</a>
     Redirecting to login page after 5 seconds
     <% response.setHeader("Refresh", "5;url=login.jsp"); %>
     
</center>
</body>
</html>