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
          <p>日別記事一覧</p>
        </div>
        <div class="change-key">
          <a href="/blog/list-daily?day=xx">前日(yyyy/MM/dd)</a>
          <button type="button" name="select-day" value="yy">日選択</button>
          <a href="/blog/list-daily?day=xx">翌日(yyyy/MM/dd)</a>
        </div>
        <div class="article-list">
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
          <li>記事タイトル(yyyy/MM/dd)</li>
        </div>
      </div>
      <%@ include file="/jsp/ideal/side-bar.jsp"%>
    </main>

    <!--footer-->
    <%@ include file="/jsp/ideal/footer.jsp"%>
  </body>
</html>
