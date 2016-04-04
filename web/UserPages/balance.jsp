<meta http-equiv="refresh" content="5;url=/WebProjectServletJsp/IndexController"  />
<jsp:include page="UserHeader.jsp"></jsp:include>
    <!-- grow -->

    <div class="grow">
        <div class="container">
            <h2>Out of charge</h2>
        </div>
    </div>
    <!-- grow -->
    <!--content-->

    <!--//content-->
<jsp:include  page="UserFooter.jsp"></jsp:include>
<script>
    swal({title: "no balance!", text: "sorry try again!", type: "error", confirmButtonText: "Home"}, function () {
        setTimeout(function () {
            window.open("/WebProjectServletJsp/IndexController", "_self");
        }, 100);
    });

</script>