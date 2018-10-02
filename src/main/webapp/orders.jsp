<%@ page import="ru.innopolis.stc13.repository.pojo.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.10.2018
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<H1>Orders in queue: </H1>
<%
    List<Order> list = (List<Order>) request.getAttribute("orders");
    for (Order order : list) {%>
<%=order.getOrder_id()%>"><%=order.getOrder_status()%><%=order.getPrice()%>
<%=order.getPaid()%><%=order.getComments()%>
<%
    }
%>
<a href="/newOrder">New Order</a>
</body>
</html>
