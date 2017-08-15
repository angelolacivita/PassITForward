<!--
(Alphabetical Order)

* Farha Hanif
* https://github.com/fhanif

* Angelo LaCivita
* https://github.com/angelolacivita

* Matthew Menna
* https://github.com/mattmenna
* https://www.linkedin.com/in/matthew-menna/
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="passItforward is the site to get your answers answered!">
    <meta name="author" content="">

    <title>passITforward - REPLACE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</title>

    <link rel="icon" href="<c:url value="/resources/favicon.ico"/>"/>


</head>

<body>


<!--
Place Code for body of page below-->
<form name="temp" action="/loginSlack">
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