<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form modelAttribute="updatedata" action="updateRepo" method="POST" >

<spring:input path="id" value="${param.id}" type="text"/>
Product_Name
<spring:input path="product_name" value="${param.name }"/><br>
Brand
<spring:input path="brand" value="${param.brand }"/><br>
Price
<spring:input path="price" value="${param.price }"/><br>

<input type="submit" value="update">

</spring:form>
</body>
</html>