<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:mainLayout>
    <h1>Editing user rating</h1>
    <layout:profile user="${user}">
        <form action="${pageContext.request.contextPath}/panel/edit?id=${user.id}" method="post">
            <input type="text" name="newRating" placeholder="Write new rating">
            <input type="submit" name="submit">
        </form>
    </layout:profile>

</layout:mainLayout>