<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="req" value="${pageContext.request}" />
<html>
<head>
	<title>Bank accounts</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
		function deleteBankAccount(id) {
			var url = '${req.contextPath}/bankaccounts/'+id;
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
	List of Bank Accounts
</h1>

<table>
	<tr>
		<th>IBAN</th>
		<th>BIC</th>
		<th></th>
	</tr>
	<c:forEach items="${bankAccounts}" var="item">
		<tr>
			<td>${item.iban}</td>
			<td>${item.bic}</td>
			<td><a href="#" onclick="deleteBankAccount(${item.id})">delete</a>
		</tr>
	</c:forEach>
</table>

</body>
</html>
