<%--
  Created by IntelliJ IDEA.
  User: fhani
  Date: 8/10/2017
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Slack Messaging</title>
</head>
<body>

<form name=temp method="post" action="privatemessage">
    <input type="text" id="messageText" name="slackmessage">
    Enter the username of the user you want to direct message on the PassITForward slack team:
    <input type="text" id="recieverChannel" name="channel">
    <button name="submit">Submit</button>
</form>

<script>
//    var url_string = window.location.href;
//    var url = new URL(url_string);
//    var code = url.searchParams.get("code");
    document.getElementById('messsageText').value = slackmessage;
    document.getElementsById('recieverChannel').value = channel;
    window.onload = function(){
        document.forms['temp'].submit();
    }
</script>
</body>
</html>



<%--need to figure out how to recieve messages in website as well--%>