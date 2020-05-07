package blog.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import blog.dao.article.SelectOneArticleDAO;
import blog.dto.ArticleInformationDTO;
import blog.web.util.SidebarUtil;

/**
 *記事1件を表示するページへ遷移するServlet
 */
public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        // リクエストパラメータから記事IDを取得
        int articleId = Integer.parseInt(req.getParameter("articleid"));
        
        ArticleInformationDTO dto;
        try (SelectOneArticleDAO dao = new SelectOneArticleDAO()) {
            // 表示対象の記事を1つ取得する
            dto = dao.selectArticle(articleId);
            // サイドバーの情報を付加
            SidebarUtil.setLatestFiveArticles(req);
            SidebarUtil.setTopFiveCategories(req);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
            return;
        }
        
        // 記事の情報をリクエスト属性へバインド
        req.setAttribute("article", dto);
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/read.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}

