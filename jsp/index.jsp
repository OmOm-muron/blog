<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ja">
  <%@ include file="/html/head.html" %>

  <body>
    <div id="blog">
      <%@ include file="/html/header.html" %>
      <div class="blog-content wrapper">
        <p>とりあえず飛べればいい<br/>
        <a href="/blog/read">test</a>
      </div><!-- /.blog-content -->
    </div><!-- /#home -->

    <%@ include file="/jsp/ideal/footer.jsp" %>
  </body>
</html>
