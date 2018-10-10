<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form action="/register" method="post" title="Register">
    Login:<input type="text" name="login"/><br/><br/>
    Password:<input type="password" name="password"/><br/><br/>
    Name:<input type="text" name="name"/><br/><br/>
    <br/><br/>
    <input type="submit" title="ok">

</form>
<%@include file="footer.jsp"%>
