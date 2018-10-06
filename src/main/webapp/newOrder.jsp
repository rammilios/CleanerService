<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<%
    if ("OK".equals(request.getParameter("status"))) {
%>
<p style="color: #4cff11"> Status: Заказ принят.</p>
<%
    }
%>
<form action="/newOrder" method="post" title="Создание нового заказа" accept-charset="UTF-8">
    Введите описание заказа: <br>
    <input type="comments" name="comments"><br>
    <input type="adress" name="adress">
    <br><br>
    <input type="submit" title="Отправить">
</form>
<%@include file="footer.jsp" %>
