<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QuangMax
  Date: 06/12/2022
  Time: 9:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info Account</title>
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
            <button style=" font-size: 30px"  type="submit">Home</button>
        </form>
        <c:if test="${not empty idLogin}">
            <form action="/news?action=openForm&idUser=${idLogin}" method="post">
                <button style=" font-size: 30px"  type="submit">|New Post</button>
            </form>
        </c:if>
        <form action="/user?action=sort&idCategory=sport&idUser=${idLogin}" method="post">
            <button style=" font-size: 30px"  type="submit">|Sport</button>
        </form>
        <form action="/user?action=sort&idCategory=culture&idUser=${idLogin}" method="post">
            <button style=" font-size: 30px"  type="submit">| Culture</button>
        </form>
        <c:if test="${empty idLogin}">
            <form action="view_user/loginUser.jsp" method="post">
                <button style=" font-size: 30px"  type="submit">| Login</button>
            </form>
            <form action="view_user/Register.jsp" method="post">
                <button style=" font-size: 30px"  type="submit">| Register</button>
            </form>
        </c:if>
        <c:if test="${not empty idLogin}">
            <form action="/user?action=newsByIdUser&idUser=${idLogin} " method="post">
                <button style=" font-size: 30px"  type="submit">| Post Manager</button>
            </form>
        </c:if>
        <c:if test="${not empty idLogin}">
            <form action="/user?action=infoAccount&idUser=${idLogin}" method="post">
                <button  style=" font-size: 30px" type="submit">| Account</button>
            </form>
        </c:if>
        <c:if test="${not empty idLogin}">
            <form action="/user?action=&idUser" method="get">
                <button style=" font-size: 30px"  type="submit">| Logout</button>
            </form>
        </c:if>
        <form action="/news?action=searchNews&idUser=${idLogin}" method="post">
            <input style="height: 50px;width: 200px" type="text" name="search" onsubmit=""
                   placeholder="Enter name title search">
            <button type="submit">🔍</button>
        </form>
    </div>
</div>
<div style="background: #7875B5">
    <c:if test="${empty edit}">
    <form action="/user?action=editAccount&idUser=${idLogin}" method="post">
        </c:if>
        <c:if test="${not empty edit}">
        <form action="/user?action=saveAccount&idUser=${idLogin}" method="post">
            </c:if>
            <table style="font-size: 50px;font-family: Arial ;background: #bb708b ;border-radius: 10px;border: seagreen solid; margin-left: 500px ; line-height: 100px">
                <tr>
                    <th>Name:</th>
                    <c:if test="${not empty edit}">
                        <td><input type="text" name="nameUser" value="${user.getUserName()}"/></td>
                    </c:if>
                    <c:if test="${empty edit}">
                        <td><c:out value="${user.getUserName()}"/></td>
                    </c:if>
                </tr>
                <tr>
                    <th>Phone:</th>
                    <c:if test="${not empty edit}">
                        <td><input type="text" name="phoneUser" value="${user.getPhoneNumber()}"/></td>
                    </c:if>
                    <c:if test="${empty edit}">
                        <td><c:out value="${user.getPhoneNumber()}"/></td>
                    </c:if>
                </tr>
                <tr>
                    <th>Email:</th>
                    <c:if test="${not empty edit}">
                        <td><input type="text" name="emailUser" value="${user.getEmail()}"/></td>
                    </c:if>
                    <c:if test="${empty edit}">
                        <td><c:out value="${user.getEmail()}"/></td>
                    </c:if>
                </tr>
                <tr>
                    <th>Address:</th>
                    <c:if test="${not empty edit}">
                        <td><input type="text" name="addressUser" value="${user.getAddress()}"/></td>
                    </c:if>
                    <c:if test="${empty edit}">
                        <td><c:out value="${user.getAddress()}"/></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${not empty edit}">
                        <td>
                            <button type="submit">Save</button>
                        </td>
                        <td>
                            <button type="button" onclick="reloadPage(${idLogin})">Skip</button>
                        </td>
                    </c:if>
                    <c:if test="${empty edit}">
                        <td>
                            <button style="padding: 30px 100px; background: seagreen; font-size: 50px" type="submit">Edit</button>
                        </td>
                    </c:if>
                </tr>
            </table>
        </form>
</div>
</body>
<script>
    function reloadPage(id){
        window.location="/user?action=infoAccount&idUser="+id;
    }
</script>
</html>
