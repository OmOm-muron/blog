<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
  <!--head-->
  <%@ include file="/html/head.html"%>

  <body>
    <!--header-->
    <%@ include file="/html/header.html"%>

    <main class="blog-field wrapper">
      <div class="main-content">
        <%@ include file="/html/back-to-top.html"%>
        <div class="article-meta-info">
          <p><fmt:formatDate value="${article.submitdate}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
          <p>カテゴリ:
            <c:out value="${article.categoryname1}"/>  <c:out value="${article.categoryname2}"/>  <c:out value="${article.categoryname3}"/>  <c:out value="${article.categoryname4}"/>  <c:out value="${article.categoryname5}"/>
          </p>
        </div>
        <div class="article-title">
          <h2><c:out value="${article.title}"/></h2>
        </div>
        <div class="article-content">
          <pre><c:out value="${article.article}"/></pre>
        </div>
      </div>
      <%@ include file="/jsp/ideal/side-bar.jsp"%>
    </main>

    <!--footer-->
    <%@ include file="/jsp/ideal/footer.jsp"%>
  </body>
</html>
