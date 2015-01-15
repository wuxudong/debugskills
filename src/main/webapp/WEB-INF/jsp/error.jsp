<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:hasBindErrors name="pojo">
        <h2>Errors</h2>
            <ul>
            <c:forEach var="error" items="${errors.allErrors}">
                <li>${error.defaultMessage}</li>
                <li>${error.defaultMessage}</li>
            </c:forEach>
            </ul>
    </spring:hasBindErrors>