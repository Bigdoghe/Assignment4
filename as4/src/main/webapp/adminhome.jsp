<%@page import="java.util.List"%>
<%@page import="com.hxy.services.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.hxy.model.AdminUser"%>
<%@page import="com.hxy.model.Product"%>
<%@page import="com.hxy.services.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Result Page</title>
</head>
<body>
	<center>
		<div id="container">
			<h1>Welcoming Page</h1>
			<b>This is product list</b><br />
			<%=new Date()%></br>
			<%
				AdminUser user = (AdminUser) session.getAttribute("user");
			%>
			<b>Welcome <%=user.getUsername()%></b> <br /> <a href="logout.jsp">Logout</a>

       <form action = "ProductController" method = "post">
			<table >
				<thead>
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Product Price</th>
						<th>Product Description</th>
						<th>Delete Product</th>
					</tr>
				</thead>
				<tbody>
					<%
						ProductService productservice = new ProductService();
						List<Product> list = productservice.getListOfProducts();
						int i = 0;
						for (Product p : list) {
					%>
					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getProductname()%></td>
						<td><%=p.getPrice()%></td>
						<td><%=p.getDescription()%></td>
						<td><a href="product.jsp" class="btn btn-default">Delete Product</a></td>
					
					</tr>
					<%
						}
					%>
					<tbody>
      
			</table> 
			<a href="addproduct.jsp" class="btn btn-default">Add Product</a>
			
		</form>
         
         
         <br /></div>

				
    </center>
</body>
</html>