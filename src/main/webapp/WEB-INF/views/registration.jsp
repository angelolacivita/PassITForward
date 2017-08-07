<%--
  Created by IntelliJ IDEA.
  User: Matt
  Date: 8/7/2017
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link href="../resources/css/carousel.css" rel="stylesheet">
</head>
<body>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
        integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
        crossorigin="anonymous"></script>
</body>
</html>
