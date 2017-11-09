<%-- 
    Document   : orders
    Created on : Oct 4, 2017, 2:20:20 PM
    Author     : asmat
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Fancy Floors Orders</title>
    </head>
    <body>
        <h1>Displaying Orders</h1>
        <p>
        <table>
            <thead>
                <tr>
                    <th>Customer Name</th>
                    <th>Area</th>
                    <th>Material Cost</th>
                    <th>Labor Cost</th>
                    <th>Tax</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody
                
            </tbody>
        </table>
    </p>
    <p>
        ${response}
    </p>
</body>
</html>
