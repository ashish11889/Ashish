<%@page import="java.util.*" %>

<%
	String username, password;
	if(request.getParameter("txtUserName") == null)
		username = "";
	else
		username = request.getParameter("txtUserName");
	
	if(request.getParameter("txtPassword") == null)
		password = "";
	else
		password = request.getParameter("txtPassword");
%>

<table align="center" bgcolor="ffff00" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td align><b>Your User Name: </b></td>
		<td><%=username %><br/></td>
	</tr>
	<tr>
		<td><b>Your Password: </b></td>
		<td><%=password %></td>
	</tr>
</table>