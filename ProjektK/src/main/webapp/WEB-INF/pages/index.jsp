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
      <h1>Witamy na stronie wirtualnego konfesjonalu</h1>
      <h2>U nas wyspowiadasz sie bez strachu</h2>
      <td>
        <form action="rejestracja" method="get"><input type="submit" class="btn btn-danger btn-mini" value="Rejestracja"/></form>
      </td>
      <td>
        <form action="logowanie" method="get"><input type="submit" class="btn btn-danger btn-mini" value="Logowanie"/></form>
      </td>
        </div>
      </div>

      <c:if test="${!empty users}">
        <h3>Zarejestrowani wierni</h3>
        <table class="table table-bordered table-striped">
          <thead>
          <tr>
            <th>Nazwisko</th>
            <th>Imie</th>
            <th>Email</th>
            <th>Wiek</th>
            <th>Parafia</th>
            <th>&nbsp;</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${users}" var="user">
            <tr>
              <td>${user.nazwisko}</td>
              <td>${user.imie}</td>
              <td>${user.email}</td>
              <td>${user.wiek}</td>
              <td>${user.parafia}</td>
              <td>
                <form action="delete/${user.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Usun"/></form>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </c:if>
    </div>
  </div>
</div>

</body>
</html>