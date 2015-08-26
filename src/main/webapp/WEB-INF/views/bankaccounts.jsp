<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Bank accounts</title>
</head>
<body>
<h1>
	List of Bank Accounts
</h1>

<table>
	<tr>
		<th>IBAN</th>
		<th>BIC</th>
	</tr>
	<c:forEach items="${bankAccounts}" var="item">
		<tr>
			<td>${item.iban}</td>
			<td>${item.bic}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
