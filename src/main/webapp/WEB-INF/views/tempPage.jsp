<%--
  Created by IntelliJ IDEA.
  User: fhani
  Date: 8/9/2017
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tempPage</title>
</head>
<body>
<form name="temp" action="loginsuccess">
    <input type="hidden" id="tempCode" name="tempCode" value="">
</form>

<script>
    var url_string = window.location.href;
    var url = new URL(url_string);
    var code = url.searchParams.get("code");
    document.getElementById('tempCode').value = code;
    window.onload = function(){
        document.forms['temp'].submit();
    }
</script>
</body>
</html>
