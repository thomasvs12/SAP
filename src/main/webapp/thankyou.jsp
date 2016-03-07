<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="com.penninkhof.odata.*"%>
<%@ page import="com.penninkhof.odata.entities.Shoebox"%>
<%@ page import="com.penninkhof.odata.repository.ShoeboxRepository"%>

<%
	//final MyFactory myfact = new MyFactory();
	String result;

	// Sender's email ID needs to be mentioned
	final String from = "hackathon.foobar@gmail.com";
	final String password = "foobar123";

	// Assuming you are sending email from localhost
	//String host = "localhost";

	// Get system properties object
	Properties properties = System.getProperties();

	// Setup mail server
	properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.user", from);
	properties.put("mail.smtp.password", password);
	properties.put("mail.smtp.port", 465);
	properties.put("mail.smtp.socketFactory.port", 465);
	properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.EnableSSL.enable", "true");

	properties.put("mail.smtp.starttls.enable", "true");

	// Get the default Session object.
	Session mailSession = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(from, password);// Specify the Username and the PassWord
		}
	});

	try {
		
		String reqBarcode = request.getParameter("barcode");
		String reqName = request.getParameter("name");
		String reqAge = request.getParameter("age");
		String reqPlace = request.getParameter("place");
		String reqMessage = request.getParameter("message");
		
		//Shoebox shoebox = myfact.getRepo().findOne(Long.parseLong(reqBarcode));
		String email = Application.getEmail(Long.parseLong(reqBarcode));
		
		// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(mailSession);
		// Set From: header field of the header.
		message.setFrom(new InternetAddress(from));
		// Set To: header field of the header.
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		// Set Subject: header field
		message.setSubject("Schoenmaatjes bericht terug.");
		// Now set the actual message
		message.setText(
			reqMessage
			+"\n\n\n"
			+"Afzender\n"
			+"-----------------\n"
			+"Naam: "+reqName+"\n"
			+"Leeftijd: "+reqAge+"\n"
			+"Plaats: "+reqPlace+"\n"
		);
		// Send message
		Transport.send(message);
		result = "Sent message successfully....";
	} catch (MessagingException mex) {
		mex.printStackTrace();
		result = "Error: unable to send message....";
	}
%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Hackathon 2016 by Foobar</title>
</head>

<body>
	<h1>Thank you!</h1>
	<br>Your message has been sent.
</body>

</html>