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



</layout:mainLayout>
