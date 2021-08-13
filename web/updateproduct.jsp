<%-- 
    Document   : updateproduct
    Created on : Jul 9, 2021, 3:50:30 PM
    Author     : ASUS-PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product Page</title>

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

        <!--        Input Form-->
        <style>
            * {
                box-sizing: border-box;
            }

            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }

            label {
                padding: 12px 12px 12px 0;
                display: inline-block;
            }

            input[type=submit] {
                background-color: #04AA6D;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: right;
                font-family: Arial, Helvetica, sans-serif;
                font-weight: bold;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }

            .col-25 {
                float: left;
                width: 25%;
                margin-top: 6px;
            }

            .col-75 {
                float: left;
                width: 75%;
                margin-top: 6px;
            }

            /* Clear floats after the columns */
            .rowform:after {
                content: "";
                display: table;
                clear: both;
            }

            .Updatebtn {
                padding-top: 10px;
            }

            /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 600px) {
                .col-25, .col-75, input[type=submit] {
                    width: 100%;
                    margin-top: 0;
                }
            }
        </style>


    </head>

    <body>

        <div class="header">
            <h1>Update Product</h1>
        </div>

        <div class="navbar">

        </div>

        <div class="row">
            <!--            <div class="side">
                        </div>-->
            <div class="main">




                <div class="container">
                    <form action="MainController" method="POST">
                        <div class="rowform">
                            <div class="col-25">
                                <label>Product ID</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="productID" value="${requestScope.WATCH.productID}" readonly="true">
                            </div>
                        </div>

                        <div class="rowform">
                            <div class="col-25">
                                <label>Product Name</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="productName" value="${requestScope.WATCH.productName}">
                            </div>
                        </div>

                        <div class="rowform">
                            <div class="col-25">
                                <label>Price</label>
                            </div>
                            <div class="col-75">
                                <input type="number" name="price" value="${requestScope.WATCH.price}">
                            </div>
                        </div>

                        <div class="rowform">
                            <div class="col-25">
                                <label>Quantity</label>
                            </div>
                            <div class="col-75">
                                <input type="number" name="quantity" value="${requestScope.WATCH.quantity}">
                            </div>
                        </div>

                        <div class="rowform">
                            <div class="col-25">
                                <label>Category ID</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="categoryID" value="${requestScope.WATCH.categoryID}" readonly="true">

                            </div>
                        </div>

                        <div class="rowform">
                            <div class="col-25">
                                <label>Brand</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="brand" value="${requestScope.WATCH.brand}">
                            </div>
                        </div>

                        <div class="rowform">
                            <div class="col-25">
                                <label>Image</label>
                            </div>
                            <div class="col-75">
                                <input type="image" src="images/${requestScope.WATCH.image}" disabled="true">
                                <input type="hidden" name="image" value="${requestScope.WATCH.image}">
                                <input type="file" name="inputImage"/>
                            </div>
                        </div>

                        <div class="rowform">
                            <div class="col-25">
                                <label>Error: </label>
                            </div>
                            <div class="col-75">
                                <p style="color: red">${requestScope.ERROR.priceError}</p>
                                <p style="color: red">${requestScope.ERROR.quantityError}</p>
                                <p style="color: red">${requestScope.ERROR.productNameError}</p>
                                <p style="color: red">${requestScope.ERROR.brandError}</p>
                            </div>
                        </div>
                        <diV class="Updatebtn">     
                            <div class="rowform">
                                <input type="submit" value="Update" name="action">
                                <a id="btn" href="SearchByADController">Back </a>
                            </div>
                        </div>
                </div>
                <input type="hidden" name="txtSearch" value="${requestScope.TXTSEARCH}"/>
                </form>
            </div>
        </div>
    </body>
</html>
