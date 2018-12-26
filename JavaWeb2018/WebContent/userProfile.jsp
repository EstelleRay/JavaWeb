<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="./css/userprofile.css" rel="stylesheet">
    
    <link rel="stylesheet" href="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.min.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/semantic-ui/2.1.8/semantic.min.js"></script>
    
  </head>


  <body>

    <div class="container">

		<%@ include file="./components/header.jsp" %>

     	<%@ include file="./components/menu.jsp" %>
    </div>

	<jsp:include page='${"UserServlet" }'>
		<jsp:param name="stuId" value="${param.stuId }" /> 
	</jsp:include>
    <div class="container">
      <div class="row">
        <div class="col-md-8 blog-main">
          <div class="card">
          	<div class="card-header">
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
				User Information <c:if test="${not empty tip }"><span class="required-tag">${tip }</span></c:if>
			</div>
			<div class="card-block">
				<div class="user-info">
				  <c:if test="${profiledUser.stuId.equals(User.stuId) }">
		          <form class="form-signin" action="UpdateBasicInfoServlet" method="post">		      
				      <label for="stuName">Name<span class="required-tag">*</span></label>
				      <input type="text" id="stuName" name="stuName" class="form-control" placeholder="Student Name" value="${User.stuName }" required>
				      <label for="password">Password</label>
      				  <input type="text" id="password" name="password" class="form-control" placeholder="Password (Unchanged if leaved blank)">
				      <label for="gender">Gender</label>
				      <select id="gender" name="gender" class="form-control">
				      	<option value="f" ${User.gender=="f" ? "selected" : "" }>Female</option>
				      	<option value="m" ${User.gender=="m" ? "selected" : "" }>Male</option>
				      </select>
				      <label for="bio">Bio</label>
				      <input type="text" id="bio" name="bio" class="form-control" placeholder="Bio" value="${User.bio }">
				      <label for="gitUrl">Git Url</label>
				      <input type="text" id="gitUrl" name="gitUrl" class="form-control" placeholder="Git Url" value="${User.gitUrl }">
				      <br>
				      <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
				    </form>
				    </c:if>
				    <c:if test="${!profiledUser.stuId.equals(User.stuId) }">	      
				    <form class="form-signin">
				      <label for="stuName">Name</label>
				      <input type="text" id="stuName" name="stuName" class="form-control" value="${profiledUser.stuName }" readonly="readonly">
				      <label for="gender">Gender</label>				      
				      <input type="text" id="gender" name="gender" class="form-control" value='${profiledUser.gender=="f" ? "Female" : "Male" }' readonly="readonly">
				      <label for="bio">Bio</label>
				      <input type="text" id="bio" name="bio" class="form-control" value="${profiledUser.bio }" readonly="readonly">
				      <label for="gitUrl">Git Url</label>
				      <input type="text" id="gitUrl" name="gitUrl" class="form-control" value="${profiledUser.gitUrl }" readonly="readonly">
				    </form>
				    </c:if>
				  </div>
				  <div class="user-info-right">
					<div class="user-info-avatar">
						<img src='./img/upload/${profiledUser.avatar.equals("") ? "../bootstrap-solid.svg" : profiledUser.avatar }' />
					</div>
					<c:if test="${profiledUser.stuId.equals(User.stuId) }">
						<form class="form-signin" action="UpdateAvatarServlet" method="post" enctype="multipart/form-data">
							<label for="avatar" class="sr-only">Avatar</label>
	      					<input type="file" id="avatar" name="avatar" class="form-control" placeholder="Avatar">
	      					<br>
	      					<button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
	      				</form>
	      				</c:if>
				  </div>
				</div>				
		    </div>
		    <br/>
		    <div class="card card-primary">
	          	<div class="card-header">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					Top 10 visited posts
				</div>
				<div class="card-block">		
					<table class="table">
						<thead>
							<tr>
								<th>Title</th>
								<th>#Visit</th>
								<th>#Comment</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>习近平向第五届世界互联网大会致贺信</td>
								<td>12</td>
								<td>12</td>
							</tr>
							<tr>
								<td>习近平向第五届世界互联网大会致贺信</td>
								<td>12</td>
								<td>12</td>
							</tr>		
							<tr>
								<td>习近平向第五届世界互联网大会致贺信</td>
								<td>12</td>
								<td>12</td>
							</tr>					
						</tbody>
					</table>          
				</div>
		    </div>
                   	<br/>
		    <div class="card card-info">
	          	<div class="card-header">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					Top 10 commented posts
				</div>
				<div class="card-block">	
					<table class="table">
						<thead>
							<tr>
								<th>Title</th>
								<th>#Comment</th>
								<th>#Visit</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>习近平向第五届世界互联网大会致贺信</td>
								<td>12</td>
								<td>12</td>
							</tr>		
							<tr>
								<td>习近平向第五届世界互联网大会致贺信</td>
								<td>12</td>
								<td>12</td>
							</tr>		
							<tr>
								<td>习近平向第五届世界互联网大会致贺信</td>
								<td>12</td>
								<td>12</td>
							</tr>							
						</tbody>
					</table>	          
				</div>
		    </div>
          

        </div><!-- /.blog-main -->

        <%@ include file="./components/sidebar.jsp" %>

      </div><!-- /.row -->

    </div><!-- /.container -->

	<%@ include file="./components/footer.jsp" %>
  </body>
</html>
