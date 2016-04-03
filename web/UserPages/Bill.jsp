<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/

-->








<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="UserHeader.jsp"></jsp:include>
        <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
        <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
        <link rel="stylesheet" href="/WebProjectServletJsp/css/allCategories.css">
        <link rel="stylesheet" href="/WebProjectServletJsp/css/style.css">
    </head>
    <body>
<!DOCTYPE html>

        <!-- grow -->
        <div class="grow">
            <div class="container">
                <h2>Payment</h2>
            </div>
        </div>
        <!-- grow -->
        <div class="container">
            <div class="check">	 
                <h1>Shopping Payment</h1>
                <div class="col-md-9 cart-items">
                    <c:forEach items="${sessionScope.cartProducts}" var="row">

                        
                        
                        <script>$(document).ready(function (c) {
                            $('.close1').on('click', function (c) {
                                $('.cart-header').fadeOut('slow', function (c) {
                                    $('.cart-header').remove();
                                });
                            });
                        });
                    </script>

                      
                    <div class="cart-header">
                        
                        <div class="cart-sec simpleCart_shelfItem">
                           
                            <div class="cart-item-info">
                                <h3><a href="#"><c:out value="${row.getProduct().getProductName()}"/></a></h3>
                                <ul class="qty">
                                     <li><p>Quantity : <c:out value="${row.getCartProductMount()}"/></p></li>
                                <li><p>price : <c:out value="${row.getProduct().getProductPrice()}"/></p></li>
                                </ul>

                                	
                            </div>
                            <div class="clearfix"></div>

                        </div>
                    </div>
                    </c:forEach> 
                 		
                </div>
                <div class="col-md-3 cart-total">
                    <a class="continue" href="#"></a>
                    <div class="price-details">
                        <h3>Price Details</h3>
                        <span>Total</span>
                        <span class="total1"><c:out value="${sessionScope.b_total}"/></span>
                        <span>Discount</span>
                        <span class="total1"><c:out value="${sessionScope.payment.getPaymentDiscount()}"/></span>
                        <div class="clearfix"></div>				 
                    </div>
                      
                      
                    <ul class="total_price">
                        <li class="last_price"> <h4>TOTAL</h4></li>	
                        <li class="last_price"><span><fmt:formatNumber value="${sessionScope.b_total - sessionScope.payment.getPaymentDiscount()}" maxFractionDigits="2" /> </span></li>
                        <div class="clearfix"> </div>
                    </ul>


                    <div class="clearfix"></div>
                    <a class="order" href="#"></a>
                    <div class="total-item">
                       
                    </div>
                </div>

                <div class="clearfix"> </div>
            </div>
        </div>


                        <jsp:include page="UserFooter.jsp"></jsp:include>