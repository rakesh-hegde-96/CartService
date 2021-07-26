<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Item</title>
</head>
<body>
	<h2>Search Item</h2>
	<form action="searchItem" method="post">
		Item:<input type="text" name="itemName" /> <input type="submit"
			value="Search" />
	</form>

	<br />

	<h2>Menu</h2>

	<table border="1">
		<tr>
			<th>Item Name</th>
			<th>Item Price</th>
			<th>Availability</th>
			<th>Add To Cart</th>
		</tr>

		<c:forEach items="${item }" var="item">
			<tr>
				<td>${item.itemName}</td>
				<td>${item.price}</td>
				<td>${item.itemAvailability}</td>
				<td><a href="showAddCart?itemId=${item.itemId }">Add To
						Cart</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>