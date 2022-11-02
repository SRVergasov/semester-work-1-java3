<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<layout:mainLayout>

    <section class="vh-100" style="background-color: #9de2ff;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-md-9 col-lg-7 col-xl-5">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-4">
                            <div class="d-flex text-black">
                                    <%--                                <div class="flex-shrink-0">--%>
                                    <%--                        TODO avatar            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-profiles/avatar-1.webp"--%>
                                    <%--                                         alt="Generic placeholder image" class="img-fluid"--%>
                                    <%--                                         style="width: 180px; border-radius: 10px;">--%>
                                    <%--                                </div>--%>
                                <div class="flex-grow-1 ms-3">
                                    <h5 class="mb-1">${user.username}</h5>
                                    <div class="d-flex justify-content-start rounded-3 p-2 mb-2"
                                         style="background-color: #efefef;">
                                        <div>
                                            <p class="small text-muted mb-1">City</p>
                                            <form action="${pageContext.request.contextPath}/panel/edit?id=${user.id}" method="post">
                                                <input type="text" name="newCity">
                                                <input type="submit" name="submit">
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</layout:mainLayout>