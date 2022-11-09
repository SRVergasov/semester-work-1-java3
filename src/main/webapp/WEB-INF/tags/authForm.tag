<%@tag pageEncoding="UTF-8" description="form for authentication" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${not empty userId}">
        <div class="alert alert-warning" role="alert">
            You already here!
        </div>
    </c:when>
    <c:otherwise>
        <div class="form-signin w-100 m-auto">
            <form action="${pageContext.request.contextPath}/auth" method="post">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                <div class="form-floating">
                    <input name="username" required type="text" class="form-control" id="floatingInput">
                    <label for="floatingInput">Username</label>
                    <div class="form-text">First time here? <a href="${pageContext.request.contextPath}/registration">registration</a></div>
                </div>
                <div class="form-floating">
                    <input name="password" required type="password" class="form-control" id="floatingPassword">
                    <label for="floatingPassword">Password</label>
                </div>
                <button class="btn btn-lg btn-primary" type="submit">Sign in</button>
                <button class="btn btn-lg btn-secondary" id="#btn_close" type="button">Close</button>
                <p class="mt-5 mb-3 text-muted">©2022</p>
            </form>
        </div>
    </c:otherwise>
</c:choose>
