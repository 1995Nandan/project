<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>


<style type="text/css">
body {
	background-image:
		url("https://images.pexels.com/photos/235985/pexels-photo-235985.jpeg?auto=compress&cs=tinysrgb&w=600");
	background-repeat: no-repeat;
	width: 100%;
	height: 50%;
	background-size: 100%;
}
</style>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container">
			<div class="navabar-brand" class="nav-link"
				style="text-transform: uppercase;">
				
				<img src="https://raw.githubusercontent.com/X-workzDev01/xworkzwebsite/master/src/main/webapp/assets/images/Logo.png"
					width="100" height="50">	</div>
			<div>
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item-active"><a href="index.jsp"
						class="nav-link">Home</a></li>
					<li class="nav-item-active"><a href="ToAddProduct.jsp" class="nav-link">AddProduct</a></li>
				</ul>
			</div>
		</div>
	</nav><br><br>
	
<title>Insert title here</title>
</head>
<body>
	<form action="add/add">
		<input type="text" name="productName" /> <input type="submit"
			value="search" />
			</form>
	
	<style>
	table,th,td{
	border:1px solid black;
	border-collapse: collapse;
	}
	table {
	width: 100%;
}
th {
	text-align: left;
}
th,td {
padding: 12px;
	
}
	</style>


	${size} ${msg}

	<table>
		
		<caption>Product Details</caption>
			<tr>
				 <th>Id</th>
				<th>ProductName</th>
				<th>userEmail</th>
				<th>category</th>
				<th>price</th>
				<th>stock</th>
				<th>fileName</th>
				<th>createdBy</th>
				<th>createdDate</th>
				<th>updatedBy</th>
				<th>updatedDate</th>
				
			</tr>
			<c:forEach items="${all}" var="g">
             <tr>
                    <td>${g.id}</td>
					<td>${g.productName}</td>
					<td>${g.userEmail}</td>
					<td>${g.category}</td>
					<td>${g.price}</td>
					<td>${g.stock}</td>
					<td>${g.fileName}</td>
					<td>${g.createdBy}</td>
					<td>${g.createdDate}</td>
					<td>${g.updatedBy}</td>
					<td>${g.updatedDate}</td>
					


				</tr>
			</c:forEach>
			
			
	
	</table>
			<div class="foot">
		<footer class="page-footer font-small blue">
			<div class="footer-copyright text-center py-1">
				&copy;Nandan2022Copyright <a href="index.jsp">Home</a>

			</div>

		</footer>
	</div>
			
		
	
</body>
</html>