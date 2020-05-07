package blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.dao.category.SelectMultiCategoriesDAO;
import blog.dto.CategoryDTO;
import blog.web.util.SidebarUtil;

/**
 *カテゴリ一覧ページへ遷移するServlet
 */
public class ListCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        List<CategoryDTO> dto;
        try (SelectMultiCategoriesDAO dao = new SelectMultiCategoriesDAO()) {
            // 全カテゴリを取得
            dto = dao.selectAllCategories();
            
            // サイドバーの情報を付加
            SidebarUtil.setLatestFiveArticles(req);
            SidebarUtil.setTopFiveCategories(req);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
            return;
        }
        
        // カテゴリ一覧の情報をリクエストにバインド
        req.setAttribute("categoryList", dto);
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/list-category.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
