<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="req" value="${pageContext.request}" />
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	User and Bank Account Admin
</h1>

<ul>
	<li><a href="${req.contextPath}/users">Users</a></li>
	<li><a href="${req.contextPath}/bankaccounts">Bank accounts</a></li>
</ul>

</body>
</html>
