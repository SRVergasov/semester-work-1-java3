<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout jsFiles="answerAddingViewScript.js">

    <layout:question question="${question}">

    </layout:question>

    <button id="#btn_add_answer" type="button" class="btn btn-secondary">Add answer</button>
    <div id="#form_add_answer" style="display: none">
        <p>Write answer</p>
        <form method="post" action="${pageContext.request.contextPath}/questions/add_answer?questionId=${question.id}&userId=${userId}">
            <input type="text" name="text">
            <input title="submit" type="submit">
        </form>
    </div>
    <hr>

    <c:forEach items="${answersList}" var="answer">
        <layout:answer answer="${answer}">

        </layout:answer>
    </c:forEach>



</layout:mainLayout>