<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:mainLayout>


    <c:forEach items="${userList}" var="item">
        <div class="card" style="width: 18rem;">
                <%-- TODO avatar       <img src="..." class="card-img-top" alt="...">--%>
            <div class="card-body">
                <h5 class="card-title">User <c:out value="${item.id}" /></h5>
                <p class="card-text">
                    Name: <c:out value="${item.username}" /><br>
                    Rating: <c:out value="${item.rating}" /><br>
                </p>
        <a href="${pageContext.request.contextPath}/panel/edit?id=${item.id}" class="btn btn-primary">Edit rating</a>
            </div>
        </div>
    </c:forEach>

</layout:mainLayout>

