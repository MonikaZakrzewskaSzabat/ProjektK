<%--
  Created by IntelliJ IDEA.
  User: Wojtek
  Date: 2015-02-2
--%>
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
      <h1>Logowanie</h1>
      <form:form method="post" action="addlog" commandName="user" class="form-horizontal">
      <div class="control-group">
        <form:label cssClass="control-label" path="email">Email:</form:label>
        <div class="controls">
          <form:input path="email"/>
        </div>
      </div>
      <div class="control-group">
        <form:label cssClass="control-label" type="password" path="haslo">Haslo:</form:label>
        <div class="controls">
          <form:input type="password" path="haslo"/>
        </div>
      </div>
      <div class="control-group">
        <div class="controls">
          <input type="submit" value="Zaloguj" class="btn"/>
          </form:form>
        </div>
      </div>

      <c:if test="${!empty listUsers}">
        <h3>Dane wpisane do logowania</h3>
        <table class="table table-bordered table-striped">
          <thead>
          <tr>
            <th>Email</th>
            <th>Haslo</th>
            <th>&nbsp;</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${listUsers}" var="user">
            <tr>
              <td>${user.email}</td>
              <td>${user.haslo}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </c:if>
      <td>
        <form action="rejestracja" method="get"><input type="submit" class="btn btn-danger btn-mini" value="Rejestracja"/></form>
      </td>
      <td>
        <form action="/" method="get"><input type="submit" class="btn btn-danger btn-mini" value="Strona glowna"/></form>
      </td>
    </div>
  </div>
</div>

</body>
</html>
