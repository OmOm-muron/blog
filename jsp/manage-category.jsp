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
          <p>カテゴリ管理</p>
        </div>
        <div class="change-key">
          <form action="/blog/list-category" method="get">
            <input type="text" name="keyword" size="40" placeholder="カテゴリ名キーワード">
            <input type="submit" value="検索">
          </form>
        </div>
        <div class="category-list">
          <li>カテゴリ名</li>
          <li>カテゴリ名</li>
          <li>カテゴリ名</li>
          <li>カテゴリ名</li>
          <li>カテゴリ名</li>
          <li>カテゴリ名</li>
          <li>カテゴリ名</li>
          <li>カテゴリ名</li>
          <li>カテゴリ名</li>
          <li>カテゴリ名</li>
        </div>
      </div>
      <%@ include file="/jsp/ideal/side-bar.jsp"%>
    </main>

    <!--footer-->
    <%@ include file="/jsp/ideal/footer.jsp"%>
  </body>
</html>
