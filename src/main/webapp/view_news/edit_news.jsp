<%--
  Created by IntelliJ IDEA.
  User: kungf
  Date: 12/3/2022
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit News</title>
    <!--  <script type="text/javascript" src="ckeditor/config.js"></script>-->
    <!--  <script  type="text/javascript" src="ckeditor/ckeditor.js"></script>-->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#summernote').summernote({
                placeholder:'Please enter the content !',
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
            }); });
    </script>
    <style>
        body{
            text-align: center;
        }
    </style>
</head>
<body>
<form action="/news?action=edit_news" method="post">
    <table width="800px" border="1">
        <tr>
            <th colspan="2"><h1 style="color: red; text-align: center; ">Edit News</h1></th>
        </tr>
        <tr>
            <th style="text-align: center" width="200" height="50">Tittle News</th>
            <td width="800" height="50"><input style="width: 800px; height: 50px" type="text" name="titleNews" id="titleNews" value="<c:out value='${news.tileNews}' />" >
        </tr>
        <tr>
            <th style="height: 200px; text-align: center">Content</th>
            <td><textarea style="height: 200px; width: 800px" name="content" id="summernote" value="<c:out value='${news.content}' />"></textarea>
                <span stype="color:red;"></span>
            </td>
            </td>
        </tr>
        <tr>
            <th style="text-align: center" width="61">Date News</th>
            <td width="600"><input style="height: 30px; width: 200px" type="text" name="dateNews" id="dateNews" value="<c:out value='${news.dateNews}' />">
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
                <input type="text" name="img" id="img" value="<c:out value='${news.img}'/>">
                <span stype="color:red;">url"Img"</span>
            </td>
            </td>
        </tr>
        <tr>
            <br>
            <td colspan="2"><br><input style="width: 120px ;height: 40px; background: red "type="submit" name="btnSave" id="btnSave" value="Save"></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>

