package blog.web.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import blog.dao.article.SelectMultiArticlesDAO;
import blog.dao.category.SelectMultiCategoriesDAO;
import blog.dto.ArticleInformationDTO;
import blog.dto.CategoryDTO;

/**
 * サイドバーに表示する情報をリクエストにバインドする処理を定義 
 */
public class SidebarUtil {
    /**
     * 最新5件の記事のヘッダ情報をリクエストにバインドする処理
     * @param req
     * @throws SQLException
     * @throws IOException
     */
    public static void setLatestFiveArticles(HttpServletRequest req) throws Exception {
        if (req == null) {
            throw new Exception("This is invalid calling.");
        }
        
        // a最新5件の記事のヘッダ情報を取得
        List<ArticleInformationDTO> dto;
        try (SelectMultiArticlesDAO dao = new SelectMultiArticlesDAO()) {
            dto = dao.selectFiveArticleHeaders();
        } catch (Exception e) {
            throw e;
        }
        
        req.setAttribute("latestArticles", dto);
        return;
    }
    
    /**
     * 最頻5件のカテゴリの情報をリクエストにバインドする処理
     * @param req
     * @throws SQLException
     * @throws IOException
     */
    public static void setTopFiveCategories(HttpServletRequest req) throws Exception {
        if (req == null) {
            throw new Exception("This is invalid calling.");
        }
        
        // a最新5件の記事のヘッダ情報を取得
        List<CategoryDTO> dto;
        try (SelectMultiCategoriesDAO dao = new SelectMultiCategoriesDAO()) {
            dto = dao.selectFiveCategories();
        } catch (Exception e) {
            throw e;
        }
        
        req.setAttribute("topCategories", dto);
        return;
    }
}
