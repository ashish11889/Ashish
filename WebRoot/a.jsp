<%session=request.getSession(false); %>
<%if(session.getAttribute("user")!=null)
{
 %>
<html>
  <head>
    
    <title>My JSP 'a.jsp' starting page</title>
  </head>
  
  <body>
			<form action="MarksheetListCTL">
			<input type="submit"name="operation" value="Getlist">

		</form>  </body>
</html>
<%
}
else
{
%>
<jsp:forward page="LogoutCTL"></jsp:forward>
<%
}
 %>

