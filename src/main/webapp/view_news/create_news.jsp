
<%--
  Created by IntelliJ IDEA.
  User: QuangMax
  Date: 27/11/2022
  Time: 2:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#summernote').summernote({
                placeholder: 'Please enter the content !',
                tabsize: 2,
                height: 200,
                //   minHeight: null,
                //   maxHeight: null,
                //   focus: true,
                //   toolbar: [
                //     ['style', ['style']],
                //     ['font', ['bold', 'underline', 'clear']],
                //     ['color', ['color']],
                //     ['para', ['ul', 'ol', 'paragraph']],
                //     ['table', ['table']],
                //     ['insert', ['link', 'picture', 'video']],
                //     ['view', ['fullscreen', 'codeview', 'help']]
                // ]
            });
        });
    </script>
    <title>News Post</title>
    <style>
        body {
            text-align: center;
        }
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
            <button type="submit">Home</button>
        </form>
        <c:if test="${not empty idLogin}">
            <form action="/user?action=create_news&idUser=${idLogin}" method="post">
                <button type="submit">| New Post</button>
            </form>
        </c:if>
        <form action="/user?action=&idUser=${idLogin}" method="post">
            <button type="submit">| Sport</button>
        </form>
        <form action="/user?action=&idUser=${idLogin}" method="post">
            <button type="submit">| Culture</button>
        </form>
        <c:if test="${empty idLogin}">
            <form action="view_user/loginUser.jsp" method="post">
                <button type="submit">| Login</button>
            </form>
            <form action="view_user/Register.jsp" method="post">
                <button type="submit">| Register</button>
            </form>
        </c:if>
        <c:if test="${not empty idLogin}">
            <form action="/user?action=&idUser" method="get">
                <button type="submit">| Logout</button>
            </form>
        </c:if>
    </div>
</div>
<div class="directional" style="background: #b4d99f">
    <div class="col-2">
        <div class=" col-8 ads"><img src="https://viewpro.in/blog/images/animated-gif-banner-ad.gif"/></div>
    </div>
    <div class="mid" style="width: 80%">
        <form action="/news?action=create_news&idUser=${idUser}" method="post">
            <table width="800px" border="1">
                <tr>
                    <th colspan="2"><h1 style="color: red; text-align: center; ">Add News</h1></th>
                </tr>
                <tr>
                    <th style="text-align: center">ID Category</th>
                    <td>
                        <select style="width: 200px; height: 30px" ; class="" name="id_category" id="id_category">
                            <option>------------------</option>
                            <c:forEach items="${category}" var="c">
                                <option value="${c.getIdCategory()}"><c:out value="${c.getNameCategory()}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th style="text-align: center" width="200" height="50">Tittle News</th>
                    <td width="800" height="50"><input style="width: 800px; height: 50px" type="text" name="titleNews"
                                                       id="titleNews">
                </tr>
                <tr>
                    <th style="height: 200px; text-align: center">Content</th>
                    <td><textarea style="height: 200px; width: 800px" name="content" id="summernote"></textarea>
                        <span stype="color:red;"></span>
                    </td>
                    </td>
                </tr>
                <tr>
                    <th style="text-align: center" width="61">Date News</th>
                    <td width="600"><input style="height: 30px; width: 200px" type="text" name="dateNews" id="dateNews">
                </tr>
                <tr>
                    <th style="text-align: center">ID User</th>
                    <td>
                        <select style="width: 200px; height: 30px" class="" name="id_User" id="id_User">
                            <option>------------------</option>
                            <c:forEach items="${user}" var="c">
                                <option value="${c.getIdUser()}"><c:out value="${c.getUserName()}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th style="text-align: center">Status News</th>
                    <td><p>
                        <label>
                            <input type="radio" name="status" value="1" id="on_1" checked="1">
                            On</label>
                        <br>
                        <label>
                            <input type="radio" name="staus" value="0" id="off_0">
                            Off</label>
                        <br>
                    </p></td>
                </tr>
                <tr>
                    <th style="text-align: center">Img</th>
                    <td>
                        <input type="file" name="fileToUpload" id="fileToUpload">
                        <br>
                        <input type="text" name="img" id="img">
                        <span stype="color:red;">url"Img"</span>
                    </td>
                    </td>
                </tr>
                <tr>
                    <br>
                    <td colspan="2"><br><input style="width: 120px ;height: 40px; background: red " type="submit" name="btnSave"
                                               id="btnSave" value="Save"></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="col-3 " style="width: 20% ; margin-left: 20px">
        <div class="ads"><img src="https://viewpro.in/blog/images/animated-gif-banner-ad.gif"/></div>
    </div>
</div>
</body>
</html>
