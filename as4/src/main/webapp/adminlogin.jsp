<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form method="post" action="AdminLoginController">
		<div style="padding: 100px 0 0 250px;">
			<div id="login-box">
				<h2>Login Page</h2>
				<div id="login-box-name" style="margin-top: 20px;">Username:</div>
				<div id="login-box-field" style="margin-top: 20px;">
					<input name="username" class="form-login" title="username" value=""
						size="30" maxlength="50" />
				</div>
				<div id="login-box-name">Password:</div>
				<div id="login-box-field">
					<input name="password" type="password" class="form-login"
						title="password" value="" size="30" maxlength="48" />
				</div>
					<br /> <span class="login-box-options"> End User? <a
					href="adminlogin.jsp" style="margin-left: 30px;">Login Here</a>
				</span> <br /> <br /> <input style="margin-left: 100px;" type="submit"
					value="Login" />
			</div>
		</div>
	</form>
</body>
</html>