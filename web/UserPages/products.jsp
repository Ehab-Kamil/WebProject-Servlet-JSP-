<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="UserHeader.jsp"></jsp:include>
<!DOCTYPE html>
        <!-- products -->
        <!-- grow -->
        <div class="grow">
            <div class="container">
                <h2>Products</h2>
            </div>     
        </div>
        <!-- grow -->
        <div class="pro-du">
            <div><h1 align="center" style="color:grey;"><c:out value="${requestScope.foundMatch}"/></h1></div>
            <div class="container">
                <div class="col-md-9 product1">
                    <div class=" bottom-product">
                        <c:forEach items="${requestScope.productList}" var="product"> 
                            <div class="col-md-6 bottom-cd simpleCart_shelfItem">
                                <div class="product-at ">
                                    <a href="single.html"><img class="img-responsive one" src="/WebProjectServletJsp/productImage?imageName=${product.getProductImg()}&width=800&height=600" style="border:3px solid #8CE78A" alt="">
                                        <div class="pro-grid">
                                            <span class="buy-in">Buy Now</span>
                                        </div>
                                    </a>	
                                </div>
                                <p class="tun"><span><c:out value="${product.getProductName()}"/></span><br><c:out value="${product.getCategories().getCategoryName()}"/></p>
                                <div class="ca-rt">
                                    <a href="#" class="item_add"><p class="number item_price"><i> </i><c:out value="${product.getProductPrice()}"/></p></a>						
                                </div>
                                <div class="clearfix"></div>

                            </div>  
                        </c:forEach>

                    </div>
                </div>
            </div>
            <!-- products -->
<jsp:include page="UserFooter.jsp"></jsp:include>
