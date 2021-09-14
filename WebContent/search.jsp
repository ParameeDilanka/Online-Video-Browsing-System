<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
 
<!DOCTYPE html>
<html>
    <head>
    <body background="images/as.jpg"></body>
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
		 background-color:yellow;
		 border-top: 1px solid  black;
		 border-bottom: 1px solid black;
		 border-right: 1px solid black;
}



</style>
<link rel = "stylesheet"  type = "text/css"  href = "Contact.css" />
<a href="homeView.jsp">Add contact page</a>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
          <h1 ><center>Search Contact Details</center></h1>
         <body>
                <div class="container">
             <center> <div class="form-group col-6 p-0">
                 <form id="form" method="post" action="search.jsp" class="form-horizontal">
                       <div class="form-group col-md-6"> 
                           <b><label>Phone No: </label><td></td></b>
  			    <input type="text" name="phone" class="form-control" id="phone" placeholder="Enter phone no..."  required style="width: 200px ;height: 30px"><br></br>
                    </center>
                        </div>
                       <div class="form-group col-md-6" align="left"> 
 
                         <center><Button class="btn btn-success" style="width: 200px; background-color:red;  margin:8px 4px 4px 4px;  width:20%; height:30px; background-color:red; font-size:16px; font-weight:bold;">Search</Button></center><br></br>
              
                        </div>         
                 </form>
                 
             </div>
         </div> 
    </body>

    <body>
    </center>
        <div class="container">
            <div class="form-group col-12 p-0">
             <%
                Connection con;
                PreparedStatement pst;
                ResultSet rs;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop","root","paramee");
                String phone = request.getParameter("phone");
                %>
             

              <% 
             
            
            
              
                pst = con.prepareStatement("select * from employee where phone =?");
                pst.setString(1, phone);
                rs = pst.executeQuery();
                
                
                 while(rs.next())
                 {
                	 out.print("<Table border=1 bgcolor=yellow>");
                	  out.print("<TR>");
                      out.print("<TD>" +"UserID");
                      out.print("<TD>" +"Name");
                      out.print("<TD>" +"Email");
                      out.print("<TD>" + "Phone" );
                      out.print( "<TD>" + "Address");
                      out.print( "<TD>" + "Subject");
                      out.print( "<TD>" + "Message");
                      out.print("</TR>");
                	
                     out.print("<TR>");
                     out.print("<TD>" + rs.getString("userID"));
                     out.print("<TD>" + rs.getString("Name"));
                     out.print("<TD>" + rs.getString("email"));
                     out.print("<TD>" +  rs.getString("phone") );
                     out.print( "<TD>" + rs.getString("address"));
                     out.print( "<TD>" + rs.getString("subject"));
                     out.print( "<TD>" + rs.getString("message"));
                     out.print("</TR>");
                     out.print("</Table>");  
                 }
                 %>
        
                             
</center>
</html>