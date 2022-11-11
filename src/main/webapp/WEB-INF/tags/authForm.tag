<%@tag pageEncoding="UTF-8" description="form for authentication" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="w-25 mx-auto">
    <form action="${pageContext.request.contextPath}/auth" method="post">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div>
            <input name="username" required type="text" placeholder="Username" class="form-control" id="floatingInput">
            <div class="form-text">First time here? <a href="${pageContext.request.contextPath}/registration">registration</a></div>
        </div>
        <div>
            <input name="password" required type="password" placeholder="Password" class="form-control" id="floatingPassword">
        </div>
        <button class="btn m-1 btn-lg btn-dark" type="submit">Sign in</button><br>
        <button class="btn m-1 btn-lg btn-light border-1 border-dark" id="#btn_close" type="button">Close</button>
    </form>
</div>
