<!--header-->
        <%@include file="UserHeader.jsp" %>
        <!-- grow -->
        <div class="grow">
            <div class="container">
                <h2>Login</h2>
            </div>
        </div>
        <!-- grow -->
        <!--content-->
        <div class="container">
            <div class="account">
                <div class="account-pass">
                    <div class="col-md-8 account-top">
                        <form action="../LoginController" method="post">

                            <div> 	
                                <span>Email</span>
                                <input type="text" name="userEmail" id="userEmail" required> 
                            </div>
                            <div> 
                                <span >Password</span>
                                <input type="password" name="userPassword" id="userPassword" required>
                            </div>				
                            <input type="submit" value="Login"> 
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
        <%@include file="UserFooter.jsp" %>

