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

  <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body style="background-image: url('http://www.urss.pl/attachments/795bb_spowiedz.jpg'); background-size: cover; background-repeat: no-repeat">


<div class="container" align="center" >
  <div class="row">
    <div class="span8 offset2"  style="background-color: mintcream; background-size: contain">
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
      </div><br>
      <div class="control-group">
        <div class="controls">
          <input type="submit" class="btn btn-default" value="Zaloguj" class="btn"/>
          </form:form>
        </div>
      </div>

      <c:if test="${!empty users}">
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
          <c:forEach items="${users}" var="user">
            <tr>
              <td>${user.email}</td>
              <td>${user.haslo}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </c:if>
      <table>
        <tr>
          <td>
            <form action="rejestracja" method="get"><input type="submit" class="btn btn-primary" value="Rejestracja"/></form>
          </td>
          <td></td>
          <td>
            <form action="/" method="get"><input type="submit" class="btn btn-primary" value="Strona glowna"/></form>
          </td>
        </tr>

      </table><br>

    </div>
  </div>
</div>

</body>
</html>
