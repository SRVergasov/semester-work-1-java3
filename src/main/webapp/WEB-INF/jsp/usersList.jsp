<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout jsFiles="topRatedUserViewScript.js">

    <h1>Here all users sorted by rating</h1>

    <ul class="list-group">
    <c:forEach items="${usersList}" var="user">


        <li class="list-group-item">
            <p class="position-absolute top-50 start-0 ms-3"></p>
            <p>
                Username: ${user.username}<br>
                Rating: ${user.rating}
            </p>
        </li>

    </c:forEach>
    </ul>

</layout:mainLayout>
