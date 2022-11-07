<%@tag pageEncoding="UTF-8" description="layout for 1 question" %>

<%@attribute name="question" required="true" type="ru.kpfu.itis.java3.semesterwork1.entity.Question" %>

<div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
        <h1 class="display-4 fst-italic">${question.title}</h1>
        <p class="lead my-3">${question.description}</p>
        <%--      TODO author, answers...         <p class="lead mb-0"><a href="#" class="text-white fw-bold">${item.}</a></p>--%>
        <%--                TODO user avatar--%>
        <p class="lead mb-0"><a href="${pageContext.request.contextPath}/questions/question?id=${question.id}" class="text-white fw-bold">Open</a></p>

    </div>
</div>