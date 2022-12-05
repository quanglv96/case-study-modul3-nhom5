<%--
  Created by IntelliJ IDEA.
  User: QuangMax
  Date: 29/11/2022
  Time: 1:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login2</title>
    <link rel="stylesheet" href="webapp/WEB-INF/bootstrap/css/bootstrap.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        body {
            background-image: url("https://wallpaperaccess.com/full/1782141.jpg");
            background-size: 1580px 900px;
        }

        .login {
            text-align: center;
            padding: 0;
            width: 25%;
            height: 100%;
            margin-left: 70%;
            background: rgba(255, 255, 255, 0.4);
            margin-right: 10%;
        }

        th{
            text-align: left;
        }
        input{
            width: 300px;
            height: 30px;
        }
        button{
            width: 50px;
            height: 30px;
        }
        tr td{
            text-align: center;
        }
        div form{
            text-align: center;
            padding: 10%;
        }
        img{
            width:70% ;
            height:35%;
            opacity: 1;
        }
        .btn-info {
            margin-top: 20px;
            margin-left: 50px;
            width: 200px;
            font-size: 20px;
            text-align: center;
            padding-top: 1px;
        }
    </style>
</head>
<body>
<div class="login">
    <div><img src="logo.png"/></div>
    <div>
        <form action="Manager.jsp" onsubmit="return checkLog()">
            <table>
                <tr>
                    <th><label class="label col-md-3 control-label" >Account</label></th>
                </tr>
                <tr>
                    <td>
                        <div class="col-md-12">
                            <input type="text" class="form-control" name="userName" placeholder="admin">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th><label class="label col-md-3 control-label" >Password</label></th>
                </tr>
                <tr>
                    <td><div class="col-md-12">
                        <input type="password" class="form-control" name="password" placeholder="password">
                        <small>Password must be 6 character</small>
                    </div></td>
                </tr>
                <tr>
                    <td><div><p style="color: red" id="error"></p></div></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" class="btn btn-info" value="LOGIN"></td>
                    </td>
                </tr>
            </table>
            <div name="error"></div>
        </form>
    </div>r
</div>
</body>
<script>
    function checkLog() {
        let id = document.getElementById("idAdmin").value;
        let pass = document.getElementById("passAdmin").value;
        if (id === "admin" && pass === "admin") {
            return true;
        } else {
            document.getElementById("error").innerText = "ID and Password are incorrect";
            return false;
        }
    }
</script>
<script src="webapp/WEB-INF/bootstrap/js/bootstrap.min.js"></script>
</html>
