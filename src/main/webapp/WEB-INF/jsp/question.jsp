<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout>

    <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
        <div class="col-md-6 px-0">
            <h1 class="display-4 fst-italic">${question.title}</h1>
            <p class="lead my-3">${question.description}</p>
                <%--      TODO author, answers...         <p class="lead mb-0"><a href="#" class="text-white fw-bold">${item.}</a></p>--%>
                <%--                TODO user avatar--%>
        </div>
    </div>

    <c:forEach items="${answersList}" var="answer">
        <c:if test="${answer.best}">
            <p>Best answer:</p>
            <%-- TODO image --%>
        </c:if>
        <%--        TODO user avatar    <img src="https://github.com/twbs.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">--%>
<%--            TODO best answer--%>
        <h2 class="blog-post-title">${answer.text}</h2>
        <p class="blog-post-meta">User: ${answer.user_id}</p>
        <small class="opacity-50 text-nowrap">Likes: ${1}</small>
        <%--                TODO button like--%>
        <hr>
    </c:forEach>



</layout:mainLayout>
