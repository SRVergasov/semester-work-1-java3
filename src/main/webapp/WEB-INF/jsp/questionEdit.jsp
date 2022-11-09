<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:mainLayout>
    
    <layout:question question="${question}" individual="${true}" editing="${true}">

        <form method="post">
            <input type="text" name="title" required placeholder="new question title">
            <input type="text" name="description" placeholder="new question description">
                <%--TODO js max len --%>
            <input title="submit" type="submit" class="btn btn-dark">
        </form>

    </layout:question>
    
</layout:mainLayout>
