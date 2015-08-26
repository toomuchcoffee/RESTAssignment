<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Users</title>
</head>
<body>
<h1>
	List of Users
</h1>

<table>
	<tr>
		<th>ID</th>
		<th>First name</th>
		<th>Last name</th>
	</tr>
	<c:forEach items="${users}" var="item">
		<tr>
			<td><a href="/assignment/users/${item.id}">${item.id}</a></td>
			<td>${item.firstName}</td>
			<td>${item.lastName}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
