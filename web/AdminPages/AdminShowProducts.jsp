<%-- 
    Document   : AdminShowProducts
    Created on : Mar 29, 2016, 9:20:05 PM
    Author     : Ehab
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>HTML5 Editable Table</title>
        <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
        <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
        <link rel="stylesheet" href="/WebProjectServletJsp/css/allCategories.css">
        <link rel="stylesheet" href="/WebProjectServletJsp/css/style.css">
    </head>
    <body>
        <div class="container"><br><br>
            <div class="grow">
                <h1>&nbsp; &nbsp; Products</h1>
            </div><br><br>
            <div id="table" class="table-editable">
                <span class="table-add glyphicon glyphicon-plus"></span>
                <table class="table" bgcolor="#006600">
                    <tr>
                        <th>Name</th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>

                    <c:forEach items="${requestScope.categories}" var="cat">
                        <c:forEach items="${cat.productCollection}" var="Product">
                            <tr><td contenteditable="true"><c:out value="${Product.idproduct}"/></td>
                                <td>
                                    <c:out value="${Product.productName}"/>
                                </td>
                                <td>
                                    <c:out value="${Product.productPrice}"/>
                                </td>
                                <td>
                                    <c:out value="${cat.categoryName}"/>
                                </td>
                            </tr>     
                        </c:forEach>
                    </c:forEach>
                    <!-- This is our clonable table line -->
                    <tr class="hide">
                        <td contenteditable="true">Untitled</td>
                        <td><a href="/WebProject/EditCategoryController?cid=0">Edit</a>
                        <td>View products</td>
                        <td>
                            <!--<span class="table-remove glyphicon glyphicon-remove"></span>-->
                            <a class="table-remove1">Delete</a>
                        </td>
                        <td>
                            <span class="table-up glyphicon glyphicon-arrow-up"></span>
                            <span class="table-down glyphicon glyphicon-arrow-down"></span>
                        </td>
                    </tr>
                </table>
            </div>
            <!--<button id="export-btn" class="btn btn-primary" >Export</button>-->
            <a href="/WebProject/AdminIndexController" class="btn btn-primary">Go to home page</a>
            <!--<p id="export"></p>-->
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
        <script src='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore.js'></script>
        <script src="js/allCategories.js"></script>
    </body>
</html>
<br>
<jsp:include page="AdminFooter.jsp"></jsp:include>

