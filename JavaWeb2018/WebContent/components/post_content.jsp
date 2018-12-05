<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10 blog-main">

		<div class="blog-post">
			<h2 class="blog-post-title">${post.title}</h2>
			<p class="blog-post-meta">${post.posttime}
				<a href="index.jsp?author=${post.author }">${postAuthor.stuName}</a>.&nbsp;&nbsp; <img
					src="./img/font-visited.png" height="16">(${post.pv}) <img
					src="./img/font-comment.png" height="16">(${comments.size() })
			</p>
			<div class="blog-post-content">${post.content}</div>
		</div>
		<!-- /.blog-post -->

		<div class="blog-post">
			<a class="btn btn-outline-primary" href="javascript:history.go(-1)">Return</a>
		<c:if test="${User.stuId.equals(post.author) }">
          <a class="btn btn-outline-primary" href="editpost.jsp?postid=${post.postId }">Edit</a>
          <a class="btn btn-outline-primary" href="RemovePostServlet?postid=${post.postId }">Remove</a>
    	</c:if>
    	<c:if test="${!User.stuId.equals(post.author) }">
          <a class="btn btn-outline-secondary" href="editpost.jsp?postid=${post.postId }">Edit</a>
          <a class="btn btn-outline-secondary" href="RemovePostServlet?postid=${post.postId }">Remove</a>
		</c:if>
				
		</div>


	</div>
	<!-- /.blog-main -->

</div>
<!-- /.row -->