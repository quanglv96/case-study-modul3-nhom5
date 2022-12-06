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
    <title>All list News</title>
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
        a{
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
    <div class="directional">
        <form action="/managers" method="get">
            <button type="submit">Home</button>
        </form>
        <form action="/managers?action=listCategory" method="post">
            <button type="submit">Category</button>
        </form>
        <form action="/managers?action=sort&category=sport" method="post">
            <button type="submit">Sport</button>
        </form>
        <form action="/managers?action=sort&category=culture" method="post">
            <button type="submit">Culture</button>
        </form>
        <form action="/managers?action=all_list_news" method="post">
            <button type="submit">All List News</button>
        </form>
        <form action="/managers?action=all_list_user" method="post">
            <button type="submit">All List User</button>
        </form>
    </div>
</div>
<div class="directional">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of News</h2></caption>
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Tile</th>
                <th>Date</th>
                <th>User</th>
                <th>Delete News</th>
            </tr>
            <c:forEach var="news" items="${listNews}">
                <tr>
                    <td><c:out value="${news.getIdNews()}"/></td>
                    <td><a href="/news?action=sort&idCategory=${news.getCategory().getNameCategory()}"><c:out value="${news.getCategory().getNameCategory()}"/></a></td>
                    <td><a href="/news?action=content&id=${news.getIdNews()}"><c:out value="${news.getTileNews()}"/></a></td>
                    <td><c:out value="${news.getDateNews()}"/></td>
                    <td><c:out value="${news.getUser().getUserName()}"/></td>
                    <td>
                        <form onsubmit="return(confirmDeleteNews())" action="/managers?action=deleteNews&idNews=${news.getIdNews()}" method="post">
                        <button type="submit">🗑️</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
<script>
    function confirmDeleteNews(){
        let result = confirm("Are you sure you want to delete?");
        if(result)  {
            alert("successful delete");
            return true;
        }
        return false
    }
</script>
</html>

