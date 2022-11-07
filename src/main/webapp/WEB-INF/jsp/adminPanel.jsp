<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:mainLayout>
    <h1>Here all users</h1>
    <hr>
    <c:forEach items="${userList}" var="item">
        <layout:profile user="${item}">
            <a href="${pageContext.request.contextPath}/panel/edit?id=${item.id}" class="btn btn-secondary">Edit rating</a>
        </layout:profile>
        <hr>
    </c:forEach>
</layout:mainLayout>
