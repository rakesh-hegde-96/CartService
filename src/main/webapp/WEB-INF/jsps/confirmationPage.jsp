<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oder Details</title>
</head>
<body>
<h2>Your Order is Confirmed</h2>
Order Details
<table>
<tr>
<td>Customer Name</td>
<td>${customerName }</td>
</tr>

<tr>
<td>Customer Address</td>
<td>${address }</td>
</tr>
<tr>
<td>Customer Email</td>
<td>${email }</td>
</tr>
<tr>
<td>Item Name</td>
<td>${itemName }</td>
</tr>
<tr>
<td>Price</td>
<td>${price }</td>
</tr>
<tr>
<td>Restaurant ID</td>
<td>${RestId }</td>
</tr>


</table>
</body>
</html>