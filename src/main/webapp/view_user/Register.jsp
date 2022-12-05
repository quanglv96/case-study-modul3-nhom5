<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %><%--
  Created by IntelliJ IDEA.
  User: kungf
  Date: 12/4/2022
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

    <title>Create User</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }

        body {
            background-image: url("https://wallpaperaccess.com/full/1782141.jpg");
            background-attachment: fixed;
            background-size: cover;
            font-family: new time roman;
        }

        h1 {

            font-size: 40px;
            color: red;
            margin-top: 20px;
            margin-bottom: 30px;
            margin-left: 150px;

        }

        .label {
            font-size: 25px;
            margin-top: 20px;
            font-weight: normal;
        }

        .form-control {
            background: rgba(255, 255, 255, 0.2);
            border: 0px;
            border-radius: 0px;
            border-bottom: 2px solid white;
            font-size: 21px;
            color: white;
            margin-top: 20px;
        }

        small {
            font-size: 18px;
            color: yellow;
        }

        option {
            color: #666;
        }

        .btn-info {
            margin-top: 20px;
            margin-left: 480px;
            width: 180px;
            font-size: 25px;
        }
        .error{
            color: red;
            size:25px;
        }
    </style>
</head>
<body>

<div class="container">
    <form action="/register?action=check" method="post">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <br>
                <h1 >REGISTER</h1>
                <label style="color: red" class="label col-md-3 control-label">UserName</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" name="userName" id="userName" placeholder="username" value="<c:out value="${userName}"/>">
                </div>
                <div>
                    <p class="error" ><c:out value="${checkUser}"/></p>
                </div>

                <label style="color: red" class="label col-md-3 control-label">Password</label>
                <div class="col-md-9">
                    <input type="password" class="form-control" name="password" placeholder="password">
                </div>
                <div>
                    <p class="error"><c:out value="${checkPass}"/></p>
                </div>
                <label style="color: red" class="label col-md-3 control-label">RePassword</label>
                <div class="col-md-9">
                    <input type="password" class="form-control" name="rePassword" placeholder="repassword">
                </div>
                <div>
                    <p class="error"><c:out value="${checkRePass}"/></p>
                </div>
                <label style="color: red" class="label col-md-3 control-label">PhoneNumber</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" name="phoneNumber" placeholder="phonenumber" value="<c:out value="${phoneNumber}"/>">
                </div>
                <div>
                    <p class="error" ><c:out value="${checkPhone}"/></p>
                </div>
                <label style="color: red" class="label col-md-3 control-label">Email</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" name="email" placeholder="Email" value="<c:out value="${email}"/>">
                </div>
                <div>
                    <p class="error" ><c:out value="${checkEmail}"/></p>
                </div>
                <label style="color: red" class="label col-md-3 control-label">Address</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" name="address" placeholder="address" value="<c:out value="${address}"/>">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <button type="submit" class="btn btn-info">Submit</button>
    </form>
</div>
</body>

</html>
