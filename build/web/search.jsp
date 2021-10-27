<%-- 
    Document   : search
    Created on : Oct 27, 2021, 8:14:47 PM
    Author     : Lenovo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="SearchController">
            search: from <input type="number" name="txtFrom" /> 
            to: <input type="number" name="txtTo" />
            <input type="submit" value="Search" />
        </form>
        <c:if test="${not empty requestScope.FLOWERS}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Number</th>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Season</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="flower" items="${requestScope.FLOWERS}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${flower.id}</td>
                            <td>${flower.name}</td>
                            <td>${flower.price}</td>
                            <td>${flower.season}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
    </body>
</html>
