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
    <link href="./css/blog-comment.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

		<%@ include file="./components/header.jsp" %>

<%-- 		<%@ include file="./components/menu.jsp" %> --%>

<%-- 		<%@ include file="./components/banner.jsp" %> --%>

    </div>

<br>
      <main role="main" class="container">
		<jsp:include page='${"PostServlet"}' >
			<jsp:param name="action" value="listpost" />
			<jsp:param name="postid" value="${param.postid }" />
		</jsp:include>
		<jsp:include page='${"CommentServlet"}' >
			<jsp:param name="action" value="listcomments" />
			<jsp:param name="postid" value="${param.postid }" />
		</jsp:include>
		<%@ include file="./components/post_content.jsp" %>
		<%@ include file="./components/post-comments.jsp" %>
	  </main>
	  <!-- /.container -->


	<%@ include file="./components/footer.jsp" %>
  </body>
</html>
