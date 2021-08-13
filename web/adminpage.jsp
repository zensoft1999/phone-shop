<%-- 
    Document   : adminpage
    Created on : Jul 8, 2021, 4:15:38 PM
    Author     : ASUS-PC
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Product Page</title>

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

        <!--        Search Bar-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body {
                font-family: Arial;
            }

            * {
                box-sizing: border-box;
            }

            form.searchbar input[type=text] {
                padding: 10px;
                font-size: 17px;
                border: 1px solid grey;
                float: left;
                width: 80%;
                background: #f1f1f1;
            }

            form.searchbar button {
                float: left;
                width: 20%;
                padding: 10px;
                background: #2196F3;
                color: white;
                font-size: 17px;
                border: 1px solid grey;
                border-left: none;
                cursor: pointer;
            }

            form.searchbar button:hover {
                background: #0b7dda;
            }

            form.searchbar::after {
                content: "";
                clear: both;
                display: table;
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

        <!--        add new product-->
        <style>
            .addpro {
                padding-top: 10px;
            }
        </style>

    </head>
    <body>

        <div class="header">
            <h1>Manage Product</h1>
        </div>

        <div class="navbar">
            <a href="ShowController">Home</a>
            <a href="LogoutController" class="right">Logout</a>
        </div>

        <div class="row">
            <!--            <div class="side">
                        </div>-->
            <div class="main">
                <h2>Search</h2>
                <!--                Search bar-->
                <form class="searchbar" action="MainController" method="POST">
                    <input type="text" placeholder="ID or Name of product...." name="txtSearch"/>
                    <button type="submit" name="action" value="Search By AD"><i class="fa fa-search"></i></button>
                </form>

                <c:if test="${requestScope.LIST_PRODUCTS != null}">
                    <c:if test="${ not empty requestScope.LIST_PRODUCTS}">
                        <h2>List Of Product:</h2>
                        <table id="products">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Product ID</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Category ID</th>
                                    <th>Brand</th>
                                    <th>Image</th>
                                    <th colspan="2" class="action">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dto" items="${requestScope.LIST_PRODUCTS}" varStatus="counter">
                                <form action="MainController" method="POST">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${dto.productID}</td>
                                        <td>${dto.productName}</td>
                                        <td>${dto.price}</td>
                                        <td>${dto.quantity}</td>
                                        <td>${dto.categoryID}</td>
                                        <td>${dto.brand}</td>
                                        <td>${dto.image}</td>
                                        <td>
                                            <c:url var="delete" value="MainController">
                                                <c:param name="txtSearch" value="${param.txtSearch}"/>
                                                <c:param name="action" value="Delete"/>
                                                <c:param name="productID" value="${dto.productID}"/>
                                            </c:url>
                                            <a href="${delete}" id="btn">Delete</a>
                                        </td>
                                        <td>
                                            <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                            <input type="hidden" name="productID" value="${dto.productID}" />

                                            <input type="hidden" name="check" value="UpdatePage"/>
                                            <input id="btn" type="submit" name="action" value="Detail"/>

                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="addpro">
                            <a id="btn" href="addproduct.jsp">Add more product</a>
                        </div>
                    </c:if>
                </c:if>   
            </div>
        </div>

        <div class="footer">
            <h2>Power By Group 12</h2>
        </div>

    </body>
</html>
