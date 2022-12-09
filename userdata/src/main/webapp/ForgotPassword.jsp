<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	
	<style type="text/css">
	body{
	background-image:url("https://images.pexels.com/photos/243971/pexels-photo-243971.jpeg");
	background-repeat:no-repeat;
	width: 100%;
	height: 100%;
	background-size: 100%; }
	
	</style>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width-divice-width,initial-scale-1">
<title>Forgot Password</title>
<script type="text/javascript">
	
</script>
<style type="text/css">
body {
	background-color: #344a72;
	font-family: 'Roboto', sans-serif;
}
.main {
	width: 350px;
	height: 350px;
	margin: auto;
	background-color: white;
	border-radius: 3px;
}
h4 {
	text-align: center;
	padding-top: 20px;
}
form {
	width: 300px;
	margin-left: 20px;
}
form label {
	display: flex;
	margin-top: 10px;
	font-size: 10x;
}
form input {
	width: 100%;
	padding: 7px;
	border: none;
	border: 1px solid gray;
	border-radius: 6px;
	outline: none;
}
input[type="submit"] {
	width: 320px;
	height: 35px;
	margin-top: 40px;
	border: none;
	background-color: #49c1a2;
	color: white;
	font-size: 18px;
}
p {
	text-align: center;
	padding-top: 20x;
	font-size: 15px;
}
.foot {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: #1b1b1b;
	color: white;
}
</style>
</head>

<body>
	<div class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-brand" class="nav-link">
				<img src="https://raw.githubusercontent.com/X-workzDev01/xworkzwebsite/master/src/main/webapp/assets/images/Logo.png" width="100" height="50">
			</div>
			<div>
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item-active"><a href="index.jsp"
						class="nav-link" style="color: white;">Home</a></li>
					<li class="nav-item-active"><a href="SignIn.jsp"
						class="nav-link" style="color: white;">SignIn</a></li>
				</ul>
			</div>
		</div>
	</div>
	<h2></h2>
	<br></br>
	<h2></h2>
	<div class="main">
		<h4>Forgot Password</h4>
		<form action="reset" method="get">

			<label>Email</label> <input type="email" name="email"
				placeholder="Email" required> 
				<br>
	
			<input type="submit" name="SingIn" value="Submit">

			<p>
				Not have an account? <a href="SignUp.jsp">Sign up Here</a>
			</p>
			<p>
			<a href="SignIn.jsp">Sign in Here</a>
			
			</p>
			
			
		</form>
	</div>

	<div class="foot">
		<footer class="page-footer font-small blue">
			<div class="footer-copyright text-center py-1">&copy;Nandan2022Copyright

			</div>

		</footer>
	</div>
</body>
</html>
