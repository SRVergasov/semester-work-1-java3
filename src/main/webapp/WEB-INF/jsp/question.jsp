<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout>

    <layout:question question="${question}">

    </layout:question>

    <c:forEach items="${answersList}" var="answer">
        <layout:answer answer="${answer}">

        </layout:answer>
    </c:forEach>

    <button id="#btn_add_answer" type="button" class="btn btn-secondary">Add answer</button>
    <div id="#form_add_answer" style="display: none">
        <p>Write answer</p>
        <form method="post" action="${pageContext.request.contextPath}/questions/add_answer?questionId=${question.id}&userId=${userId}">
            <input type="text" name="text">
            <input title="submit" type="submit">
        </form>
    </div>



</layout:mainLayout>
<%--TODO other file (ex. forTokens)--%>
<script>
    let addButton = document.getElementById('#btn_add_answer');
    let addAnswerForm = document.getElementById("#form_add_answer");
    addButton.addEventListener('click', function () {
        addAnswerForm.style.display = "block";
        addButton.style.display = "none";
    });
</script>
