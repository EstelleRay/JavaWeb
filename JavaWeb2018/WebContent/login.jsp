<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./img/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/signin.css" rel="stylesheet">
  </head>

<%
String lastStuId = "";
String lastPassword = "";
Cookie[] cookies = request.getCookies();
for(Cookie cookie : cookies) {
	if (cookie.getName().equals("stuId"))
		lastStuId = new String(Base64.decode(cookie.getValue()));
	if (cookie.getName().equals("password"))
		lastPassword = new String(Base64.decode(cookie.getValue()));
}
%>
  <body class="text-center">
    <form class="form-signin" action="LoginServlet" method="post">
      <img class="mb-4" src="./img/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="stuId" class="sr-only">ID</label>
      <input type="text" id="stuId" name="stuId" class="form-control" placeholder="Student ID" value="<%= lastStuId %>" required autofocus>
      <label for="password" class="sr-only">Password</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="Password" value="<%= lastPassword %>" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" name="rememberMe" checked> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>
