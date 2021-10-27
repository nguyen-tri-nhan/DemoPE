<%-- 
    Document   : addFlower
    Created on : Oct 27, 2021, 8:15:01 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CreateFlowerController">
            id: <input type="text" name="txtId"/> </br>
            name: <input type="text" name="txtName"/> </br>
            description: <input type="text" name="txtDescription"/> </br>
            quantity: <input type="number" name="txtQuantity"/> </br>
            price <input type="number" name="txtPrice"/> </br>
            season:
            <select name="txtSeason">
                <option value="spring">Spring</option>
                <option value="summer">Summer</option>
                <option value="autumn">Autumn</option>
                <option value="winter">Winter</option>
            </select>
            <input type="submit" name="Create" />
        </form>
    </body>
</html>
