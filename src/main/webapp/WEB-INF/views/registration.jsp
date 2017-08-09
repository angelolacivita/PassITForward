<%--
  Created by IntelliJ IDEA.
  User: Matt
  Date: 8/7/2017
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.

  <form method="post" action="/create-profile">
    <form class="form-horizontal">
        <fieldset>

            <!-- Form Name -->
            <legend>Register</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">First name</label>
                <div class="col-md-4">
                    <input id="textinput" name="firstName" type="text" placeholder="John" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Last name</label>
                <div class="col-md-4">
                    <input id="textinput" name="lastName" type="text" placeholder="Smith" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-check">
                <label class="form-check-label">
                    <input type="checkbox" class="form-check-input" name="" id="java" value="checkedValue" checked>
                    Java<br>
                    <input type="checkbox" class="form-check-input" name="" id="javascript" value="checkedValue" checked>
                    Javascript<br>
                    <input type="checkbox" class="form-check-input" name="" id="C++" value="checkedValue" checked>
                    C++<br>
                    <input type="checkbox" class="form-check-input" name="" id="Python" value="checkedValue" checked>
                    Python<br>
                    <input type="checkbox" class="form-check-input" name="" id="Ruby" value="checkedValue" checked>
                    Ruby<br>
                    <input type="checkbox" class="form-check-input" name="" id="HTML" value="checkedValue" checked>
                    HTML<br>
                    <input type="checkbox" class="form-check-input" name="" id="CSS" value="checkedValue" checked>
                    CSS<br>
                    <input type="checkbox" class="form-check-input" name="" id="SQL" value="checkedValue" checked>
                    SQL<br>
                    <input type="checkbox" class="form-check-input" name="" id="C#" value="checkedValue" checked>
                    C#<br>
                </label>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="john.smith@mail.com" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput">Password</label>
                <div class="col-md-4">
                    <input id="passwordinput" name="password" type="password" placeholder="Enter your password" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput">Repeat password </label>
                <div class="col-md-4">
                    <input id="passwordinput" name="passwordinput" type="password" placeholder="Repeat your password" class="form-control input-md" required="">

                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="register" class="btn btn-primary">Register</button>
                </div>
            </div>

        </fieldset>
    </form>
</form>

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
   <!-- <link href="<c:url value="/resources/css/starter-template.css"/>" rel="stylesheet"> -->
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">


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
            <a class="navbar-brand" href="/displayLanguages">passITforward</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/displayLanguages">Home</a></li>
                <li><a href="/about">About</a></li>
                <li><a href="/contact">Contact</a></li>
                <%--<li><a href="/challenges">Challenges</a></li>--%>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>   <span class="icon-bar"></span>

<div class="container">
<form class="form-signin" method="post" action="/create-profile">
        <fieldset>
            <!-- Form Name -->
            <legend>Register</legend>

            <!-- First name-->
            <div class="form-group">
                <label class="control-label" for="textinput">First name</label>
                    <input id="textinput" name="firstName" type="text" placeholder="John" class="form-control input-md" required="">
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="control-label" for="textinput">Last name</label>
                 <input id="textinput" name="lastName" type="text" placeholder="Smith" class="form-control input-md" required="">
            </div>

            <!-- Select languages -->
            <div class="form-check">
                <label class="form-check-label">
                    <input type="checkbox" class="form-check-input" name="" id="java" value="checkedValue" checked>
                    Java<br>
                    <input type="checkbox" class="form-check-input" name="" id="javascript" value="checkedValue" checked>
                    JavaScript<br>
                    <input type="checkbox" class="form-check-input" name="" id="C++" value="checkedValue" checked>
                    C++<br>
                    <input type="checkbox" class="form-check-input" name="" id="Python" value="checkedValue" checked>
                    Python<br>
                    <input type="checkbox" class="form-check-input" name="" id="Ruby" value="checkedValue" checked>
                    Ruby<br>
                    <input type="checkbox" class="form-check-input" name="" id="HTML" value="checkedValue" checked>
                    HTML<br>
                    <input type="checkbox" class="form-check-input" name="" id="PHP" value="checkedValue" checked>
                    PHP<br>
                    <input type="checkbox" class="form-check-input" name="" id="SQL" value="checkedValue" checked>
                    SQL<br>
                    <input type="checkbox" class="form-check-input" name="" id="C#" value="checkedValue" checked>
                    C#<br>
                </label>
            </div>

            <!-- Text email-->
            <div class="form-group">
                <label class="control-label" for="email">E-mail</label>
                    <input id="email" name="email" type="text" placeholder="john.smith@mail.com" class="form-control input-md" required="">

            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="control-label" for="passwordinput">Password</label>
                    <input id="passwordinput" name="password" type="password" placeholder="Enter your password" class="form-control input-md" required="">
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="control-label" for="passwordinput">Repeat password </label>
                    <input id="passwordinput" name="passwordinput" type="password" placeholder="Repeat your password" class="form-control input-md" required="">
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                    <button id="singlebutton" name="register" class="btn btn-primary">Register</button>
            </div>
        </fieldset>
</form>
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