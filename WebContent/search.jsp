<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Explore Georgia</title>
</head>
<body>
	<div id="page">
		<div id="header">
			<%@ include file="menu.jsp"%>
			<div id="logo2">
				<form action="search.jsp">
					<table align="center">
						<tr>
							<td colspan="2"><h2 style="color: #F3E14A">Search for
									Sights</h2></td>
						</tr>
						<tr>
							<td id="formtext">Name of place:</td>
							<td><input type="text" name="name" value="${param.name}" /></td>
						</tr>
						<tr>
							<td id="formtext">Minimum number of days:</td>
							<td><input type="text" name="days" value="${param.days}" /></td>
						</tr>
						<tr>
							<td id="formtext">Accessible by minibus:</td>
							<td><select name="access" value="${param.access}">
									<option value="0">Not mandatory</option>
									<option value="1">Yes</option>
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<jsp:include page="ListOfPlaces">
			<jsp:param name="name" value="${param.name}" />
			<jsp:param name="days" value="${param.days}" />
			<jsp:param name="access" value="${param.access}" />
		</jsp:include>
	</div>
</body>
</html>