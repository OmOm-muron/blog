package blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.dao.article.SelectMultiArticlesDAO;
import blog.dto.ArticleInformationDTO;
import blog.web.util.SidebarUtil;

/**
 *
 */
public class SearchTitleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        // リクエストから検索キーワードを取得
        String keyword = req.getParameter("keyword");
        if (keyword != null) {
            // 検索キーワードを取得できた場合のみ実行
            List<ArticleInformationDTO> dto;
            try (SelectMultiArticlesDAO dao = new SelectMultiArticlesDAO()) {
                // 記事の情報を取得
                dto = dao.selectArticleHeadersByKeyword(keyword);
                // サイドバーの情報を付加
                SidebarUtil.setLatestFiveArticles(req);
                SidebarUtil.setTopFiveCategories(req);
            } catch (Exception e) {
                e.printStackTrace();
                RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
                rd.forward(req, rsp);
                return;
            }
            // 記事の情報をリクエストにバインド
            req.setAttribute("articleList", dto);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/search-title.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
