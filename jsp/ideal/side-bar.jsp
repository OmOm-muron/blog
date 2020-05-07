<%@ page pageEncoding="UTF-8"%>
      <div class="side-bar">
        <div class="side-calendar">
          <p>カレンダー</p>
        </div>
        <div class="latest-articles">
          <p>最新記事</p>
          <c:forEach items="${latestArticles}" var="articleHeader">
            <li>
              <a href="/blog/read?articleid=<c:out value="${articleHeader.articleid}"/>">
                <c:out value="${articleHeader.title}"/> (<fmt:formatDate value="${articleHeader.submitdate}" pattern="yyyy-MM-dd"/>) 
              </a>
            </li>
          </c:forEach>
        </div>
        <div class="top-categories">
          <p>トップカテゴリ</p>
          <c:forEach items="${topCategories}" var="category">
            <li>
              <a href="/blog/search-category?categoryid=<c:out value="${category.categoryid}"/>">
                <c:out value="${category.categoryname}"/>
              </a>
            </li>
          </c:forEach>
        </div>
        <div class="search-articles">
          <ul><a href="/blog/list-monthly">月別記事一覧</a></ul>
          <ul><a href="/blog/search-title">記事タイトル検索</a></ul>
          <ul><a href="/blog/list-category">カテゴリ検索</a></ul>
        </div>
      </div>
