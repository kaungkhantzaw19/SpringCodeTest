<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Id</th>
<th>Product_Name</th>
<th>Brand</th>
<th>Price</th>
<th>Action</th>
</tr>
<jstl:forEach items="${listdata}" var="productdata"> 
<tr>
<td>${productdata.id}</td>
<td>${productdata.product_name}</td>
<td>${productdata.brand}</td>
<td>${productdata.price}</td>
<td>
	<a href="Update?id=${productdata.id}&name=${productdata.product_name}&brand=${productdata.brand}&price=${productdata.price}">update</a>

    <a href="deleteproduct?id=${productdata.id}">delete</a>
</td>
</tr>

</jstl:forEach>


</table>

</body>
</html>