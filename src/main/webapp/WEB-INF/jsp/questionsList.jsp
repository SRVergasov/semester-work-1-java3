<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:mainLayout>

    <h1>Welcome to the questions list page!</h1>
    <h4>Here all questions:</h4>

    <c:forEach items="${questionsList}" var="question">
        <layout:question question="${question}">
            
        </layout:question>
    </c:forEach>

</layout:mainLayout>

