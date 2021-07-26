<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Complete Order</title>
</head>
<body>
<br/>
<h2>Cart Details</h2>


<h2>Enter Your Details</h2>

<form action="addCart" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="customerName"/> </td></tr>
<tr><td>Address:</td><td><input type="text" name="customerAddress"/> </td></tr>
<tr><td>Email:</td><td><input type="text" name="email"/> </td></tr>
<tr><td><input type="hidden" name="itemId" value="${item.itemId}" /> </td></tr>
</table>
<h2>Enter the Payment Details</h2>
<table>
<tr><td> Name:</td><td><input type="text" name="name"/> </td></tr>
<tr><td>Card Number:</td><td><input type="text" name="cardNumber"/> </td></tr>
<tr><td>CVV Code:</td><td><input type="text" name="cvvCode"/> </td></tr>
<tr><td>Expiry Date</td><td><input type="text" name="expiryDate"/> </td></tr>
<tr><td>Amount:</td><td><input type="text" name="amount" /> </td></tr>

<tr><td><input type="submit" value="Order"/> </td></tr>

</table>

</form>
<br/>
</body>
</html>