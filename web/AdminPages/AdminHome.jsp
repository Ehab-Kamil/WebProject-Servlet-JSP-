<%-- 
    Document   : AdminHome
    Created on : Mar 29, 2016, 9:18:22 PM
    Author     : Ehab
--%>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel='stylesheet prefetch' href='css/bootstrap.css'>
<br>
<center>
<a href="/WebProjectServletJsp/AdminCategoryController" class="btn btn-primary">Categories</a>
<a href="/WebProjectServletJsp/AdminUserController" class="btn btn-primary">Users</a>
<a href="/WebProjectServletJsp/AdminProductController" class="btn btn-primary">Products</a>
</center>
<br>
<jsp:include page="AdminFooter.jsp"></jsp:include>
