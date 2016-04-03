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
                <table class="table" bgcolor="#006600">
                    <tr>
                        <th>Id</th>
                        <th>Product Name</th>
                        <th>Product Price</th>
                        <th>Product Category</th>
                    </tr>
                    <c:if test="${requestScope.categories !=null}">
                    <c:forEach items="${requestScope.categories}" var="cat">
                        <c:forEach items="${cat.productCollection}" var="Product">
                            <%--<c:forEach items="${cat.products}" var="Product">--%>
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
                                <td>
                                    <a href="/WebProjectServletJsp/AdminEditProductController?pid=${Product.idproduct}" class="btn btn-primary">Edit</a>
                                </td>
                            </tr>     
                        </c:forEach>
                    </c:forEach>
                    </c:if> 
                        <c:if test="${requestScope.category !=null}">
                            <c:forEach items="${cat.productCollection}" var="Product">
                            <%--<c:forEach items="${cat.products}" var="Product">--%>
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
                                <td>
                                    <a href="/WebProjectServletJsp/AdminEditProductController?pid=${Product.idproduct}" class="btn btn-primary">Edit</a>
                                </td>
                            </tr>     
                        </c:forEach>
                        </c:if>
                </table>
            </div>
            <!--<button id="export-btn" class="btn btn-primary" >Export</button>-->
            <a href="/WebProjectServletJsp/AdminPages/AdminAddProduct.jsp" class="btn btn-primary">Add Product</a>
            <a href="/WebProjectServletJsp/AdminIndexController" class="btn btn-primary">Go to home page</a>
            <!--<p id="export"></p>-->
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
        <script src='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore.js'></script>
        <script src="/WebProjectServletJsp/js/allCategories.js"></script>
    </body>
</html>
<br>
<jsp:include page="AdminFooter.jsp"></jsp:include>

