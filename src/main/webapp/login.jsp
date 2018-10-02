<%@include file="header.jsp"%>
<%
    if ("wrongLogin".equals(request.getParameter("errorCode"))) {
        %>
        <p style="color: #FF2222"> Error: wrongLogin.</p>
<%
    }
%>
<form action="/login" method="post" title="Register">
    <input type="login" name="login" title="Login"/>
    <input type="password" name="password" title="Password"/>
    <input type="submit" title="ok">
</form>
<%@include file="footer.jsp"%>
