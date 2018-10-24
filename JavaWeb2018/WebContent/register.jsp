<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

  <body class="text-center">
    <form class="form-signin" action="RegisterServlet" method="post" enctype="multipart/form-data">
      <img class="mb-4" src="./img/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>
      <label for="stuId" class="sr-only">ID</label>
      <input type="text" id="stuId" name="stuId" class="form-control" placeholder="Student ID" required autofocus>
      <label for="stuName" class="sr-only">Name</label>
      <input type="text" id="stuName" name="stuName" class="form-control" placeholder="Student Name" required>
      <label for="password" class="sr-only">Password</label>
      <input type="text" id="password" name="password" class="form-control" placeholder="Password" required>
      <label for="avatar" class="sr-only">Avatar</label>
      <input type="file" id="avatar" name="avatar" class="form-control" placeholder="Avatar">
      <label for="gender" class="sr-only">Gender</label>
      <select id="gender" class="form-control" name="gender" required>
      	<option value="f">Female</option>
      	<option value="m">Male</option>
      </select>
      <label for="bio" class="sr-only">Bio</label>
      <input type="text" id="bio" name="bio" class="form-control" placeholder="Bio">
      <label for="gitUrl" class="sr-only">Git Url</label>
      <input type="text" id="gitUrl" name="gitUrl" class="form-control" placeholder="Git Url">
      <br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>
