<%@tag pageEncoding="UTF-8" description="answer layout" %>

<%@attribute name="answer" required="true" type="ru.kpfu.itis.java3.semesterwork1.entity.Answer" %>

<c:if test="${answer.best}">
    <p>Best answer:</p>
    <%-- TODO image --%>
</c:if>
<%--        TODO user avatar    <img src="https://github.com/twbs.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">--%>
<%--            TODO best answer--%>
<h2 class="blog-post-title">${answer.text}</h2>
<p class="blog-post-meta">User: ${answer.userId}</p>
<small class="opacity-50 text-nowrap">Likes: ${1}</small>
<%--                TODO button like--%>
<hr>