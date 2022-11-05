<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout>

    <h1>Welcome to the questions list page!</h1>
    <h4>Here all questions:</h4>

    <c:forEach items="${questionsList}" var="item">
        <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
            <div class="col-md-6 px-0">
                <h1 class="display-4 fst-italic">${item.title}</h1>
                <p class="lead my-3">${item.description}</p>
<%--      TODO author, answers...         <p class="lead mb-0"><a href="#" class="text-white fw-bold">${item.}</a></p>--%>
<%--                TODO user avatar--%>
                <p class="lead mb-0"><a href="${pageContext.request.contextPath}/questions/question?id=${item.id}" class="text-white fw-bold">Open</a></p>

            </div>
        </div>
    </c:forEach>

</layout:mainLayout>

