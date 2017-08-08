<%--
  Created by IntelliJ IDEA.
  User: fhani
  Date: 8/7/2017
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ACE test</title>
    <style type="text/css" media="screen">
        #editor {
            position: absolute;
            top: 0;
            right: 40%;
            bottom: 40%;
            left: 0;
        }
    </style>
</head>
<body>

<div id="editor">
    editor.getSession().setValue(${postDescription});</div>

<script src="https://cdn.jsdelivr.net/ace/1.2.6/min/ace.js" type="text/javascript" charset="utf-8"></script>
<script>
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/javascript");
</script>
hey button goes here
</body>
</html>

