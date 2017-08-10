<%--
  Created by IntelliJ IDEA.
  User: angelo
  Date: 7/21/17
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/resources/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <!-- Latest compiled and minified CSS & JS -->
    <link rel="stylesheet" media="screen" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="<c:url value = "/resources/css/ie10-viewport-bug-workaround.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/starter-template.css"/>" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home">passITforward</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home">Home</a></li>
                <li><a href="/about">About</a></li>
                <li><a href="/contact">Contact</a></li>
                <%--<li><a href="/challenges">Challenges</a></li>--%>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<span class="icon-bar"></span>


<div class="jumbotron">
    <div class="container">
        <h1>passITforward</h1>
        <p>Select one of the programming languages below to view user posts on the language topic.</p>
        <p><a class="btn btn-primary btn-lg" href="/about" role="button">Learn more &raquo;</a></p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->

    <c:forEach var="myvar" items="${lList}">
            <div class="col-md-4">
                <a href="/displayPosts?languageId=${myvar.languageId}"><h2>${myvar.language}</h2></a>
                <p>All ${myvar.language} related Challenges on passITforward</p>
                <p><a class="btn btn-default" href="/challenges?languageId=${myvar.languageId}" role="button">View details &raquo;</a></p>
            </div>
    </c:forEach>
    <%--<div class="col-md-4">--%>
    <%--<h2>Java</h2>--%>
    <%--<p>Number of Projects : 10<br>--%>
    <%--Number of answers: 20<br>--%>
    <%--Popularity: High</p>--%>
    <%--<p><a class="btn btn-default" href="/challenges" role="button">View details &raquo;</a></p>--%>
    <%--</div>--%>
    <%--<div class="col-md-4">--%>
    <%--<h2>C#</h2>--%>
    <%--<p>Number of Projects : 11<br>--%>
    <%--Number of answers: 21<br>--%>
    <%--Popularity: High</p>--%>
    <%--<a class="btn btn-default" href="/challenges" role="button">View details &raquo;</a></p>--%>
    <%--</div>--%>
    <%--<div class="col-md-4">--%>
    <%--<h2>CSS</h2>--%>
    <%--<p>Number of Projects : 12<br>--%>
    <%--Number of answers: 22<br>--%>
    <%--Popularity: High</p>--%>
    <%--<a class="btn btn-default" href="/challenges" role="button">View details &raquo;</a></p>--%>
    <%--</div>--%>
    <%--<div class="col-md-4">--%>
    <%--<h2>JavaScript</h2>--%>
    <%--<p>Number of Projects : 13<br>--%>
    <%--Number of answers: 23<br>--%>
    <%--Popularity: High</p>--%>
    <%--<a class="btn btn-default" href="/challenges" role="button">View details &raquo;</a></p>--%>
    <%--</div>--%>
    <%--<div class="col-md-4">--%>
    <%--<p>Number of Projects : 14<br>--%>
    <%--Number of answers: 24<br>--%>
    <%--Popularity: High</p>--%>
    <%--<a class="btn btn-default" href="/challenges" role="button">View details &raquo;</a></p>--%>
    <%--</div>--%>
</div>

<div class="container">
    <div class="text-center center-block">
        <a href="https://www.facebook.com/"><i id="social-fb" class="fa fa-facebook-square fa-3x social"></i></a>
        <a href="https://twitter.com/"><i id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a>
        <a href="https://plus.google.com/"><i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
        <a href="mailto:passITforward"><i id="social-em" class="fa fa-envelope-square fa-3x social"></i></a>
    </div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="<c:url value="/resources/js/ie10-viewport-bug-workaround.js"/>"></script>
</body>
</html>