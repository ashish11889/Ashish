<%@page import="com.dto.LoginDTO;"%>
<html>
	<head>
	</head>

	<body bgcolor="violet">
		<%
			String string = (String) request.getAttribute("message");
			if (string != null) {
		%>
		<%=string%>
		<%
			}
		%>




		<div align="center">
			<form action="LoginCTL" method="get">


				<table border="1" align="center">
					<tr>
						<td>
							userName
						</td>
						<td>
							<input type="text" name="username" value="">
						</td>
					</tr>
					<tr>
						<td>
							Password
						</td>
						<td>
							<input type="password" name="password" value="">
						</td>
					</tr>


				</table>
				<input type="submit" name="operation" value="Login">



			</form>
	</body>
</html>
