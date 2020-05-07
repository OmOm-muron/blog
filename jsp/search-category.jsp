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
        <div class="sub-title">
          <p>カテゴリ：<c:out value="${category.categoryname}"/>の記事一覧</p>
        </div>
        <div class="article-list">
          <c:forEach items="${articleList}" var="articleHeader">
            <li>
              <a href="/blog/read?articleid=<c:out value="${articleHeader.articleid}"/>">
                <c:out value="${articleHeader.title}"/> (<fmt:formatDate value="${articleHeader.submitdate}" pattern="yyyy-MM-dd"/>)
              </a>
            </li>
          </c:forEach>
        </div>
      </div>
      <%@ include file="/jsp/ideal/side-bar.jsp"%>
    </main>

    <!--footer-->
    <%@ include file="/jsp/ideal/footer.jsp"%>
  </body>
</html>
