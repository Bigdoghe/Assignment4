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
					   <form action = "ProductController" method = "post">
					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getProductname()%></td>
						<td><%=p.getPrice()%></td>
						<td><%=p.getDescription()%></td>
						<td>
						<input type="submit" value="delete" name="delete"/>
						
						</td>
					
					</tr>
					<input type="hidden" value="<%=p.getId()%>" name="deletenum"/>
					
						</form>
					<%
						}
					%>
					<tbody>
      
			</table> 
			<a href="addproduct.jsp" class="btn btn-default">Add Product</a>
			
			<form action ="ProductController", method = post>
			<table align="center" cellpadding="10">
			<tr>
				<td>productid you want to update</td>
				<td><input type="text" name="productid" maxlength="100" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" name = "idupdate"
					value="Updateproduct"> 
				</td>
			</tr>
		    </table>
			
			
			</form>
         
         
         <br /></div>

				
    </center>
</body>
</html>