<%--
  Created by IntelliJ IDEA.
  User: nguyenhoangduong
  Date: 27/01/2022
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All Products</h1>
<button><a href="HomeServlet?action=sortAsc">SortAsc product list</a></button>
<button><a href="HomeServlet?action=sortDesc">SortDesc product list</a></button>
<button><a href="HomeServlet?action=moveToCart">Move to cart</a></button>
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Quantity</td>
            <td>Description</td>
            <td colspan="6">Action</td>
        </tr>
        <c:forEach items="${productList}" var="productList">
            <tr>
                <td>${productList.getId()}</td>
                <td>${productList.getName()}</td>
                <td>${productList.getPrice()}</td>
                <td>${productList.getQuantity()}</td>
                <td>${productList.getDescription()}</td>
                <td><button><a href="">Add to cart</a></button></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
