<%-- 
    Document   : mainpage
    Created on : Jun 30, 2021, 2:13:48 PM
    Author     : ASUS-PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            * {
                box-sizing: border-box;
            }

            /* Style the body */
            body {
                font-family: Arial, Helvetica, sans-serif;
                margin: 0;
            }

            /* Header/logo Title */
            .header {
                padding-bottom: 20px;
                /*                text-align: center;
                                color: #EEE8AA;*/
                background: #FFD700;
            }

            /* Increase the font size of the heading */
            .header h1 {
                font-size: 40px;
            }

            /* Style the top navigation bar */
            .navbar {
                background-color: #333;
            }

            /* Style the navigation bar links */
            .navbar a {
                float: left;
                display: block;
                color: white;
                text-align: center;
                padding: 11px 20px;
                text-decoration: none;
            }

            .navbar a input[type=text] {
                border: 1px solid #ccc;
            }


            /* Right-aligned link */
            .navbar a.right {
                float: right;
            }

            /* Change color on hover */
            .navbar a:hover {
                background-color: #ddd;
                color: black;
            }

            /* Column container */
            .row {  
                display: -ms-flexbox; /* IE10 */
                display: flex;
                -ms-flex-wrap: wrap; /* IE10 */
                flex-wrap: wrap;
            }

            /* Create two unequal columns that sits next to each other */
            /* Sidebar/left column */
            .side {
                -ms-flex: 30%; /* IE10 */
                flex: 13%;
                background-color: #f1f1f1;
                padding: 20px;
            }

            .side h2 {
                padding-top: 20px;
            }

            /* Main column */
            .main {   
                -ms-flex: 70%; /* IE10 */
                flex: 70%;
                background-color: white;
                padding: 20px;
            }

            /* Fake image, just for this example */
            .fakeimg {
                background-color: #aaa;
                width: 100%;
                padding: 20px;
            }

            /* Footer */
            .footer {
                padding: 20px;
                text-align: center;
                background: #ddd;
            }

            /* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 700px) {
                .row {   
                    flex-direction: column;
                }
            }

            /* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
            @media screen and (max-width: 400px) {
                .navbar a {
                    float: none;
                    width: 100%;
                }
            }

            /*            //Slide show images*/
            * {box-sizing: border-box;}
            body {font-family: Verdana, sans-serif;}
            .mySlides {display: none;}
            img {vertical-align: middle;}

            /* Slideshow container */
            .slideshow-container {
                max-width: 100%;
                position: relative;
                margin: auto;
            }

            /* Caption text */
            .text {
                color: #f2f2f2;
                font-size: 15px;
                padding: 8px 12px;
                position: absolute;
                bottom: 8px;
                width: 100%;
                text-align: center;
            }

            /* Number text (1/3 etc) */
            .numbertext {
                color: #f2f2f2;
                font-size: 12px;
                padding: 8px 12px;
                position: absolute;
                top: 0;
            }

            /* The dots/bullets/indicators */
            .dot {
                height: 15px;
                width: 15px;
                margin: 0 2px;
                background-color: #bbb;
                border-radius: 50%;
                display: inline-block;
                transition: background-color 0.6s ease;
            }

            .active {
                background-color: #717171;
            }

            /* Fading animation */
            .fade {
                -webkit-animation-name: fade;
                -webkit-animation-duration: 1.5s;
                animation-name: fade;
                animation-duration: 1.5s;
            }

            @-webkit-keyframes fade {
                from {opacity: .4} 
                to {opacity: 1}
            }

            @keyframes fade {
                from {opacity: .4} 
                to {opacity: 1}
            }

            /* On smaller screens, decrease text size */
            @media only screen and (max-width: 300px) {
                .text {font-size: 11px}
            }

            /*            Search Bar*/
            form.searchbar input[type=text] {
                padding: 10px;
                font-size: 17px;
                border: 1px solid grey;
                float: left;
                width: 80%;
                background: #f1f1f1;
                height: 89%;
                width: 45%;
            }

            form.searchbar button {
                float: left;
                padding: 10px;
                background: #2196F3;
                color: white;
                font-size: 17px;
                border: 1px solid grey;
                border-left: none;
                cursor: pointer;
                height: 89%;
                width: 50px;
            }

            form.searchbar button:hover {
                background: #0b7dda;
            }

            form.searchbar::after {
                content: "";
                clear: both;
                display: table;
            }

            /*            Grid */

            .grid-container {
                display: grid;
                grid-gap: 50px 100px;
                grid-template-columns: auto auto auto;
                /*                background-color: rgba(247, 228, 57, 0.8);*/
                padding: 10px;
            }

            .grid-item {
                /*                background-color: rgba(255, 255, 255, 0.8);*/
                border: 1px solid rgba(0, 0, 0, 0.8);
                padding: 20px;
                font-size: 30px;
                text-align: center;
                height: 470px;
                width: 290px;
            }
        </style>


        <!--        open Login button -->
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            * {box-sizing: border-box;}

            /* Button used to open the contact form - fixed at the bottom of the page */
            .open-button {
                background-color: #555;
                color: white;
                padding: 16px 20px;
                border: none;
                cursor: pointer;
                opacity: 0.8;
                position: fixed;
                bottom: 23px;
                right: 28px;
                width: 280px;
            }

            /* The popup form - hidden by default */
            .form-popup {
                display: none;
                position: fixed;
                bottom: 0;
                right: 15px;
                border: 3px solid #f1f1f1;
                z-index: 9;
            }

            /* Add styles to the form container */
            .form-container {
                max-width: 300px;
                padding: 10px;
                background-color: white;
            }

            /* Full-width input fields */
            .form-container input[type=text], .form-container input[type=password] {
                width: 100%;
                padding: 15px;
                margin: 5px 0 22px 0;
                border: none;
                background: #f1f1f1;
            }

            /* When the inputs get focus, do something */
            .form-container input[type=text]:focus, .form-container input[type=password]:focus {
                background-color: #ddd;
                outline: none;
            }

            /* Set a style for the submit/login button */
            .form-container .btn {
                background-color: #04AA6D;
                color: white;
                padding: 16px 20px;
                border: none;
                cursor: pointer;
                width: 100%;
                margin-bottom:10px;
                opacity: 0.8;
            }

            /* Add a red background color to the cancel button */
            .form-container .cancel {
                background-color: red;
            }

            /* Add some hover effects to buttons */
            .form-container .btn:hover, .open-button:hover {
                opacity: 1;
            }
        </style>

        <!--        drop down menu-->
        <style>
            .dropbtn {
                background-color: #333;
                color: white;
                padding: 11px;
                font-size: 16px;
                border: none;
                cursor: pointer;
            }

            .dropbtn:hover, .dropbtn:focus {
                background-color: #ddd;
                color: black;
            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f1f1f1;
                min-width: 160px;
                overflow: auto;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown a:hover {background-color: #ddd;}

            .show {display: block;}

            .dropdown-content button {
                float: left;
                display: block;
                color: white;
                text-align: center;
                padding: 11px 63px;
                font-size: 16px;
                text-decoration: none;
                background-color: #333;
                min-width: 160px;
            }

            .dropdown-content button:hover {
                background-color: #ddd;
                color: black;
            }

            .dropdown-content a {
                float: left;
                display: block;
                color: white;
                text-align: center;
                padding: 11px 63px;
                font-size: 12px;
                text-decoration: none;
                background-color: #333;
                min-width: 160px;
            }

            .dropdown-content a:hover {
                background-color: #ddd;
                color: black;
            }
        </style>

        <!--        Products -->
        <style>
            #img {
                float: none;
            }

            #proName {
                font-family: Arial, sans-serifl;
                font-size: 15px;
                float: left;
                width: 100%;
                padding-top: 15px;
                height: 10%;
            }

            #price {
                font-family: Arial, sans-serifl;
                font-size: 24px;
                padding-top: 58px; 
            }

            #addtocart {

                background-color: #4CAF50;
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;

            }
        </style>
        <title>Main Page</title>
    </head>
    <body>
        <div class="header">
            <!--        slideshow images-->

            <div class="slideshow-container">

                <div class="mySlides fade">
                    <!--                    <div class="numbertext">1 / 3</div>-->
                    <img src="images/banner_1.jpg" style="width:100%">
                    <!--                <div class="text">Rolex</div>-->
                </div>

                <div class="mySlides fade">
                    <!--                    <div class="numbertext">2 / 3</div>-->
                    <img src="images/banner_2.png" style="width:100%">
                    <!--                <div class="text">Caption Two</div>-->
                </div>

                <div class="mySlides fade">
                    <!--                    <div class="numbertext">3 / 3</div>-->
                    <img src="images/banner_3.jpg" style="width:100%">
                    <!--                <div class="text">Caption Three</div>-->
                </div>

                <div class="mySlides fade">
                    <!--                    <div class="numbertext">3 / 3</div>-->
                    <img src="images/banner_4.jpg" style="width:100%">
                    <!--                <div class="text">Caption Three</div>-->
                </div>

            </div>
            <br>

            <div style="text-align:center">
                <span class="dot"></span> 
                <span class="dot"></span> 
                <span class="dot"></span> 
                <span class="dot"></span> 
            </div>

        </div>

        <div class="navbar" style="display: flex;justify-content: space-between;">
            <div style="width: 50%">
                <a href="ShowController">Home</a>
                <form class="searchbar" action="MainController" method="POST">
                    <input type="text" placeholder="Search......" name="txtSearch">
                    <button type="submit" name="action" value="Search"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <div>
                <c:if test="${sessionScope.ROLE == 'US' || sessionScope.ROLE == null}">
                    <a href="cart.jsp" class="right">View Your Cart</a>
                </c:if>
                <c:if test="${sessionScope.ROLE == 'AD'}">
                    <a href="SearchByADController">Manage Product</a>
                </c:if>
                <!--                drop down menu-->
                <c:if test="${sessionScope.LOGIN_USER.fullName != null}">
                    <div class="dropdown">
                        <button onclick="dropdown()" class="dropbtn">
                            Welcome ${sessionScope.LOGIN_USER.fullName}
                        </button>
                        <div id="myDropdown" class="dropdown-content">
                            <form action="MainController" method="POST">
                                <button type="submit" name="action" value="Logout"> Logout </button>
                            </form>
                        </div>
                    </div>
                </c:if>


            </div>
        </div>
        <!--        Login Button-->
        <c:if  test="${sessionScope.LOGIN_USER.fullName == null}">
            <button class="open-button" onclick="openForm()">Login</button>

            <div class="form-popup" id="myForm">
                <form action="MainController" method="POST" class="form-container">
                    <h1>Login</h1>
                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="userID" required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" required>

                    <button type="submit" name="action" value="Login" class="btn">Login</button>
                    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
                </form>
            </div>
        </c:if> 


        <div class="row">
            <div class="side">
                <h2>Men</h2>
                <h2>Woman</h2>
                <h2>Rolex</h2>
                <h2>Hublot</h2>
                <h2>Patek Philippe</h2>
                <h2>Audemars Piguet</h2>
            </div>
            <div class="main">
                <c:if test="${requestScope.LIST_WATCHES != null}">
                    <c:if test="${not empty requestScope.LIST_WATCHES}">
                        <div class="grid-container">
                            <c:forEach var="dto" items="${requestScope.LIST_WATCHES}">                            
                                <div class="grid-item">
                                    <div id="img">
                                        <img  src="images/${dto.image}" />
                                    </div>
                                    <div id="proName"><a>${dto.productName}</a></div>
                                    <div id="price"><a>$${dto.price}</a></div>

                                    <c:url var="AddtoCart" value="MainController">
                                        <c:param name="productID" value="${dto.productID}"/>
                                        <c:param name="action" value="Add to Cart"></c:param>
                                        <c:param name="productID" value="${dto.productID}"></c:param>
                                    </c:url>    
                                    <a onclick="loginCheck()" href="${AddtoCart}" id="addtocart">Add To Cart</a>
                                </div>
                            </c:forEach>
                        </div>
                    </c:if>
                </c:if>
            </div>
        </div>

        <div class="footer">

            <!-- Footer -->
            <footer class="w3-padding-64 w3-light-grey w3-small w3-center" id="footer">
                <div class="w3-row-padding">
                    <div class="w3-col s4">
                        <h4>Contact</h4>
                        <p>Questions? Go ahead.</p>
                        <form action="/action_page.php" target="_blank">
                            <p><input class="w3-input w3-border" type="text" placeholder="Name" name="Name" required></p>
                            <p><input class="w3-input w3-border" type="text" placeholder="Email" name="Email" required></p>
                            <p><input class="w3-input w3-border" type="text" placeholder="Subject" name="Subject" required></p>
                            <p><input class="w3-input w3-border" type="text" placeholder="Message" name="Message" required></p>
                            <button type="submit" class="w3-button w3-block w3-black">Send</button>
                        </form>
                    </div>

                    <div class="w3-col s4">
                        <h4>About</h4>
                        <p><a href="#">About us</a></p>
                        <p><a href="#">We're hiring</a></p>
                        <p><a href="#">Support</a></p>
                        <p><a href="#">Find store</a></p>
                        <p><a href="#">Shipment</a></p>
                        <p><a href="#">Payment</a></p>
                        <p><a href="#">Gift card</a></p>
                        <p><a href="#">Return</a></p>
                        <p><a href="#">Help</a></p>
                    </div>

                    <div class="w3-col s4 w3-justify">
                        <h4>Store</h4>
                        <p><i class="fa fa-fw fa-map-marker"></i> Group 12</p>
                        <p><i class="fa fa-fw fa-phone"></i> 0044123123</p>
                        <p><i class="fa fa-fw fa-envelope"></i> group12@gmail.com</p>
                        <h4>We accept</h4>
                        <p><i class="fa fa-fw fa-cc-amex"></i> Amex</p>
                        <p><i class="fa fa-fw fa-credit-card"></i> Credit Card</p>
                        <br>
                        <i class="fa fa-facebook-official w3-hover-opacity w3-large"></i>
                        <i class="fa fa-instagram w3-hover-opacity w3-large"></i>
                        <i class="fa fa-snapchat w3-hover-opacity w3-large"></i>
                        <i class="fa fa-pinterest-p w3-hover-opacity w3-large"></i>
                        <i class="fa fa-twitter w3-hover-opacity w3-large"></i>
                        <i class="fa fa-linkedin w3-hover-opacity w3-large"></i>
                    </div>
                </div>
            </footer>

        </div>


        <!--        Slides show-->
        <script>
            var slideIndex = 0;
            showSlides();

            function showSlides() {
                var i;
                var slides = document.getElementsByClassName("mySlides");
                var dots = document.getElementsByClassName("dot");
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";
                }
                slideIndex++;
                if (slideIndex > slides.length) {
                    slideIndex = 1
                }
                for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" active", "");
                }
                slides[slideIndex - 1].style.display = "block";
                dots[slideIndex - 1].className += " active";
                setTimeout(showSlides, 5500); // Change image every 2 seconds
            }
        </script>

        <!--        Open Login-->
        <script>
            function openForm() {
                document.getElementById("myForm").style.display = "block";
            }

            function closeForm() {
                document.getElementById("myForm").style.display = "none";
            }
        </script>


        <!--        drop down menu  -->
        <script>
            /* When the user clicks on the button, 
             toggle between hiding and showing the dropdown content */
            function dropdown() {
                document.getElementById("myDropdown").classList.toggle("show");
            }

            // Close the dropdown if the user clicks outside of it
            window.onclick = function (event) {
                if (!event.target.matches('.dropbtn')) {
                    var dropdowns = document.getElementsByClassName("dropdown-content");
                    var i;
                    for (i = 0; i < dropdowns.length; i++) {
                        var openDropdown = dropdowns[i];
                        if (openDropdown.classList.contains('show')) {
                            openDropdown.classList.remove('show');
                        }
                    }
                }
            }
        </script>

        <!--        Add to cart-->
        <script>
            function loginCheck() {
                if (${sessionScope.LOGIN_USER == null}) {
                    alert("Hãy đăng nhập trước khi mua hàng!!!");
                }
            }
        </script>

    </body>
</html>
