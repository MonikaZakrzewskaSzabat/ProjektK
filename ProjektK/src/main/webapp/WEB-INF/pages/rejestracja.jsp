<%--
  Created by IntelliJ IDEA.
  User: Wojtek
  Date: 2015-02-20
--%>
<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<meta charset="utf-8">
	<title>Projekt - konfesjonal</title>

	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link href="http://twitter.github.io/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
	<link href="http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>

<div class="container">
	<div class="row">
		<div class="span8 offset2">
			<h1>Rejestracja</h1>
			<form:form action="addrej" method="post" modelAttribute="user">
				<table>
					<form:hidden path="id"/>
					<tr>
						<td>Imie:</td>
						<td><form:input path="imie" /></td>
					</tr>
					<tr>
						<td>Nazwisko:</td>
						<td><form:input path="nazwisko" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td>Parafia:</td>
						<td><form:input path="parafia" /></td>
					</tr>
					<tr>
						<td>Wiek:</td>
						<td><form:input path="wiek" /></td>
					</tr>
					<tr>
						<td>Haslo:</td>
						<td><form:input type="password" path="haslo" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="Zarejestruj"></td>
					</tr>
				</table>
			</form:form>

			<c:if test="${!empty listUsers}">
				<h3>Zarejestrowani wierni</h3>
				<table class="table table-bordered table-striped">
					<thead>
					<tr>
						<th>No</th>
						<th>Nazwisko</th>
						<th>Imie</th>
						<th>Email</th>
						<th>Wiek</th>
						<th>Parafia</th>
						<th>&nbsp;</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="user" items="${listUsers}" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${user.nazwisko}</td>
							<td>${user.imie}</td>
							<td>${user.email}</td>
							<td>${user.wiek}</td>
							<td>${user.parafia}</td>
							<td>
								<form action="deleteUser?id=${user.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Usun"/></form>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
			<td>
				<form action="logowanie" method="get"><input type="submit" class="btn btn-danger btn-mini" value="Logowanie"/></form>
			</td>
			<td>
				<form action="/" method="get"><input type="submit" class="btn btn-danger btn-mini" value="Strona glowna"/></form>
			</td>
		</div>
	</div>
</div>

</body>
</html>