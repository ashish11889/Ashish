<%session=request.getSession(false); %>
<%if(session.getAttribute("user")!=null)
{
 %>
<%@page import="java.util.*"%>
<%@page import="com.dto.*"%>
<html>
	<a href="logoutCTL">Logout</a>
	<a href="Home.jsp">Back</a>
	<body>

		<form action="MarksheetListCTL"> 
			pName 
			<input type="text" name="name">
			<input type="submit" name="operation" value="search">

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
					ArrayList list = (ArrayList) request.getAttribute("message");
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

		</form>
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

 





