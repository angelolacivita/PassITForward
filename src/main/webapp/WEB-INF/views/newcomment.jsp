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
    <link href="<c:url value="/resources/css/Footer-with-logo.css"/>" rel="stylesheet">
    <link rel="stylesheet" media="screen" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!----Keep one of the following
    <link href="<c:url value="/resources/css/dashboard.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/starter-template.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
    ------------------------------->

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="<c:url value = "/resources/css/ie10-viewport-bug-workaround.css"/>" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://cdn.jsdelivr.net/ace/1.2.6/min/ace.js" type="text/javascript" charset="utf-8"></script>

    <style type="text/css" media="screen">
        #editor {
            height: 300px;
        }
    </style>
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
                <li class="active"><a href="/home"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;&nbsp;Home </a></li>
                <li><a href="/about"><i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;&nbsp;About</a></li>
                <li><a href="/contact"><i class="fa fa-envelope-open-o" aria-hidden="true"></i>&nbsp;&nbsp;Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout">Logout&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-sign-out"
                                                                       aria-hidden="true"></i></a></li>
                <li><a href="/dashboard">Dashboard&nbsp;&nbsp;&nbsp;<i class="fa fa-tachometer" aria-hidden="true"></i></a>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav><span class="icon-bar"></span>
<!--
Place Code for body of page below-->


<div class="jumbotron">
    <div class="container">
        <h1>${postTitle}</h1>
        <h3>${postDescription}</h3>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <!--JSTL CREATED Begin-->
        <form:form class="form-signin" method="post" action="/create-comment?postId=${postId}">
            <fieldset>
                <!-- Form Name -->
                <legend>Type your proposed solution below!</legend>
                <!-- First name-->
                <div class="form-group">
                    <form:label path="commentDescription" class="control-label" for="textinput">Comment</form:label>
                    <form:input path="commentDescription" id="textinput" name="commentDescription" type="text" placeholder="Description" class="form-control input-lg" required=""/>
                </div>
                <div class="form-group">
                    <form:label path="postId" class="control-label" for="textinput"></form:label>
                    <form:input path="postId" id="textinput" name="postId" type="hidden" placeholder="${postId}" class="form-control input-lg" required=""/>
                </div>
                <button id="singlebutton" name="post" class="btn btn-primary">Post</button>
            </fieldset>
        </form:form>
        <!--JSTL CREATED End-->
<br><br><br>
    </div>

</div>


<%--<div id="editor">${postDescription}--%>
<%--</div>--%>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Editor</h3>
        </div>
        <div class="panel-body">
            <div id="editor">function foo(items) {
                var x = "All this is syntax highlighted";
                return x;
                }</div>
        </div>
    </div>
</div>

<script src="/ace-builds/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
<script>
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/java");
</script>


<footer id="myFooter">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <h5>Get started</h5>
                <ul>
                    <li><a href="/home">Home</a></li>
                    <li><a href="/login">Sign in/up</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
                <h5>About us</h5>
                <ul>
                    <li><a href="/contact">Contact us</a></li>
                </ul>
            </div>
            <div class="col-sm-3 info">
                <h5>Information</h5>
                <p> We created passITforward as an alternative to some of the more popular solution websites that don't reward well thought out responses. Our goal is to create a site that encourages users to respond to others problems. </p>
            </div>
        </div>
    </div>
    <div class="second-bar">
        <div class="container">
            <h2 class="logo"><a href="/home">passITforward</a></h2>
            <div class="social-icons">
                <a href="https://www.facebook.com/"><i id="social-fb"
                                                       class="fa fa-facebook-square fa-3x social"></i></a>
                <a href="https://twitter.com/"><i id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a>
                <a href="https://plus.google.com/"><i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
                <a href="mailto:passITforward"><i id="social-em" class="fa fa-envelope-square fa-3x social"></i></a>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>



</body>
</html>