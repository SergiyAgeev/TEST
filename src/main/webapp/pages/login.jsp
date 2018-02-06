<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp"%>


<c:url var="loginUrl" value="/login"/>
<form action="${loginUrl}" method="post">

    <c:if test="${param.error != null}">
        <p>Invalid username and password.</p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p>You have been logged out successfully.</p>
    </c:if>


    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="login">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>

</form>


<%@include file="templates/footer.jsp"%>