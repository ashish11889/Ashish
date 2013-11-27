<%session=request.getSession(false); %>
<%if(session.getAttribute("user")!=null)
{
 %>

<%@page import="java.util.*"%>
<%@page import="com.dto.*"%>
<html>

	<table border="1">
		<tr>
			<td>
				<br>
				ROllno
			</td>
			<td>
				Name
			</td>
			<td>
				Chemistry
			</td>
			<td>
				Physics
			</td>
			<td>
				Maths
			</td>
		</tr>
		<%
			MarksheetDTO marksheetdto = new MarksheetDTO();
			ArrayList list =(ArrayList)request.getAttribute("message");
			Iterator it = list.iterator();
			while (it.hasNext()) {
				marksheetdto = (MarksheetDTO) it.next();
		%>
		<tr>
			<td>
				<%=marksheetdto.getRollno()%>
			</td>
			<td>
				<%=marksheetdto.getName()%>
			</td>
			<td>
				<%=marksheetdto.getChemistry()%>
			</td>
			<td>
				<%=marksheetdto.getPhysics()%>

			</td>
			<td>
				<%=marksheetdto.getMaths()%>
			</td>
		<tr>
			<%
				}
			%>
		
	</table>
	<body>
		<br>
		<br>
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

 





