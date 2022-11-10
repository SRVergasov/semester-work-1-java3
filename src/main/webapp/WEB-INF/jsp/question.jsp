<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout jsFiles="answerAddingViewScript.js">

    <layout:question question="${question}" individual="${true}" editing="${false}" username="${questionUsername}">

    </layout:question>

    <button id="#btn_add_answer" type="button" class="btn btn-dark">Add answer</button>
    <div id="#form_add_answer" style="display: none">
        <p>Write answer</p>
        <form method="post" action="${pageContext.request.contextPath}/questions/add_answer?questionId=${question.id}&userId=${userId}">
            <input type="text" name="text" required placeholder="Answer text">
            <input title="submit" type="submit" class="btn btn-dark">
        </form>
    </div>
    <hr>

    <c:forEach items="${answersList}" var="answer" varStatus="loop">
        <layout:answer answer="${answer}" editing="${false}" username="${usernames[loop.index]}">

        </layout:answer>
    </c:forEach>

</layout:mainLayout>