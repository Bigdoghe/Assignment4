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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Result Page</title>
</head>
<body>
	<center>
		<div id="container">
			<h1>Welcoming Page</h1>
			<b>This is the shopping cart</b><br />
			<%=new Date()%></br>
			<%
				User user = (User) session.getAttribute("user");
			%>
			<b>Welcome <%=user.getUsername()%></b> <br /> <a href="logout.jsp">Logout</a>

       <form action = "checkout.jsp" method = "post">
			<table >
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
						<td><SELECT name="<%="quantity"+i%>" tabindex="10">
								<Option value="select">--</option>
								<%
									for (int j = 0; j < 10; j++) {
								%>
								<option value="<%=j%>"><%=j%></option>
								<%
									}
								%>
						</SELECT>	
						</td>
						<td><input type="checkbox" name="<%="checkbox" + i%>">
							<%
								i++;
							%></td>
					</tr>
					<%
						}
					%>
					<tbody>
      
			</table> 
		   <input style="margin-left: 100px;" type="submit"  value="checkout" />
		</form>
         
         
         <br /></div>
				
    </center>
</body>
</html>