<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="req" value="${pageContext.request}" />
<html>
<head>
	<title>User</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
		function addBankAccounts() {
			var url = '${req.contextPath}/users/${user.id}/bankaccounts/list';
			var data = $("#addbankaccounts").val();
			$.ajax({
			    url: url,
			    data: data,
			    contentType : 'application/json',
			    type: 'POST',
			    success: function(result) {
			    	window.location.reload(true);
			    }
			});
		}
	</script>
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

<h2>Add bank accounts for User</h2>
<table>
<tr>
	<td>
		<textarea id="addbankaccounts">
[{
    "id":"456",
    "iban":"888888888",
    "bic":"PPPPPPPP"
},
{
    "id":"789",
    "iban":"666666666",
    "bic":"STSTSTSTSTS"
},
{
    "id":"999",
    "iban":"7777777777",
    "bic":"JKJKJKJKJ"
}]	
		</textarea>
	</td>
</tr>
<tr>
	<td>
		<a href="#" onclick="addBankAccounts()">Add bank accounts</a>
	</td>
</tr>
</table>
</body>
</html>
