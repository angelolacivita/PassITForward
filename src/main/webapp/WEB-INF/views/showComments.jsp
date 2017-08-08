<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: angelo
  Date: 8/8/17
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${postTitle}
<br>
${postDescription}
<br>
<c:forEach var="myvar" items="${cList}">
    <tr>
        <td>${myvar.commentDescription}</td>
    </tr>
    <br>
</c:forEach>
</body>
</html>
