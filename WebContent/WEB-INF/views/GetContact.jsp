<%@page import="com.oop.model.Contact"%>
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
<link rel = "stylesheet"  type = "text/css"  href = "Contact.css" />
<meta charset="UTF-8">
<title>Online Video Browsing System</title>
</head>
<body background="images/asc.jpg"></body>
<body>


	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<a href="homeView.jsp">Add contact page</a>

	<h1 class="h2"><center>Get Contact Page</center></h1>

<center>
	<br>
	<br>
	<%
	Contact employee = (Contact) request.getAttribute("employee");
	%>

	<form method="POST" action="UpdateContactServlet">
		<table>
			<tr>
				<td>User ID</td>
				<td><input type="text" name="userID" disabled="disabled"
					value="<%=employee.getUserID()%>" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="Name"
					value="<%=employee.getName()%>" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"
					value="<%=employee.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone"
					value="<%=employee.getPhone()%>" /></td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					value="<%=employee.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Subjectt</td>
				<td><input type="text" name="subject"
					value="<%=employee.getSubject()%>" /></td>
			</tr>
			<tr>
				<td>Message</td>
				<td><input type="text" name="message"
					value="<%=employee.getMessage()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="userID"
					value="<%=employee.getUserID()%>" /> <input type="submit"
					value="Update Contact" class="update-button"/></td>
			</tr>
			</table>
			
		</form>

	<table>
	    <tr>
			<td colspan="2">
				<form method="POST" action="DeleteContactServlet">
					<input type="hidden" name="userID"
						value="<%=employee.getUserID()%>" /> <input type="submit"
						value="Delete Contact" class="delete-button"/>

				</form>
			</td>
		</tr>
	</table>
	

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</center>
</html>