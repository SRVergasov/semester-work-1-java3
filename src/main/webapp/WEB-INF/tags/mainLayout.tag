<%@tag description="main layout for other pages" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<head>
    <title>${title}</title>
    <style>
<%--TODO css file--%>
        .b-example-divider {
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 0.5em 1.5em rgb(0 0 0 / 10%), inset 0 0.125em 0.5em rgb(0 0 0 / 15%);
        }
        .form-signin {
            max-width: 330px;
            padding: 15px;
        }
    </style>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body class="text-center">
<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="${pageContext.request.contextPath}" class="nav-link px-2 text-white">Home</a></li>
                <li><a id="#auth" href="#" class="nav-link px-2 text-white">Auth</a></li>
                <li><a href="${pageContext.request.contextPath}/profile" class="nav-link px-2 text-white">Profile</a></li>
                <li><a href="${pageContext.request.contextPath}/panel" class="nav-link px-2 text-white">Panel</a></li>
                <c:if test="${not empty user}">
                    <li><a href="${pageContext.request.contextPath}/logout" class="nav-link px-2 text-white">Logout</a></li>
                </c:if>
            </ul>

        </div>
    </div>
</header>
<div class="b-example-divider"></div>
<layout:authForm />
<div id="#main">
    <jsp:doBody/>
</div>
</body>
<script>
<%--  TODO file js  --%>
    let form = document.getElementsByClassName("form-signin w-100 m-auto")[0]
    let body = document.getElementById("#main")
    document.getElementById("#auth").addEventListener('click', function () {
        form.style.display = 'block'
        body.style.display = 'none'
    })

    document.getElementById("#btn_close").addEventListener('click', function () {
        form.style.display = 'none'
        body.style.display = 'block'
    })
</script>
