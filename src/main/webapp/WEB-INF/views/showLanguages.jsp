<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: angelo
  Date: 8/8/17
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="myvar" items="${lList}">
    <tr>
        <td><a href ="/displayPosts?languageId=${myvar.languageId}">${myvar.language}</a></td>
    </tr>
    <br>
</c:forEach>
</body>
</html>
