<%session=request.getSession(false); %>
<%if(session.getAttribute("user")!=null)
{
 %>
<%@page import="com.dto.MarksheetDTO"%>
<html>

	<head>
	</head>

	<body bgcolor="blue,pink",>
		<div align="center"><form action="MarksheetCTL" method="get" >

			<%
				MarksheetDTO marksheetDTO = null;

				marksheetDTO = (MarksheetDTO) request.getAttribute("list");

				if (marksheetDTO == null) {
					marksheetDTO = new MarksheetDTO();
					//System.out.println(marksheetDTO);
					System.out.println("@@@@@@@@@@@@@@" + marksheetDTO.getName());
		}
			%>

			<h1>

				<div align="center">Online Result System</div>

			</h1>
			<table border="3" align="center">

				<tr>
					<td>
						Rollno
					</td>
					<td>
						<input type="text" name="rollno"
							value="<%=marksheetDTO.getRollno()%>">
					</td>
				</tr>
				<tr>
					<td>
						Name
					</td>
					<td>
						<input type="text" name="name"
							value="<%=marksheetDTO.getName()%>">
					</td>
				</tr>

				<tr>
					<td>
						Chemistry
					</td>
					<td>
						<input type="text" name="chemistry"
							value="<%=marksheetDTO.getChemistry()%>">
					</td>
				</tr>
				<tr>
					<td>
						Physics
					</td>


					<td>
						<input type="text" name="physics"
							value="<%=marksheetDTO.getPhysics()%>">
					</td>
				</tr>
				<tr>
					<td>
						Maths
					</td>

					<td>
						<input type="text" name="maths"
							value="<%=marksheetDTO.getMaths()%>">
					</td>
				</tr>
			</table>


			<input type="submit" name="operation" value="Add">

			<input type="submit" name="operation" value="delete">
			<input type="submit" name="operation" value="update">
			<input type="submit" name="operation" value="get">
			<input type="submit" name="operation" value="List">
			</form>
			</div>
			<%@ include file="footer.jsp" %>
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
