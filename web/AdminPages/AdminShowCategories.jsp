<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Categories</title>
    <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
    <link rel="stylesheet" href="css/allCategories.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
      <div class="container"><br><br>
        <div class="grow">
            <h1>&nbsp; &nbsp; Categories</h1>
        </div><br><br>
        <div id="table" class="table-editable">
           <span class="table-add glyphicon glyphicon-plus"></span>
           <table class="table">
                <tr>
                    <th>Name</th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    </tr>
                    <c:forEach items="${requestScope.catsName}" var="cat">
                      <tr>
                        <td><c:out value="${cat.categoryName}"/></td>
                        <td><a href="AdminAllProductOfCategoryController?id=${cat.idcategory}">View products</a></td>
                        <td>
                          <!--<span class="table-remove glyphicon glyphicon-remove" title="Check products before removing all?"></span>-->
                          <a href="AdminDeleteCategoryController?id_=${cat.idcategory}" title="Check products before removing all?" class="table-remove">Delete</a>
                        </td>
                        <td>
                          <span class="table-up glyphicon glyphicon-arrow-up"></span>
                          <span class="table-down glyphicon glyphicon-arrow-down"></span>
                        </td>
                      </tr>
                    </c:forEach>
      <!-- This is our clonable table line -->
                    <tr class="hide">
                    
                        <td><form action="AdminCategoryController" method="post"><input required="required" type="text" name="cat_name" placeholder="Untitled" style="border: none; border-color: transparent;"/>&nbsp;&nbsp;<button type="submit">create</button></form></td>
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
        <a href="AdminIndexController" class="btn btn-primary">Go to home page</a>
        <!--<p id="export"></p>-->
      </div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
    <script src='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore.js'></script>
    <script src="js/allCategories.js"></script>
  </body>
</html>