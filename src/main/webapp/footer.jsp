<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</main><!-- .content -->
</div><!-- .container-->


<aside class="left-sidebar">
    <strong>Меню</strong>
    <ul>
        <c:if test='${role != null && role == 0}'>
        <li><a href="/newOrder.jsp">Новый заказ</a></li>
        <p>
            </c:if>
            <c:if test='${role != null && role == 1}'>
        <li><a href="/orders">Список заказов</a></li>
        <p>
        <li><a href="/newOrder.jsp">Новый заказ</a></li>
        <p>
            </c:if>

    </ul>
</aside>
<!-- .left-sidebar -->

</div><!-- .middle-->
</div><!-- .wrapper -->

<footer class="footer">
    <strong>Ramil Gaisin design</strong>
</footer>
<!-- .footer -->

</body>
</html>
