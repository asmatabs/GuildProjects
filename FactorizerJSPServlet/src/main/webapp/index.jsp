<%-- 
    Document   : index
    Created on : Oct 3, 2017, 2:38:19 PM
    Author     : asmat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer Page</title>
    </head>
    <body>
        <h1>Factorizer</h1>
        <p> 
            Please enter a number that you want to factor:
        </p>
        <form method="POST" action="FactorizerServlet">
            <input type="text" name="numberToFactor">
            <input type="submit" value="Find Factors!!!">
        </form>
    </body>
</html>
