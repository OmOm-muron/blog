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
          <p>日付：時刻</p>
          <p>カテゴリ：XXXX YYYY ZZZZ</p>
        </div>
        <div class="article-title">
          <h2>記事タイトル</h2>
        </div>
        <div class="article-content">
          <p>本文</p>
          <p>本文</p>
          <p>本文</p>
          <p>本文</p>
          <p>本文</p>
          <p>本文</p>
        </div>
      </div>
      <%@ include file="/jsp/ideal/side-bar.jsp"%>
    </main>

    <!--footer-->
    <%@ include file="/jsp/ideal/footer.jsp"%>
  </body>
</html>
