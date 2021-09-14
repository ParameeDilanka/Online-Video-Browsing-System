<%@page import="com.oop.model.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.ContactServiceImpl"%>
<%@page import="com.oop.service.IContactService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
	    border-spacing: 1px;
}
th, td {
		 padding: 5px 30px 5px 10px;
		 border-spacing: 1px;
		 font-size: 90%;
		 margin: 0px;
}
th, td {
		 text-align: left;
		 background-color: #e0e9f0;
		 border-top: 1px solid  black;
		 border-bottom: 1px solid black;
		 border-right: 1px solid black;
}
</style>
<link rel = "stylesheet"
   type = "text/css"
   href = "Contact.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Video Browsing System</title>
</head>
<body background="images/background.jpg"></body>
<body>
<a href="homeView.jsp">Add contact page</a>||
<a href="search.jsp">Search contacts</a>
	<h1><center>List of Contacts</center></h1>
	<br>
	<br>
	  <div align="left">
		<table border="1"  cellpadding="12">
		  <tr>
                <th>User ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Subject</th>
                <th>Message</th>
                <th>Select</th>
            </tr>
            <%
            IContactService iEmployeeService = new ContactServiceImpl();
                                    	ArrayList<Contact> arrayList = iEmployeeService.getEmployees();
                                    	
                                    	for(Contact employee : arrayList){
            %>
			 <tr>
				<td> <%=employee.getUserID() %> </td>
				<td> <%=employee.getName() %> </td>
				<td> <%=employee.getEmail() %> </td>
				<td> <%=employee.getPhone() %> </td>
				<td> <%=employee.getAddress() %> </td>
				<td> <%=employee.getSubject() %> </td>
				<td> <%=employee.getMessage() %> </td>	
				<td> 
				<form method="POST" action="GetContactServlet">
				<input type="hidden" name="userID" value="<%=employee.getUserID()%>"/>
				 <input type="submit" value= "Select Contact" class="select-button" /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
		
</body>
</html>