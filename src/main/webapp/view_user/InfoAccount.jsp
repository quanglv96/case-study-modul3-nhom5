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
  <table>
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
</body>
</html>
