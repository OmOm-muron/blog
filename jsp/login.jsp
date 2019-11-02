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

    <main class="wrapper">
      <div>
        <div class="sub-title">
          <p>管理者ログイン</p>
          <p><c:out value="${test}"/></p>
        </div>
        <div class="login-form">
          <form action="/blog/login" method="post">
            <p>ユーザーID
              <input type="text" name="userid" size="40">
            </p>
            <p>パスワード
              <input type="password" name="password" size="40">
            </p>
            <p>
              <input type="submit" value="ログイン">
            </p>
        </div>
      </div>
    </main>

    <!--footer-->
    <%@ include file="/jsp/ideal/footer.jsp"%>
  </body>
</html>
