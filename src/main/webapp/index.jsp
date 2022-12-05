<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Blog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <style>
        /*button {*/
        /*    width: 100px;*/
        /*    height: 50px;*/
        /*    text-align: center;*/
        /*    margin-bottom: 50px;*/
        /*}*/
        .abc{
            padding-top: 18%;
            text-align: center;
        }
        body{
            background-image: url("https://www.teahub.io/photos/full/6-63290_1080p-hd-wallpapers-cool-abstract-backgrounds.jpg");
        }

    </style>
</head>
<body>
<div class="abc">
    <form action="admin_manager/Login2.jsp">
        <button class="" type="submit">Login Admin</button>
    </form>
    <form action="/user">
        <button type="submit">DAO Blog</button>
    </form>
</div>
</body>
</html>