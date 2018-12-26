<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
      <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
          <div class="col-4 pt-1">
            <a class="btn btn-sm btn-outline-primary" href="newpost.jsp">New post</a>
          </div>
          <div class="col-4 text-center">
            <a class="blog-header-logo text-dark" href="index.jsp">我的博客</a>
          </div>
          <div class="col-4 d-flex justify-content-end align-items-center">
            <a class="text-muted" href="#">
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3"><circle cx="10.5" cy="10.5" r="7.5"></circle><line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
            </a>
            <c:if test="${not empty User}">
            	Welcome,<a href="userProfile.jsp?user=${User.stuName }">${User.stuName}</a> &nbsp;
            	<a class="btn btn-sm btn-outline-secondary" href="LogoutServlet">Logout</a>
            </c:if>
            <c:if test="${empty User}">
	            <a class="btn btn-sm btn-outline-secondary" href="login.jsp">Login</a>&nbsp;
	            <a class="btn btn-sm btn-outline-secondary" href="register.jsp">Register</a>
            </c:if>
          </div>
        </div>
      </header>