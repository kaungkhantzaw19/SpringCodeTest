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
<spring:form modelAttribute="addproductbean" action="addproductrepo" method="Post">
Product_Name
<spring:input path="product_name"/><br>
Brand
<spring:input path="brand"/><br>
Price
<spring:input path="price"/><br>
<input type="submit" value="addproduct">
</spring:form>

</body>
</html>