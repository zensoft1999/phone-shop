<%-- 
    Document   : cart
    Created on : Jul 11, 2021, 11:52:39 AM
    Author     : ASUS-PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>Cart Page</title>

        <!--        Page-->
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
                padding: 80px;
                text-align: center;
                background: #1abc9c;
                color: white;
            }

            /* Increase the font size of the heading */
            .header h1 {
                font-size: 40px;
            }

            /* Style the top navigation bar */
            .navbar {
                overflow: hidden;
                background-color: #333;
            }

            /* Style the navigation bar links */
            .navbar a {
                float: left;
                display: block;
                color: white;
                text-align: center;
                padding: 14px 20px;
                text-decoration: none;
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
            /*            .side {
                            -ms-flex: 30%;  IE10 
                            flex: 30%;
                            background-color: #f1f1f1;
                            padding: 20px;
                        }*/

            /* Main column */
            .main {   
                width: 100%; 
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
        </style>

        <!--        Table-->
        <style>
            #products {
                font-family: Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #products td, #products th {
                border: 1px solid #ddd;
                padding: 5px;
            }

            #products tr:nth-child(even){background-color: #f2f2f2;}

            #products tr:hover {background-color: #ddd;}

            #products th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #04AA6D;
                color: white;

            }


        </style>

        <!--                button-->
        <style>
            #btn {
                background-color: #4CAF50;
                border: none;
                color: white;
                padding: 8px 12px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                margin: 1px 1px;
                cursor: pointer;
            }
        </style>

        <!--  Continue to shopping-->
        <style>
            .shopping {
                padding-top: 10px;
            }

            .remove {
                float: right;
            }
        </style>
    </head>
    <body>

        <div class="header">
            <h1>Cart</h1>
        </div>

        <div class="navbar">
            <a href="ShowController">Home</a>
            <a href="LogoutController" class="right">Logout</a>
        </div>

        <div class="row">
            <!--            <div class="side">
                        </div>-->
            <div class="main">
                
                <c:if test="${sessionScope.USER_CART == null}">
                    <h1 style="color: red"> Your cart is empty!!!!</h1>
                    <a id="btn" href="ShowController">Continue to Shopping</a>
                </c:if>

                <c:if test="${sessionScope.USER_CART != null}">
                    <h2>List Of Product:</h2>
                    <table id="products">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Product ID</th>
                                <th>Quantity</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <form action="MainController" method="POST">                            
                            <c:forEach var="dto" varStatus="counter" items="${sessionScope.USER_CART.items}">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${dto.key}</td>
                                    <td>${dto.value}</td>
                                    <td>
                                        <input type="checkbox" name="chekItem" value="${dto.key}" />
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td><a id="btn" href="ShowController">Continue to Shopping</a></td>
                                <td colspan="3" style="text-align: right">
                                    <input id="btn" type="submit" value="Remove Selected Item" name="action"/>
                                </td>
                            </tr>

                        </form>
                        </tbody>
                    </table>
                    <form action="MainController" method="POST">
                        <input id="btn" type="submit" value="Check out" name="action" />
                    </form>
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
                        <p><i class="fa fa-fw fa-map-marker"></i> Group 12 </p>
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

    </body>
</html>
