<%-- 
    Document   : result
    Created on : Oct 4, 2017, 1:55:29 PM
    Author     : asmat
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Result</h1>
        <p>
            You broke after ${rolls} rolls
        </p>
        <p>
            You should have quit after ${breakingRoll} rolls when you had ${highestAmount}
        </p>
        <p>
            <a href="index.jsp">Play again!!</a>
        </p>
    </body>
</html>
