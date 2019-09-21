<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <c:if test="${sessionScope.login}" var="login"/>
    <c:if test="${login}">
      <%@ include file="/html/footer-manager.html"%>
    </c:if>
    <c:if test="${!login}">
      <%@ include file="/html/footer.html"%>
    </c:if>
