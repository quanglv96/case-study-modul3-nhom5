<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QuangMax
  Date: 05/12/2022
  Time: 11:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Raleway:400,700');

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: Raleway, sans-serif;
        }

        body {
            background: linear-gradient(90deg, #C7C5F4, #776BCC);
        }

        .container {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        .login__field {
            padding: 20px 0px;
            position: relative;
        }

        .login__icon {
            position: absolute;
            top: 30px;
            color: #7875B5;
            width: 200px;
        }

        .login__input {
            border: none;
            border-bottom: 2px solid #D1D1D4;
            background: none;
            padding: 10px;
            padding-left: 24px;
            font-weight: 700;
            width: 75%;
            transition: .2s;
        }

        .login__input:active,
        .login__input:focus,
        .login__input:hover {
            outline: none;
            border-bottom-color: #6A679E;
        }

        .login__submit {
            background: #fff;
            font-size: 14px;
            margin-top: 30px;
            padding: 16px 20px;
            border-radius: 26px;
            border: 1px solid #D4D3E8;
            text-transform: uppercase;
            font-weight: 700;
            display: flex;
            align-items: center;
            width: 100%;
            color: #4C489D;
            box-shadow: 0px 2px 2px #5C5696;
            cursor: pointer;
            transition: .2s;
        }

        .login__submit:active,
        .login__submit:focus,
        .login__submit:hover {
            border-color: #6A679E;
            outline: none;
        }

        .button__icon {
            font-size: 24px;
            margin-left: auto;
            color: #7875B5;
        }
        .error{
            color: red;
            size:25px;
        }
    </style>
</head>
<body>
<div class="container">
   <div style="border: #797983 solid 30px ; border-radius: 20px ; padding: 50px""> <form action="/user?action=login" method="post"><h1 style="color: gray ">LOGIN</h1>
        <div class="login__field">
            <i class="login__icon fas fa-user"></i>
            <input type="text" class="login__input" placeholder="Username/Email" name="username">
        </div>
        <div class="login__field">
            <i class="login__icon fas fa-lock"></i>
            <input type="password" class="login__input" placeholder="Password" name="password">
        </div>
        <div><p class="error"><c:out value="${checkLogin}"/></p></div>
        <div>
        <button class="button login__submit" type="submit" style="width: 130px">
            <span class="button__text" >Log In Now</span>
            <i class="button__icon fas fa-chevron-right"></i>
        </button>
        </div>
    </form></div>
</div>
</body>
</html>
