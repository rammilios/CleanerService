<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form action="/newOrder" method="post" title="Создание нового заказа">
    Введите описание заказа: <br>
    <textarea name="message" rows="10" cols="30">
    </textarea><br><br>
    <input type="submit" title="Отправить">
</form>
<%@include file="footer.jsp"%>

