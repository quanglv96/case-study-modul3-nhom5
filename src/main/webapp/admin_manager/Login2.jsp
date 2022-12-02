<%--
  Created by IntelliJ IDEA.
  User: QuangMax
  Date: 29/11/2022
  Time: 1:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login2</title>
    <link rel="stylesheet" href="webapp/WEB-INF/bootstrap/css/bootstrap.min.css"/>
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
    </style>
</head>
<body>
<div class="login">
    <div><img src="logo.png"/></div>
    <div>
        <form action="Manager.jsp" onsubmit="return checkLog()">
            <table>
                <tr>
                    <th>ID</th>
                </tr>
                <tr>
                    <td><input type="text" id="idAdmin" placeholder="Enter ID"></td>
                </tr>
                <tr>
                    <th>Password</th>
                </tr>
                <tr>
                    <td><input type="password" id="passAdmin" placeholder="Enter password"></td>
                </tr>
                <tr>
                    <td><div><p style="color: red" id="erro"></p></div></td>
                </tr>
                <tr>
                    <td>
                        <button class="btn btn-primary" type="submit">Login</button>
                    </td>
                </tr>
            </table>
            <div name="erro"></div>
        </form>
    </div>
</div>
</body>
<script>
    function checkLog() {
        let id = document.getElementById("idAdmin").value;
        let pass = document.getElementById("passAdmin").value;
        if (id === "admin" && pass === "admin") {
            return true;
        } else {
            document.getElementById("erro").innerText = "ID and Password are incorrect";
            return false;
        }
    }
</script>
<script src="webapp/WEB-INF/bootstrap/js/bootstrap.min.js"></script>
</html>
