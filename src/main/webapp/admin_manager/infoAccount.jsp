<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QuangMax
  Date: 07/12/2022
  Time: 8:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account User</title>
    <style>
        .header {
            background-image: url("https://img.freepik.com/free-photo/silver-dollar-eucalyptus-branch-gray-banner_53876-129660.jpg?w=2000");
            width: 100%;
            height: 200px;
            background-size: 1500px;
            text-align: center;
            padding-top: 20px;
            font-size: 40px;
        }

        .directional {
            display: flex;
            justify-content: center;
            text-align: center;
            /*border: 1px solid black;*/
        }

        .directional form button {
            display: inline-block;
            margin-left: 15px;
            margin-right: 15px;
            border: none;
            background: transparent;
            height: 50px;
            font-size: 15px;
            font-weight: bold;
            text-align: center;
        }

        button:hover {
            color: #ffffff;
            background-color: #43d066 !important;
        }

        .ads img {
            width: 100%;
            display: block;
        }

        .showContent {
            /*border: 1px solid black;*/
            width: 90%;
            padding-left: 10%;
            padding-right: 10%;
            text-align: center;
        }

        a {
            text-decoration: none;
        }

    </style>
</head>
<body>
<div>
    <div class="row">
        <div class="header">
            <h1>List News</h1>
        </div>
    </div>
</div>
<div>
    <div class="directional" style="background: #7875B5">
        <form action="/managers" method="get">
            <button type="submit">Home |</button>
        </form>
        <form action="/managers?action=listCategory" method="post">
            <button type="submit">Category |</button>
        </form>
        <form action="/managers?action=sort&category=sport" method="post">
            <button type="submit">Sport |</button>
        </form>
        <form action="/managers?action=sort&category=culture" method="post">
            <button type="submit">Culture |</button>
        </form>
        <form action="/managers?action=all_list_news" method="post">
            <button type="submit">All List News |</button>
        </form>
        <form action="/managers?action=all_list_user" method="post">
            <button type="submit">All List User |</button>
        </form>
    </div>
</div>
<div align="center">
    <div><h3>Account</h3></div>
    <div>
        <table style="font-size: 50px;font-family: Arial ;background: #bb708b ;border: seagreen solid; margin-left: 700px ; line-height: 150px">
            <tr>
                <th>Name:</th>
                <td><c:out value="${user.getUserName()}"/></td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td><c:out value="${user.getPhoneNumber()}"/></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td><c:out value="${user.getEmail()}"/></td>
            </tr>
            <tr>
                <th>Address:</th>
                <td><c:out value="${user.getAddress()}"/></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
