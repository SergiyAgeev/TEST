<%@include file="templates/header.jsp"%>
Index page
<br>
<form action="/save" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="number" placeholder="number">
    <input type="submit" value="save">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>


<%@include file="templates/footer.jsp"%>