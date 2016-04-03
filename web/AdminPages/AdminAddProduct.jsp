<%-- 
    Document   : AdminAddProduct
    Created on : Mar 29, 2016, 9:20:26 PM
    Author     : Ehab
--%>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<!-- grow -->
<div class="grow">
    <div class="container">
        <h2>Login</h2>
    </div>
</div>

<!--content-->
<div class="container">
    <div class="account">
        <div class="account-pass">
            <div class="col-md-8 account-top">
                <form action="/WebProjectServletJsp/AdminAddProductController" method="post" enctype="MULTIPART/FORM-DATA">
                    <div> 	
                        <span>Product Name</span>
                        <input type="text" name="productName" id="productName" required> 
                    </div>
                    <div> 	
                        <span>Product Description</span>
                        <input type="text" name="productDesc" id="productDesc" required> 
                    </div>
                    <div> 	
                        <span>Product Category</span>
                        <input type="number" name="productCategory" id="productCategory" required min="0"/> 
                    </div>
                    
                    <div> 	
                        <span>Quantity Available</span>
                        <input type="number" name="productQuantityAvailable" id="productQuantityAvailable" required min="0"> 
                    </div>
                    <div> 	
                        <span>Product Price</span>
                        <input type="number" name="productPrice" id="productPrice" required min="0"> 
                    </div>
                    <div> 
                        <span >Quantity Sold</span>
                        <input type="number" name="productQuantitySold" id="productQuantitySold" required min="0">
                    </div>
                    <div> 	
                        <span>Choose File</span>
                        <input type="file" name="fileName" required>
                    </div>
                    <input type="submit" value="Add Product"> 
                </form>
            </div>
            <div class="col-md-4 left-account ">
                <a href="single.jsp"><img class="img-responsive " src="images/s1.jpg" alt=""></a>
                <div class="five">
                    <h2>25% </h2><span>discount</span>
                </div>
                <a href="register.jsp" class="create">Create an account</a>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>

</div>

<!--//content-->
<jsp:include page="AdminFooter.jsp"></jsp:include>
