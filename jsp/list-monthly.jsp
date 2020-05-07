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
          <p>月別記事一覧(<c:out value="${currentYm}"/>)</p>
        </div>
        <div class="change-key">
          <a href="/blog/list-monthly?yearMonth=<c:out value="${previousYm}"/>">前月(<c:out value="${previousYm}"/>)</a>
          <button type="button" name="select-month" value="yy">月選択</button>
          <a href="/blog/list-monthly?yearMonth=<c:out value="${nextYm}"/>">翌月(<c:out value="${nextYm}"/>)</a>
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
