<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h4>Comments</h4>
<hr>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-9">

		<c:forEach items="${comments }" var="comment">
			<div class="blog-comment">
				<div class="blog-comment avatar">
					<img src="img/upload/${commentAuthors[comment.author].avatar }" />
				</div>
				<div class="blog-comment content">
					<p class="blog-post-meta">${comment.posttime }
						<a href="#">${commentAuthors[comment.author].stuName }</a>
					</p>
					<p>${comment.content }
						<c:if test="${User.stuId.equals(comment.author) }">
						<a href="RemoveCommentServlet?commentid=${comment.commentId }">Remove</a>
						</c:if>
					</p>
				</div>
			</div>
		</c:forEach>

		<c:if test="${not empty User }">
			<div class="blog-comment">
				<div class="blog-comment avatar">
					<img src="img/upload/${User.avatar }" />
				</div>
				<div class="blog-comment newcontent">
					<form action="NewCommentAction" method="post">
						<textarea id="comment" name="comment" class="form-control"
							placeholder="Write your comments (less than 1000 words, markdown grammar is supported)"
							rows="5" required></textarea>
						<input id="postid" name="postid" type="hidden" value="${postid }" />
						<button class="btn btn-lg btn-primary" type="submit">Commit</button>
					</form>
				</div>
			</div>
		</c:if>

	</div>
</div>
