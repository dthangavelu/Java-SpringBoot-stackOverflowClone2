<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Questions</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" >
</head>
<body>
	<h1>Question Dashboard</h1>
	<br><br>
	<a href="/questions/new">New Question</a>
	
	<br><br>
	
	<table>
	  <tr>
	    <th>Question</th>
	    <th>Tags</th>	    
	  </tr>
	  <c:forEach var = "allQ" items="${ allQuestions }">
	  <tr>
	    <td><a href="/questions/${allQ.getId()}">"${ allQ.getQuestion() }"</a></td>	
	    
    	<td>
    	<c:forEach var="allTags" items="${ allQ.getTags() }">
    		<c:out value="${ allTags.getSubject()}, "/>
    	</c:forEach>
    	</td>	   
	     
	  </tr>
	  </c:forEach>
	  </table>
	 <!-- <c:out value="${2+2}"/> -->
</body>
</html>

