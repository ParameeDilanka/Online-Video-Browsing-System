<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
form{
	width:450px;
	background:blue;
	color:white;
	margin:auto;
	padding:20px;
	font-size:14px;
	font-family:verdana;
}

#form{
	position:absolute;
	left: 5px;
    }

</style>
<link rel = "stylesheet"
   type = "text/css"
   href = "Contact.css" />

<meta charset="UTF-8">
<title>Online Video Browsing System</title>
</head>
<body background="images/w.jpg"></body>
<body class="body">

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h1 class="h1"><center> Contact Us</center></h1>
    <h2>* If you have problem during download video, watch video, upload video, commenting or any other using this web application, please submit your inquiry below</h2>
	    <h2>* Give your suggesions to us using given form</h2>
	<br>
	</center>
	<form method="POST" action="AddContactServlet">
		<table>

			<tr>
				<td> Name</td>
				<td><input type="text" name="Name" class = "inpt" placeholder="please input your name" required/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" class = "inpt" placeholder="please input your e-mail" pattern = "[a-zA-Z0-9.%_+-]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,3}" required /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" id="phone" placeholder="please input your mobile number" class = "inpt" pattern = "[0-9]{10}" required  /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" class = "inpt" placeholder="please input your address" required /></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><input type="text" name="subject" class = "inpt" placeholder="please enter subject here" required /></td>
			</tr>
			<tr>
				<td>Message</td>
				<td><input type="text" name="message" class = "inpt" rows = "10"  placeholder="please input your message" required   /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Add Contact" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>	
		</form>
		<form method="POST" action="ListContactServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Contacts" class="list-button" />
				</td>
			</tr>
		</table>
	</form>
	</center>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>