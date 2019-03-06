<%@page import="java.util.List"%>
<%@page import="com.hxy.services.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.hxy.model.User"%>
<%@page import="com.hxy.model.Product"%>
<%@page import="com.hxy.services.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check out</title>
</head>
<body>
<table>
				<thead>
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Product Price</th>
						<th>Product Description</th>
						<th>Quantity</th>
						<th>Check box</th>
						<th>Price Total</th>
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
						<td><%= (Product) session.getAttribute("quantity"+i)%>
						</td>
					</tr>
					<%
						}
					%>
					<tbody>
</body>
</html>