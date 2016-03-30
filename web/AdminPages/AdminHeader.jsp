<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Musican Shop</title>
        <link href="/WebProjectServletJsp/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="/WebProjectServletJsp/js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <!--theme-style-->
        <link href="/WebProjectServletJsp/css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Mattress Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
        <!-- start menu -->
        <link href="/WebProjectServletJsp/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="/WebProjectServletJsp/js/memenu.js"></script>
        <script>$(document).ready(function () {
                $(".memenu").memenu();
            });</script>
        <!--pop-up-->
        <script src="/WebProjectServletJsp/js/menu_jquery.js"></script>
        <!--//pop-up-->	
        <script src="/WebProjectServletJsp/js/simpleCart.min.js"></script>
    </head>
    <body>
        <%--<jsp:useBean id="user" class="entity.Users" scope="session"/>--%>               
        <div class="header">
            <div class="header-top">
                <div class="container">
                    <div class="social">
                        <ul>
                            <li><a href="#"><i class="facebok"> </i></a></li>
                            <li><a href="#"><i class="twiter"> </i></a></li>
                            <li><a href="#"><i class="inst"> </i></a></li>
                            <li><a href="#"><i class="goog"> </i></a></li>
                            <li><i id="visitor" style="color: #ffffff">Visitor:${applicationScope.visitor}</i></li>
                            <li><i id="online" style="color: #ffffff">Online:${applicationScope.online}</i></li>

                        </ul>
                    </div>
                    <div class="header-left">

                        <div class="search-box">
                            <div id="sb-search" class="sb-search">
                                <form method="get" action="SearchController">

                                    <input class="sb-search-input" placeholder="Enter your search term..." type="search"  name="search">
                                    <input class="sb-search-submit" type="submit" value="search"  name="action" >
                                    <span class="sb-icon-search"> </span>
                                </form>

                            </div>
                        </div>

                        <!-- search-scripts -->
                        <script src="/WebProjectServletJsp/js/classie.js"></script>
                        <script src="/WebProjectServletJsp/js/uisearch.js"></script>
                        <script>
            new UISearch(document.getElementById('sb-search'));
                        </script>
                        <!-- //search-scripts -->

                       
                        <div class="clearfix"> </div>
                    </div>

                </div>
            </div>
            <div class="container">
                <div class="head-top">
                    <div class="logo">
                        <h1><a href="index.jsp">Music Store</a></h1>
                    </div>
                    <div class=" h_menu4">
                        <ul class="memenu skyblue">
                           
                             
                             <li><a href="/WebProject/AdminAllCategoriesController" id="color4"><span>Show All Categories</span></a></li>
                             <li><a href="/WebProjectServletJsp/AdminProductController" id="color4"><span>Show All Products</span></a></li>
                             <li><a href="/WebProject/AdminAllUsersController" id="color4"><span>Show All User</span></a></li>
                        </ul> 
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
