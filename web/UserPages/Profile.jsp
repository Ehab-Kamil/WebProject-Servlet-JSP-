<%-- 
    Document   : Profile
    Created on : Mar 29, 2016, 9:44:11 PM
    Author     : Ehab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         
        
        <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
        <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
        <link rel="stylesheet" href="/WebProjectServletJsp/css/allCategories.css">
        <link rel="stylesheet" href="/WebProjectServletJsp/css/style.css">
    </head>
    <body>
        <h1>Hello World!</h1>
        <span><c:out value="${requestScope.b_total}"/></span>
    </body>
</html>
