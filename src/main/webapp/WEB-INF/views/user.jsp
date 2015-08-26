<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="req" value="${pageContext.request}" />
<html>
<head>
	<title>User</title>
</head>
<body>
<h1>
	User data
</h1>

<table>
	<tr>
		<td>ID</td>
		<td><strong>${user.id}</strong><td>
	</tr>
	<tr>
		<td>First name</td>
		<td><strong>${user.firstName}</strong><td>
	</tr>
	<tr>
		<td>Last name</td>
		<td><strong>${user.lastName}</strong><td>
	</tr>
	<tr>
		<td>Bank accounts</td>
		<td><a href="${req.contextPath}/users/${user.id}/bankaccounts">click</a><td>
	</tr>
</table>

</body>
</html>
