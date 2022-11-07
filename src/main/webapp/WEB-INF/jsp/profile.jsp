<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:mainLayout>

    <h1>Your profile</h1>
    <layout:profile user="${user}" />

</layout:mainLayout>