<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag pageEncoding="UTF-8" description="answer layout" %>

<%@attribute name="answer" required="true" type="ru.kpfu.itis.java3.semesterwork1.entity.Answer" %>
<%@attribute name="editing" required="true" type="java.lang.Boolean" %>

<c:if test="${answer.best}">
    <p>Best answer:</p>
</c:if>
<c:if test="${not empty editing}">
    <c:if test="${!editing}">
        <c:if test="${userId eq answer.userId}">
            <a class="btn btn-danger" href="${pageContext.request.contextPath}/questions/answer_delete?answerId=${answer.id}">Delete</a>
        </c:if>
        <c:if test="${userId eq answer.userId}">
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/questions/answer_edit?answerId=${answer.id}">Edit</a>
        </c:if>
    </c:if>
</c:if>
<h2 class="blog-post-title">${answer.text}</h2>
<p class="blog-post-meta">User: ${answer.userId}</p>
<small class="opacity-50 text-nowrap">Likes: ${answer.likes}</small>
<c:if test="${!editing}">
    <a href="${pageContext.request.contextPath}/questions/add_like?answerId=${answer.id}&questionId=${answer.question}" class="btn" style="color: #ff2400">Like</a>
</c:if>
<jsp:doBody />
<hr>