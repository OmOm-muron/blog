package blog.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.dao.article.SelectOneArticleDAO;
import blog.dto.ArticleInformationDTO;
import blog.web.util.SidebarUtil;

/**
 *初期表示ページへ遷移するServlet
 */
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        ArticleInformationDTO dto;
        try (SelectOneArticleDAO dao = new SelectOneArticleDAO()) {
            // 最新の記事一つを取得する
            dto = dao.selectLatestArticle();
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
        req.setAttribute("article", dto);
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/read.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
          doGet(req, rsp);
    }
}

