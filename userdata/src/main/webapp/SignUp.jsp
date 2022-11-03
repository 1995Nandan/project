<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function change_button(checkbx, button_id) {
		var btn = document.getElementById(button_id);
		if (checkbx.checked == true) {
			btn.disabled = "";
		} else {
			btn.disabled = "disabled";
		}
	}
</script>

</head>


<body style="background-color: white;">
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container">
			<div class="navabar-brand" class="nav-link"
				style="text-transform: uppercase;">
				<img src="images/husky.jpg" width="100" height="60">
			</div>
			<div>
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item-active"><a href="SignIn.jsp"
						class="nav-link">Sign-In</a></li>
					<li class="nav-item-active"><a href="index.jsp"
						class="nav-link">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div>
		${mesg}<br> <br> The Enter UserName is:${DTO.username}
		<form action="user" method="post" style="text-align: center;">
			<h2>Enter User Details Below</h2>
			<br>
			<pre>
UserName:<input type="text" name="username" /><br>
   Email:<input type="text" name="email" /><br>
 PhoneNo:<input type="text" name="phoneno" /><br>
 <input type="checkbox" id="termsChkbx "
					onclick="change_button(this,'sub1')" /> Click Agree to T&C<br>
 <input type="submit" value="submit" id="sub1" disabled="disabled" />
</pre>
		</form>
	</div>
	<div>
		<footer class="page-footer font-small blue">
			<!-- Copyright -->
			<div class="footer-copyright text-center py-3">
				© 2022 Nandan: <a href="index.jsp">Home</a>
			</div>
			<!-- Copyright -->
		</footer>
	</div>

</body>
</html>