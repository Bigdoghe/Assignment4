<html>
<head>
<title>Add product Form</title>
<style type="text/css">
h3 {
	font-family: Calibri;
	font-size: 22pt;
	font-style: normal;
	font-weight: bold;
	color: DarkGrey;
	text-align: center;
	text-decoration: underline
}

table {
	font-family: Calibri;
	color: white;
	font-size: 11pt;
	font-style: normal;
	width: 50%;
	text-align:;
	background-color: DarkGrey;
	border-collapse: collapse;
	border: 2px solid navy
}

table.inner {
	border: 0px
}
</style>
</head>
<body>
	<h3>Update Product</h3>
	<form action="ProductController" method="POST">
		<table align="center" cellpadding="10">
			
			<b>You are updating  product number <%=session.getAttribute("productid")%></b>
			<input type ="hidden" name="productid" value="<%= session.getAttribute("productid")%>" >
			<tr>
				<td>productname</td>
				<td><input type="text" name="productname" maxlength="100" /></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="price" maxlength="100" /></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="description" maxlength="100" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name = "update"
					value="updateproduct"> <input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>