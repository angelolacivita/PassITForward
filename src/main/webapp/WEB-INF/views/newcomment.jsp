
<%--
  Created by IntelliJ IDEA.
  User: fhani
  Date: 8/7/2017
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ACE test</title>
</head>
<body>
    <form:form class="form-signin" method="post" action="/create-comment">
        <fieldset>
            <!-- Form Name -->
            <legend>Comment Description</legend>
            <!-- First name-->
            <div class="form-group">
                <form:label path="commentDescription" class="control-label" for="textinput">Description</form:label>
                <form:input path="commentDescription" id="textinput" name="commentDescription" type="text" placeholder="Description" class="form-control input-md" required=""/>
            </div>
        </fieldset>
    </form:form>
</body>
</html>

