<%-- 
    Document   : AdminEditProduct
    Created on : Mar 29, 2016, 9:20:38 PM
    Author     : Ehab
--%>

<jsp:include page="AdminHeader.jsp"></jsp:include>
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
                                    <div class="thumb-image"> <img src="/WebProjectServletJsp/productImage?imageName=${product.getProductImg()}&width=666&height=363" data-imagezoom="true" class="img-responsive"> </div>
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
                        <form action="AdminEditProductController" method="post">
                            <h3>product name: <input type="text" name="productName" style="border: 0px" value="${requestScope.product.productName}"> </h3>
                            <div class="star-on">

                                <div class="review">
                                    <a href="#"> 1 customer review </a>

                                </div>
                                <div class="clearfix"> </div>
                            </div>

                            <h5 class="item_price">price: <input type="number" style="border: 0px" name="productPrice" value="${requestScope.product.productPrice}"></h5>
                            Describtion :<input type="text" name="productDesc" style="border: 0px" value="${requestScope.product.productDescription}">
                            <div class="available">

                                <ul>
                                    <li>Available Quantity: <input type="text" style="border: 0px" size="1" name="productQuantityAvailable" value="${requestScope.product.productQuntityavailable}" >
                                        <div class="clearfix"> </div>
                                </ul>
                                <br><br><br>Desired quantity: <input type="number" style="border: 0px" 
                                                                     max = "${requestScope.product.productQuntityavailable}" min = "1" style="float: left"/><br><br>
                                <input type="hidden" name="hiddenID" value="${requestScope.product.idproduct}">
                                <h3> <input type="submit" value="Edit" class="add-cart item_add" style="background-color: #58FA82"/> </h3>

                            </div>
                        </form>
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
            <!---->

            <div class=" bottom-product">
                <div class="col-md-4 bottom-cd simpleCart_shelfItem">
                    <div class="product-at ">
                        <a href="#"><img class="img-responsive" src="images/pi3.jpg" alt="">
                            <div class="pro-grid">
                                <span class="buy-in">Buy Now</span>
                            </div>
                        </a>	
                    </div>
                    <p class="tun"><span>Lorem ipsum establish</span><br>CLARISSA</p>
                    <div class="ca-rt">
                        <a href="#" class="item_add"><p class="number item_price"><i> </i>$500.00</p></a>						
                    </div>						
                </div>
                <div class="col-md-4 bottom-cd simpleCart_shelfItem">
                    <div class="product-at ">
                        <a href="#"><img class="img-responsive" src="images/pi1.jpg" alt="">
                            <div class="pro-grid">
                                <span class="buy-in">Buy Now</span>
                            </div>
                        </a>	
                    </div>
                    <p class="tun"><span>Lorem ipsum establish</span><br>CLARISSA</p>
                    <div class="ca-rt">
                        <a href="#" class="item_add"><p class="number item_price"><i> </i>$500.00</p></a>						
                    </div>					</div>
                <div class="col-md-4 bottom-cd simpleCart_shelfItem">
                    <div class="product-at ">
                        <a href="#"><img class="img-responsive" src="images/pi4.jpg" alt="">
                            <div class="pro-grid">
                                <span class="buy-in">Buy Now</span>
                            </div>
                        </a>	
                    </div>
                    <p class="tun"><span>Lorem ipsum establish</span><br>CLARISSA</p>
                    <div class="ca-rt">
                        <a href="#" class="item_add"><p class="number item_price"><i> </i>$500.00</p></a>						
                    </div>					</div>
                <div class="clearfix"> </div>
            </div>
        </div>

        <div class="clearfix"> </div>
    </div>
</div>
<jsp:include page="AdminFooter.jsp"></jsp:include>