<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" >
</head>
<body>
	<h1>"${ oneQuestion.question }"</h1>
	<h3>Tags   </h3>
	<c:forEach var="tag" items="${ oneQuestion.tags }">
		<span>"${ tag.getSubject() }"</span>
	</c:forEach> 
	
	<br><br>

	<table>
		<tr>
			<th>Answers</th>	       
		</tr>
		<c:forEach var = "ans" items="${ oneQuestion.answers }">
		<tr>
			<td>"${ ans.getAnswer() }"</td>	     
		</tr>
		</c:forEach>
	</table>
	  
	<br><br>
	  
	<h2>Add your answer:</h2>
	  
	<form method="POST" action="/questions/${oneQuestion.getId()}">
	    <label for="answer">Answer   </label> 
	    <textarea name="answer"></textarea>
	    <br><br>	            
	    <input type="submit" value="Submit"/>
	</form>

	<br><br>

	<a href="/questions">Go to Dashboard</a>
	  
</body>
</html>