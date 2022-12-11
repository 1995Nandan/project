<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Login index Page</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
.Dto {
	text-align: center;
	font-family: serif;
	font-size: 130%;
	font-weight: 500;
}
.body {
	background-image:
		url("https://images.pexels.com/photos/167699/pexels-photo-167699.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
	background-repeat: no-repeat;
	background-size: 100%;
}
.edit {
	text-align: center;
	font-family: serif;
	font-size: 110%;
	background-position: center;
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

<body style="background-color: #7e9a9a;">
		<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
			<div class="container">
				<div class="navabar-brand">
					<img
						src="https://raw.githubusercontent.com/X-workzDev01/xworkzwebsite/master/src/main/webapp/assets/images/Logo.png"
						width="100" height="50">
				</div>
				<div>
					<ul class="nav navbar-nav navbar-right">

						<li class="nav-item-active"><a href="SignIn.jsp"
							class="nav-link" style="color: white;">SignIn</a></li>
							
						<li class="nav-item-active"><a href="ToAddProduct.jsp?email=${dto.email}"
							class="nav-link" style="color: white;">Product</a></li>	

						<div class="navabar-brand">
							<img src="login/image?fileName=${UserDTO.fileName}" width="100"
								height="50" style="border-radius: 80px" />
						</div>

					</ul>

				</div>

			</div>

		</nav>
		<br></br>
	
			<h6 style="text-align: center; font-style: oblique; font-size: 160%;">${message}</h6>
		<br>
		<h6 style="text-align: center; font-style: oblique; font-size: 160%;">Your
			Entered Details</h6>
		<div class="Dto">
			<br></br> Name:${UserDTO.username} <br></br> Email:${UserDTO.email} <br></br>
			Mobile Number:${UserDTO.phoneno}
		</div>
	<br></br>
	<div class="edit">
		<a href="edit?email=${UserDTO.email}"><button>Edit</button></a>
		
	</div>
	<div class="foot">
		<footer class="page-footer font-small blue">
			<div class="footer-copyright text-center py-1">
				&copy;Nandan2022Copyright <a href="index.jsp">Home</a>

			</div>

		</footer>
	</div>

</body>

</html>