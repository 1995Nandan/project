<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width-divice-width,initial-scale-1">
<title>SignIn Page</title>
<script type="text/javascript">
function change_button(checkbx,button_id) {
    var btn = document.getElementById(button_id);
    if (checkbx.checked == true) {
        btn.disabled = "";
    } else {
        btn.disabled = "disabled";
    }
}
</script>
</head>
<body style="background-color: ">


<div class="navbar navbar-expand-sm navbar-dark bg-dark" >
<div class="container">
<div class="navabar-brand" class="nav-link" style="text-transform: uppercase; ">
<img src="images/husky.JPG" width="100" height="100">
</div>
<button type="button" 
data-bs-toggle="collapse" 
data-bs-target="#navbarNav"
class="navbar-toggler" 
aria-controls="navbarNav"
aria-expanded="false" 
aria-label="Toggle navigation">
<span class="navbar-toggler-icon"></span>
</button>
<div id=navbarNav>
<ul class="nav navbar-nav navbar-right" >

<li class="nav-item-active"><a href="index.jsp" class="nav-link" >Home</a></li>

<li class="nav-item-active"><a href="SignUp.jsp" class="nav-link">SignIn</a></li>
</ul>
</div>
</div>
</div>

<h2 style="text-centre">${UserDataDTO.name}</h2>
<!--  <h2 style="color: green;">${mesg}</h2>-->
<h2 style="color: red;">${mesg}</h2>

<form action="user" method="post">
<div class="container">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<br>
<label class="label col-md-2 control-label">UserEmail</label>
<div class="col-md-7">
<input type="Enter Your Email_Id" class="form-control" name="email">
</div><br>
<input type="submit" value ="Submit"><br><br><br>
					<div>
<style>
.footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: black;
  color: white;
  text-align: center;
}
</style>

<div class="footer">
 © 2022 Nandan: <a href="index.jsp">Home</a>
</div>
	</div>

</div>

</div>
</form>
</body>
</html>