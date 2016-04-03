
<!DOCTYPE html>
<!--header-->
<html>
    <head>
         <title>Musican Shop</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
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
        <link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/memenu.js"></script>
        <script>$(document).ready(function () {
                $(".memenu").memenu();
            });</script>
        <script src="js/simpleCart.min.js"></script>
    </head>
    <body>
        <jsp:include  page="UserHeader.jsp"></jsp:include>
    <!-- grow -->
<jsp:useBean id="CartProduct" class="entity.CartProduct" scope="request"></jsp:useBean>
    <div class="grow">
        <div class="container">
            <h2>Single</h2>
        </div>
    </div>
    <!-- grow -->
    <div class="product">
        <div class="container">

            <div class="product-price1">
                <div class="top-sing">
                    <div class="col-md-7 single-top">	
                        <div class="flexslider">
                            <ul class="slides">
                                <li data-thumb="images/si.jpg">
                                    <div class="thumb-image"> <img src="/WebProjectServletJsp/productImage?imageName=${product.getProductImg()}&width=666&height=666" data-imagezoom="true" class="img-responsive"> </div>
                            </li>

                        </ul>
                    </div>

                    <div class="clearfix"> </div>
                    <!-- slide -->


                    <!-- FlexSlider -->
                    <script defer src="js/jquery.flexslider.js"></script>
                    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

                    <script>
                        // Can also be used with $(document).ready()
                        $(window).load(function () {
                            $('.flexslider').flexslider({
                                animation: "slide",
                                controlNav: "thumbnails"
                            });
                        });
                    </script>
                </div>	
                <div class="col-md-5 single-top-in simpleCart_shelfItem">
                    <div class="single-para ">
                        <h4>${requestScope.product.productName}</h4>
                        <div class="star-on">

                            <div class="review">
                                <a href="#"> 1 customer review </a>

                            </div>
                            <div class="clearfix"> </div>
                        </div>

                        <h5 class="item_price">$ ${requestScope.product.productPrice}</h5>
                        <p>${requestScope.product.productDescription}</p>
                        <div class="available">
                            <form action="/WebProjectServletJsp/AddToCartController" method="post">
                            <ul>
                                <li>Available Quantity: <input type="text" style="border: 0px" size="1" value="${requestScope.product.productQuntityavailable}" readonly>
                                <div class="clearfix"> </div>
                            </ul>
                            Desired quantity: <input type="number" name="productMount" max = "${requestScope.product.productQuntityavailable}" min = "1" style="float: left"/><br><br>
                            <input type="hidden" name="idproduct" value="${requestScope.product.idproduct}"/>
                            <input type="submit" value="ADD TO CART" class="add-cart item_add" style="background-color: #58FA82"/>
                            </form>
                        </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <!---->
            </div>
        </div>
    </div>
    <!--//content-->
    <jsp:include page="UserFooter.jsp"></jsp:include>
    </body>
</html>
