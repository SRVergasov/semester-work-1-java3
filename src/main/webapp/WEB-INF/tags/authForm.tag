<%@tag pageEncoding="UTF-8" description="form for authentication" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="form-signin w-100 m-auto" style="display: none">
    <form action="${pageContext.request.contextPath}/auth" method="post">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input name="username" type="text" class="form-control" id="floatingInput">
            <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating">
            <input name="password" type="password" class="form-control" id="floatingPassword">
            <label for="floatingPassword">Password</label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <button class="w-100 btn btn-lg btn-secondary" id="#btn_close" type="button">Close</button>
        <p class="mt-5 mb-3 text-muted">©2022</p>
    </form>
</div>
