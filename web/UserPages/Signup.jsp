<%-- 
    Document   : Signup
    Created on : Mar 29, 2016, 9:43:55 PM
    Author     : Aya Yasser
--%>

<!DOCTYPE html>
        <%@include file="UserHeader.jsp" %>

        <!-- grow -->
        <div class="grow">
            <div class="container">
                <h2>Register</h2>
            </div>
        </div>
        <!-- grow -->
        <!--content-->
        <div class=" container">
            <div class=" register">
                
                 <form action="${pageContext.request.contextPath}/SignupController" method="post">
                    <div class="col-md-6 register-top-grid">
                        <h3>Personal infomation</h3>
                        <div>
                            <span>First Name</span>                       
                            <input type="text" name="userName" id="userName" onblur="checkName()" required value="${requestScope.user.userName}" > 
                            <font color="red" id="error_userName" ><c:if test="${check.checkName==true}">This name is logged in before</c:if></font>
                        </div>
                        <div>
                            <span>Email Address</span>
                            <input type="text" name="userEmail" id="userEmail" onblur="checkEmail()" required value="${requestScope.user.userEmail}" > 
                            <font color="red" id="error_userEmail" ><c:if test="${check.checkMail==true}">This email is logged in before</c:if></font>
                            
                        </div>
                        <div>
                            <span>SSN</span>
                            <input type="text" name="userSsn" id="userSsn"  onblur="checkSSN()" required value="<c:if test="${requestScope.user.userSsn!=null}">${requestScope.user.userSsn}</c:if>" >
                            <font color="red" id="error_userSsn" ><c:if test="${check.checkSsn==true}">This SSN is logged in before</c:if></font>
                        </div>
                        <div>
                            <span>Charge</span>
                            <input type="text" name="userCharge" id="userCharge" onblur="checkCharge()" required value="<c:if test="${requestScope.user.userCharge!=null}">${requestScope.user.userCharge}</c:if>">
                            <font color="red" id="error_checkCharge" ></font>
                        </div>
                        <a class="news-letter" href="#">
                            <label class="checkbox"><input type="checkbox" checked="" ><i> </i>Sign Up for Newsletter</label>
                        </a>
                    </div>
                    <div class="col-md-6 register-bottom-grid">
                        <h3>Login information</h3>
                        <div>
                            <span>Password</span>
                            <input type="password" name="userPassword" id="userPassword" required>
                        </div>
                        <div>
                            <span>Confirm Password</span>
                            <input type="password" id="userPasswordConfirm" onblur="checkPassword()" required>
                            <font color="red" id="error_userPassword" ></font>
                        </div>
                        
                       
                        <input type="submit" value="submit" id="submitLogin" onclick="return check()" required >
                    </div>
                    <div class="clearfix"> </div>
                </form>
            </div>
        </div>
</div>
        <!--//content-->
         <%@include file="UserFooter.jsp" %>
        
               <script type="text/javascript">
			   
               var flag_userName=0;
               var flag_userEmail=0;
               var flag_userSsn=0;
               var flag_userCharge=0;
               var flag_userPassword=0;
               var flag_userPasswordConfirm=0;
    function checkName()
                {
                    var v_name = document.getElementById("userName").value;
                    document.getElementById("error_userName").innerHTML="";
                     if(v_name=="")
                       document.getElementById("error_userName").innerHTML="You shoud enter your name";
                     else flag_userName=1;   
                        
                }
                function checkEmail()
                {
                  document.getElementById("error_userEmail").innerHTML="";
                 // document.getElementById("error_userEmailDB").innerHTML="";
                    var v_email = document.getElementById("userEmail").value;
          //        var v_emailDB=document.getElementById("error_userEmailDB").value
                       var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                        if (!filter.test(userEmail.value)) {
                        document.getElementById("error_userEmail").innerHTML="Please enter correct e-mail";
                        email.focus;}
                       
                           else{ 
                               flag_userEmail=1;}
                                
                        }
                    
                
                function checkPassword(){
                    var v_password = document.getElementById("userPassword").value;
                    var v_passwordConfirm = document.getElementById("userPasswordConfirm").value;
                    document.getElementById("error_userPassword").innerHTML="";
                    if(v_password != v_passwordConfirm)
                         document.getElementById("error_userPassword").innerHTML="Not Matched";
                     else flag_userPasswordConfirm=1;
                }
                function checkSSN(){
                    var v_ssn = document.getElementById("userSsn").value;
                    document.getElementById("error_userSsn").innerHTML="";
                    var filter2=/^\d{7}$/;
                    if (!filter2.test(userSsn.value)) {
                        document.getElementById("error_userSsn").innerHTML="Please enter correct ssn";
                        }
                    else flag_userSsn=1;
                }
                function checkCharge(){
                    var v_charge = document.getElementById("userCharge").value;
                    document.getElementById("error_checkCharge").innerHTML="";
                    var filter2=/^[+-]?\d+(\.\d+)?$/;
                    if (!filter2.test(userCharge.value)) {
                        document.getElementById("error_checkCharge").innerHTML="Please enter correct  value";
                        }
                    else flag_userCharge=1;
                }
                function check()
                {   
                 if(flag_userName==1 && flag_userEmail==1 && flag_userSsn==1 && flag_userPasswordConfirm==1){
                        return true;
                 }
                 else {
                     checkName();
                     checkEmail();
                     checkPassword();
                     checkSSN();
                     checkCharge();
                     
                  return false;
                 }
                }                       
            </script>
    </body>
</html>
