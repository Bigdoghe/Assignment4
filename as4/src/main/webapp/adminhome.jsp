<%@page import="java.util.List"%>
<%@page import="com.hxy.services.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.hxy.model.AdminUser"%>
<%@page import="com.hxy.model.Product"%>
<%@page import="com.hxy.model.Order"%>
<%@page import="com.hxy.services.ProductService"%>
<%@page import="com.hxy.services.CheckoutService"%>
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
			</form>
		    </table>
			
			
		<table >
				<thead>
					<tr>
						<th>Order ID</th>
						<th>Product id</th>
						<th>Product name</th>
						<th>Quantity</th>
						<th>Ordername</th>
						
					</tr>
				</thead>
				<tbody>
					<%
					    CheckoutService orderservice = new CheckoutService();
						ProductService productservicename = new ProductService();
						List<Order> listnew = orderservice.getListOfOrders();
						Product productname = new Product();
						int idtemp = 0;
						for (Order o: listnew) {
					%>
					   
					<tr>
						<td><%=o.getId()%></td>
						<td><%=o.getProductid()%></td>
						<%
						idtemp = o.getProductid();
						productname =  productservicename.getProductByProductId(idtemp);
						%>
						<td><%= productname.getProductname()  %></td>
						<td><%=o.getQuantity()%></td>
						<td><%=o.getUsername()%></td>
					
					
					</tr>
		
					<%
						}
					%>
					<tbody>
      
			</table> 
         
         
         <br /></div>

				
    </center>
</body>
</html>