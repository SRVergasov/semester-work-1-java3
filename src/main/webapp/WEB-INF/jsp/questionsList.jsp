<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout>

    <c:forEach items="${questionsList}" var="item">
        <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
            <div class="col-md-6 px-0">
                <h1 class="display-4 fst-italic">${item.title}</h1>
                <p class="lead my-3">${item.descripton}</p>
<%--      TODO author, answers...         <p class="lead mb-0"><a href="#" class="text-white fw-bold">${item.}</a></p>--%>
<%--                TODO button display full--%>

            </div>
        </div>
    </c:forEach>

</layout:mainLayout>

