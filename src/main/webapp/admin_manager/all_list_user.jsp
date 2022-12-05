<%--
  Created by IntelliJ IDEA.
  User: QuangMax
  Date: 27/11/2022
  Time: 2:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All list user</title>
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

    </style>
</head>
<body>
<div>
    <div class="row">
        <div class="header">
            <h1>Manager Blog</h1>
        </div>
    </div>
</div>
<div>
    <div class="directional">
        <form action="/user?action=&idUser=" method="get">
            <button type="submit">Home</button>
        </form>

        <form action="/managers?action=&idCategory=${1}" method="get">
            <button type="submit">Sport</button>
        </form>
        <form action="/managers?action=&idCategory=${2}" method="get">
            <button type="submit">Culture</button>
        </form>
        <a href="/managers?action=all_list_news">All List News</a>
        <a href="/managers?action=all_list_user">All List User</a>

    </div>
</div>
<div class="directional">
    <div class="col-2">
        <div class=" col-8 ads"><img src="https://viewpro.in/blog/images/animated-gif-banner-ad.gif"/></div>
    </div>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of User</h2></caption>
            <tr>
                <th>Id User</th>
                <th>User Name</th>
                <th>Phone User</th>
                <th>Email User</th>
                <th>Address</th>
                <th>Status</th>
                <th>LockAccount</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.idUser}"/></td>
                    <td><c:out value="${user.userName}"/></td>
                    <td><c:out value="${user.phoneNumber}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.address}"/></td>
                    <td><c:out value="${user.statusUser}"/></td>
                    <td>
                        <a href="/news?action=delete_news&idUser=${user.id}" onclick="return test('${news.idNews}')">Status</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-2">
        <div class="ads"><img src="https://viewpro.in/blog/images/animated-gif-banner-ad.gif"/></div>
    </div>
</div>
</body>
</html>

