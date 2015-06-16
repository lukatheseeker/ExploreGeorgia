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
			<%@ include file="menu.jsp" %>
			<div id="logo">
                <h1>Explore Georgia</h1>
                <p id="subtitle">All information you need to visit best of our country</p>
            </div>
            </div>
            <jsp:include page="ListOfPlaces" />
    </div>
</body>
</html>