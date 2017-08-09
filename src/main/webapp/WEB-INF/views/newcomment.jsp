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
    <script src="https://cdn.jsdelivr.net/ace/1.2.6/min/ace.js" type="text/javascript" charset="utf-8"></script>
    <title>ACE test</title>
    <style type="text/css" media="screen">
        #editor {
            position: absolute;
            top: 40%;
            right: 40%;
            bottom: 40%;
            left: 40%;
        }
    </style>
</head>
<body>

<pre id="editor">function foo(items) {
    var i;
    for (i = 0; i &lt; items.length; i++) {
        alert("Ace Rocks " + items[i]);
    }
}
</pre>
</body>
</html>

