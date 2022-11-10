<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:mainLayout>

    <layout:answer answer="${answer}" editing="${true}">
        <form method="post">
            <input type="text" name="newText" placeholder="new text" required>
            <input type="submit" class="btn">
        </form>
    </layout:answer>

</layout:mainLayout>