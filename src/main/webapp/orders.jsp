<%@ page import="ru.innopolis.stc13.repository.pojo.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.10.2018
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<table>
    <caption>Orders in queue: </caption>
    <tr>
        <th>ID заказа</th>
        <th>Статус заказа</th>
        <th>Стоимость заказа</th>
        <th>Статус оплаты</th>
        <th>Комментарии к заказу</th>
    </tr>
    <%
    List<Order> list = (List<Order>) request.getAttribute("orders");
    for (Order order : list) {%>
    <tr><td><%=order.getOrder_id()%></td> <td><%=order.getOrder_status()%></td> <td><%=order.getPrice()%></td>
    <td><%=order.getPaid()%></td> <td><%=order.getComments()%><br></td> </tr>
<%
    }
%>
</table>
</body>
</html>
<%@include file="footer.jsp"%>