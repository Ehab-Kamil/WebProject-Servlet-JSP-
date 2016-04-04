
<!DOCTYPE html>
        <!--header-->
        
        <jsp:include page="UserHeader.jsp"></jsp:include>
            <!-- grow -->
            
            <div class="grow">
                <div class="container">
                    <h2>Out of charge</h2>
                </div>
            </div>
            <!-- grow -->
            <!--content-->
                swal({title: "Game Over!", text: "sorry try again!", type: "error", confirmButtonText: "Home"}, function () {
                setTimeout(function () {
                    window.open("home.html", "_self");
                }, 100);
            });
            <!--//content-->
                    <jsp:include  page="UserFooter.jsp"></jsp:include>
      
