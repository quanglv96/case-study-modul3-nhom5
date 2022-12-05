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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div align="center">
        <form action="/user?action=login" method="post">
            <div><h2>Login</h2></div>
            <table>
                <tr>
                    <th>User Name</th>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
            <div>
                <button type="submit">Login</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
