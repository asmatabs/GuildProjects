<%-- 
    Document   : result
    Created on : Oct 3, 2017, 2:39:58 PM
    Author     : asmat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer</title>
    </head>
    <body>
        <h1>Result</h1>
        <p>
            You asked to Factor ${numberToFactor} 
        </p>

        <p>
            Factors are:
            <c:forEach var="currentFactor" items="${factors}">
                <c:out value="${currentFactor} "/>
            </c:forEach>
        </p>
        <p>
            <c:choose>
                <c:when test="${isPerfect}">
                    <c:out value="The number is perfect."/>
                </c:when>
                <c:otherwise>
                    <c:out value="The number is not perfect."/>
                </c:otherwise>
            </c:choose>
        </p>
        <p>
            <c:choose>
                <c:when test="${isPrime}">
                    <c:out value="The number is prime."/>
                </c:when>
                <c:otherwise>
                    <c:out value="The number is not prime."/>
                </c:otherwise>
            </c:choose>            
        </p> 
        <a href="index.jsp">Factor Another One</a>
        
    </body>
</html>
