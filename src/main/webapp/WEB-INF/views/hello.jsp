<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
    <h1>hihihi</h1>
    <c:url value="/resources/text.txt" var="url"/>
    <spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
    Spring URL: ${springUrl} at ${time}
    <p>Spring Quote: ${quote}</p>
    <div>
        <ul>
        <c:forEach items="${searchResponse.results}" var="result">
            <li><img src=${result.artworkUrl100}>${result.trackName}<a href=${result.trackViewUrl}>Buy!</a>
            </li>
        </c:forEach>
        </ul>
    </div>
</body>

</html>