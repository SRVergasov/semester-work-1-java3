<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout jsFiles="questionAddingViewScript.js">

    <h1>Welcome to the questions list page!</h1>

    <button id="#btn_add_question" type="button" class="btn btn-secondary">Add question</button>
    <div id="#form_add_question" style="display: none">
        <p>Write question</p>
        <form method="post" action="${pageContext.request.contextPath}/questions/add_question">
            <input type="text" name="title" required placeholder="Question title">
            <input type="text" name="description" placeholder="Question description">
                <%--TODO js max len --%>
            <input title="submit" type="submit" class="btn btn-dark">
        </form>
    </div>

    <h4>Here all questions:</h4>
    <hr>

    <c:forEach items="${questionsList}" var="question" varStatus="loop">
        <layout:question question="${question}" individual="${false}" editing="${false}" username="${usernames[loop.index]}">
            
        </layout:question>
        <hr>
    </c:forEach>

</layout:mainLayout>