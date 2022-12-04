<%--
  Created by IntelliJ IDEA.
  User: kungf
  Date: 11/29/2022
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
  <script>
    function test(idNews){
      return confirm("You want to delete? " + id + " ?" );
    }
  </script>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="/news?action=create_news">Add New News</a>
  </h2>
  <form action="/news?action=search" method="post">
    <input type="text" name="search" placeholder="Enter name search" >
    <button class="btn btn-primary">Search</button>
  </form>
</center>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><h2>List of News</h2></caption>
    <tr>
      <th>idNews</th>
      <th>idCategory</th>
      <th>tileNews</th>
      <th>content</th>
      <th>dateNews</th>
      <th>statusNews</th>
      <th>img</th>
      <th>actions</th>
    </tr>
    <c:forEach var="news" items="${listNews}">
      <tr>
        <td><c:out value="${news.idnews}"/></td>
        <td><c:out value="${news.idCategory}"/></td>
        <td><c:out value="${news.tileNews}"/></td>
        <td><c:out value="${news.content }"/></td>
        <td><c:out value="${news.dateNews }"/></td>
        <td><c:out value="${news.idUser}"/></td>
        <td><c:out value="${news.statusNews}"/></td>
        <td><c:out value="${news.img}"/></td>
        <td>
          <a href="/news?action=edit_news&idNews=${news.idNews}">Edit</a>
          <a href="/news?action=delete_News&id=${user.id}" onclick="return test('${news.idNews}')">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
