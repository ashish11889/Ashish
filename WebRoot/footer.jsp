<%session=request.getSession(false); %>
<%if(session.getAttribute("user")!=null)
{
 %>
<html><head>

  </head>
  
  <body><b>
    Devloper : Deepak Buley</b> 
 </body>
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
