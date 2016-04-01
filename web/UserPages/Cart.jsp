
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="UserHeader.jsp"></jsp:include>
<jsp:useBean id="user" class="entity.Users" scope="session"/>  
<!-- grow -->
<div class="grow">
    <div class="container">
        <h2>Cart</h2>
    </div>
</div>
<!-- grow -->
<div class="container">
    <div class="check">	 
        <h1>My Shopping Bag (${sessionScope.user.cartProductCollection.size()})</h1>
        <div class="col-md-9 cart-items">

            <c:set var="totalpayment" value="0" scope="page"/>
            <c:forEach items="${user.cartProductCollection}" var="productList">
                <c:if test="${productList.paymentIdpayment.idpayment!=0}">
                    <div class="cart-header">
                        <div class="cart-sec simpleCart_shelfItem">
                            <div class="cart-item cyc">
                                <img src="${productList.product.productImg}" class="img-responsive" alt=""/>
                            </div>
                            <div class="cart-item-info">
                                <h3><a href="#">${productList.product.productName}</a><span>Category:${productList.product.categories.categoryName}</span></h3>
                                <ul class="qty">
                                    <li><p>Size : ${productList.productsize}</p></li>
                                    <li><p>Qty : ${productList.cartProductMount}</p></li>
                                    <li><p>Color : ${productList.productColor}</p></li>
                                    <li><p>Total : ${productList.totalProduct}</p></li>
                                    <c:set var="totalpayment" value="${totalpayment+productList.totalProduct}" scope="page"/>                                    
                                </ul>
                                <div class="delivery">
                                    <ul class="qty">
                                        <li><p>Last Modification : ${productList.cartProductDate}</p></li>
                                        <li><p><a href="BuyCartController?idcartProduct=${productList.idcartProduct}"><img src="images/buy-32.jpg"></a></p></li>
                                        <li><p><a href="SingleProductController?id=${productList.product.idproduct}"><img src="images/edit-4-32.jpg"></a></p></li>
                                        <li><p><a href="DeleteCartController?idcartProduct=${productList.product.idproduct}"><img src="images/delete-32.jpg"></a></p></li>
                                    </ul>
                                </div>	
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="col-md-3 cart-total">
            <a class="continue" href="#">Payment</a>
            <div class="price-details">
                <h3>Price Details</h3>
                <span>Total</span>
                <span class="total1">${totalpayment}</span>
                <span>Discount</span>
                <span class="total1">---</span>
                <span>Delivery Charges</span>
                <span class="total1">100.00</span>
                <div class="clearfix"></div>				 
            </div>	
            <ul class="total_price">
                <li class="last_price"> <h4>TOTAL</h4></li>	
                <li class="last_price"><span>${totalpayment+100}</span></li>
                <div class="clearfix">
                </div>
            </ul>
            <div class="clearfix"></div>
            <a class="order" href="#">Place Order</a>
            <div class="total-item">
                <h3>OPTIONS</h3>
                <h4>COUPONS</h4>
                <a class="cpns" href="#">Apply Coupons</a>
                <p><a href="#">Log In</a> to use accounts - linked coupons</p>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<jsp:include page="UserFooter.jsp"></jsp:include>
