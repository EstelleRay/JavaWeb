<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./img/favicon.ico">

    <title>Blog Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
<!--     <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet"> -->
    <link href="./css/blog.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

		<%@ include file="./components/header.jsp" %>

<%-- 		<%@ include file="./components/menu.jsp" %> --%>

<%-- 		<%@ include file="./components/banner.jsp" %> --%>

    </div>

<br>
    <main role="main" class="container">
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form class="form-horizontal" method="post" action="NewPostServlet">
                    <div class="form-group">
                        <div class="row">
                            <label for="postTitle" class="col-sm-2 control-label">
                                Title:</label>
                            <div class="col-sm-10">
                                <input type="text" name="postTitle" id="postTitle" class="form-control" placeholder="Input a title" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label for="postContent" class="col-sm-2 control-label">
                                Content:</label>
                            <div class="col-sm-10">
                                <textarea rows="24" name="postContent" id="postContent" class="form-control" placeholder="Write your contents (less than 3000 words, markdown grammar is supported)"
                                    required></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="offset-sm-2 col-sm-10">
                                <button class="btn btn-lg btn-primary" type="submit">Commit</button>
                                <a class="btn btn-lg btn-secondary" onclick="javascript:history.go(-1);">Cancel</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- /.row -->


    </main>
    <!-- /.container -->


	<%@ include file="./components/footer.jsp" %>
  </body>
</html>
