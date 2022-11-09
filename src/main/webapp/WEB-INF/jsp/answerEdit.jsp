<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:mainLayout>

    <layout:answer answer="${answer}">
        <form method="post">
            <input type="text" name="newText" placeholder="new text" required>
            <input type="submit" class="btn">
        </form>
    </layout:answer>

</layout:mainLayout>