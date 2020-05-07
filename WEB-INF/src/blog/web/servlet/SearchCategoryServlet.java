package blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.dao.article.SelectMultiArticlesDAO;
import blog.dao.category.SelectOneCategoryDAO;
import blog.dto.ArticleInformationDTO;
import blog.dto.CategoryDTO;
import blog.web.util.SidebarUtil;

/**
 *
 */
public class SearchCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        // リクエストパラメータからcategoryidを取得
        int categoryid = Integer.parseInt(req.getParameter("categoryid"));
        
        CategoryDTO categoryDto;
        List<ArticleInformationDTO> articleDto;
        try (SelectMultiArticlesDAO articleDao = new SelectMultiArticlesDAO();
                SelectOneCategoryDAO categoryDao = new SelectOneCategoryDAO()) {
            // カテゴリ情報を取得
            categoryDto = categoryDao.selectCategory(categoryid);
            
            // 当該カテゴリを持つ記事情報を取得
            articleDto = articleDao.selectArticleHeadersByCategory(categoryid);
            
            // サイドバーの情報を付加
            SidebarUtil.setLatestFiveArticles(req);
            SidebarUtil.setTopFiveCategories(req);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
            return;
        }
        
        // カテゴリ、記事情報をリクエストにバインド
        req.setAttribute("category", categoryDto);
        req.setAttribute("articleList", articleDto);
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/search-category.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
