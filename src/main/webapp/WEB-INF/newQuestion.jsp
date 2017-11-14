<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Question</title>
</head>
<body>
<h1>What is your question</h1>

<!-- 
<c:if test = "${name_error != null}">
	<p class="ui_errors"><c:out value="${ name_error }" /></p>    
</c:if>

<c:if test = "${creator_error != null}">
	<p class="ui_errors"><c:out value="${ creator_error }" /></p>    
</c:if>

<c:if test = "${version_error != null}">
	<p class="ui_errors"><c:out value="${ version_error }" /></p>    
</c:if>
 -->
 
<br><br>

<form method="POST" action="/questions/new">

    <label for="question">Question   </label> 
    <textarea name="question"><c:out value="${questionVal }" /></textarea>
    <br><br>
    
    <label for="tags">Tags</label>    
    <input type="text" name="tags"/><c:out value="${ tags_err }" /><br><br>
        
    <input type="submit" value="Submit"/>
</form>

<br><br>

<a href="/questions">Go to Dashboard</a>
</body>
</html>


