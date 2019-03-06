<html>
<head>
<title>Registration Form</title>
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
	<h3>User Registration Form</h3>
	<form action="Register Controller" method="POST">
		<table align="center" cellpadding="10">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userId" maxlength="100" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" maxlength="100" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit"> <input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>