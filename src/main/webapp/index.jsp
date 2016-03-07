<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String barcode = "";
	if (request.getParameter("barcode") != null) {
		barcode = request.getParameter("barcode");
	}
%>
<!DOCTYPE html>

<html>
	<head>
		<link rel="stylesheet" href="style.css">
		<title>Hackathon 2016 by Foobar</title>
	</head>
	
	<body>
		<h1>Edukans Schoenmaatjes</h1>
		<form action="thankyou.jsp" method="post">
			<br><input type="text" name="barcode" placeholder="Barcode" value="<%=barcode%>">
			<br><input type="text" name="name" placeholder="Name">
			<br><input type="text" name="age" placeholder="Age">
			<br><input type="text" name="place" placeholder="Place">
			<br><textarea name="message" placeholder="Type your message here."></textarea>
			<br><input type="submit" name="submit" value="Send message">
		</form>
		<img src="schoenmaatjes.jpg" alt="">
	</body>
</html>