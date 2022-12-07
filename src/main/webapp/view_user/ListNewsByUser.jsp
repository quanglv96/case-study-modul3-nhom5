<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QuangMax
  Date: 06/12/2022
  Time: 4:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News of <c:out value="${nameUser}"/></title>
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
            font-size: 45px;
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

        .col-2 {
            width: 20%;
        }

        .col-3 {
            width: 20%;
        }

        .mid {;
            width: 60%;
        }

        button {
            font-family: "Arial";
            color: rebeccapurple;

        }

        td {
            font-family: Arial;
        }
    </style>
</head>
<body>
<div>
    <div class="row">
        <div class="header">
            <h1>Blog</h1>
        </div>
    </div>
</div>
<div>
    <div class="directional" style="background: #b4d99f ;border:solid 2px wheat ">
        <form action="/user?action=&idUser=${idLogin}" method="post">
            <button style=" font-size: 30px" type="submit">Home</button>
        </form>
        <c:if test="${not empty idLogin}">
            <form action="/news?action=openForm&idUser=${idLogin}" method="post">
                <button style=" font-size: 30px"  type="submit">| New Post</button>
            </form>
        </c:if>
        <form action="/user?action=sort&idCategory=sport&idUser=${idLogin}" method="post">
            <button style=" font-size: 30px" type="submit">|Sport</button>
        </form>
        <form action="/user?action=sort&idCategory=culture&idUser=${idLogin}" method="post">
            <button style=" font-size: 30px" type="submit">| Culture</button>
        </form>
        <c:if test="${empty idLogin}">
            <form action="view_user/loginUser.jsp" method="post">
                <button style=" font-size: 30px" type="submit">| Login</button>
            </form>
            <form action="view_user/Register.jsp" method="post">
                <button style=" font-size: 30px" type="submit">| Register</button>
            </form>
        </c:if>
        <c:if test="${not empty idLogin}">
            <form action="/user?action=newsByIdUser&idUser=${idLogin} " method="post">
                <button style=" font-size: 30px" type="submit">| Post Manager</button>
            </form>
            <form action="/user?action=infoAccount&idUser=${idLogin}" method="post">
                <button style=" font-size: 30px" type="submit">| Account</button>
            </form>
        </c:if>
        <c:if test="${not empty idLogin}">
            <form action="/user?action=&idUser" method="get">
                <button style=" font-size: 30px" type="submit">| Logout</button>
            </form>
        </c:if>
        <form action="/user?action=search" method="post">
            <input style="height: 50px;width: 200px"type="text" name="search" placeholder="Enter name title search">
        </form>
    </div>
</div>
<div class="directional" style="background: #b4d99f">
    <div class="col-2">
        <div class=" col-8 ads"><img src="https://viewpro.in/blog/images/animated-gif-banner-ad.gif"/></div>
    </div>
    <div class="mid" style="width: 60%">
        <c:forEach items="${listNews}" var="news">
            <div>
                <table>
                    <tr>
                        <td><c:out value="${news.getUser().getUserName()}"/></td>
                    </tr>
                    <tr>
                        <td><a href="/user?action=contentByID&&idNews=${news.getIdNews()}&idUser=${idLogin}"><c:out
                                value="${news.getTileNews()}"/></a></td>
                    </tr>
                    <tr>
                        <td><img src="${news.getImg()}" width="900px" height="600px" style="margin-left: 50px"/></td>
                    </tr>
                    <tr>
                        <td>
                            <form onsubmit="return(confirm('Do you want to delete this post?'))"
                                  action="/user?action=deleteNews&idNews=${news.getIdNews()}&idUser=${idLogin}" method="post">
                                <button type="submit">Delete</button></form>
                                <form action="/user?action=formEdit&idNews=${news.getIdNews()}&idUser=${idLogin}" method="post">
                                    <button type="submit">Edit</button>
                                </form>
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </c:forEach>
    </div>
    <div class="col-3 " style="width: 20% ; margin-left: 20px">
        <div class="ads"><img src="https://viewpro.in/blog/images/animated-gif-banner-ad.gif"/></div>
    </div>
</div>
</body>
</html>
