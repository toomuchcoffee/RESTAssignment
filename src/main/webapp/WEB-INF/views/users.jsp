<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="req" value="${pageContext.request}" />
<html>
<head>
	<title>Users</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
		function deleteUser(id) {
			var url = '${req.contextPath}/users/'+id;
			$.ajax({
			    url: url,
			    type: 'DELETE',
			    success: function(result) {
			    	window.location.reload(true);
			    }
			});
		}
	</script>
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
		<th></th>
	</tr>
	<c:forEach items="${users}" var="item">
		<tr>
			<td><a href="${req.contextPath}/users/${item.id}">${item.id}</a></td>
			<td>${item.firstName}</td>
			<td>${item.lastName}</td>
			<td><a href="#" onclick="deleteUser(${item.id})">delete</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
