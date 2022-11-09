<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" description="layout for 1 question" %>

<%@attribute name="question" required="true" type="ru.kpfu.itis.java3.semesterwork1.entity.Question" %>
<%@attribute name="individual" required="true" type="java.lang.Boolean" %>
<%@attribute name="editing" required="true" type="java.lang.Boolean" %>

<div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
    <c:if test="${!editing}">
        <c:if test="${userId eq question.userId}">
            <a class="btn btn-danger" href="${pageContext.request.contextPath}/questions/question_delete?questionId=${question.id}">Delete</a>
        </c:if>
        <c:if test="${userId eq question.userId}">
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/questions/question_edit?questionId=${question.id}">Edit</a>
        </c:if>
    </c:if>
    <div class="col-md-6 px-0">
        <h1 class="display-4 fst-italic">${question.title}</h1>
        <p class="lead my-3">${question.description}</p>
        <c:if test="${not individual}">
            <p class="lead mb-0"><a href="${pageContext.request.contextPath}/questions/question?id=${question.id}" class="text-white fw-bold">Open</a></p>
        </c:if>

    </div>
    <jsp:doBody />
</div>