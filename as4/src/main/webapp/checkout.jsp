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
				<th>Price Total</th>
				<th>Remove item</th>
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
				<td><%=session.getAttribute("quantity" + i)%></td>
				<td><%=session.getAttribute("pricetotal" + i)%></td>
				<td>
                    <form action = "CheckoutController", method = "POST">


						<input type="hidden" name="RemoveId" value="<%=i%>" /> <input
							type="hidden" name="Removepricetotal"
							value="<%=session.getAttribute("pricetotal" + i)%>" /> <input
							type="hidden" name="totalmoney"
							value="<%=session.getAttribute("total")%>" /> 

                        <input type="submit" value="Remove" name="<%="remove"+ i%>"/>
					
							
							</form>
				</td>
			</tr>
			<%
				i++;
				}
			%>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><%=session.getAttribute("total")%></td>
			

					
				
			</tr>

		</tbody>
	</table>
<form action = "CheckoutController", method = "POST">
	

	<%
				ProductService productservice0 = new ProductService();
				List<Product> list0 = productservice.getListOfProducts();
				int j = 0;
				for (Product p : list) {
	%>
	<input
							type="hidden" name="<%="quantitycheck"+ j%>"
							value="<%=session.getAttribute("quantity" + j)%>" /> <input
							type="hidden" name="<%="productid"+j%>" value="<%=p.getId()%>" /> 
	<%
				j++;
				}
			
	%>
	
	
	   <input
							type="hidden" name="length" value="<%=i%>" />
					<input
							type="submit" value="Checkout" name="checkout" >
	</form>

</body>
</html>