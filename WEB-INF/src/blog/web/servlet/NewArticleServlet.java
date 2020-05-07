package blog.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.dao.article.ArticleTransactionDAO;
import blog.dto.ArticleInformationDTO;
import blog.web.util.SidebarUtil;

/**
 *新規投稿ページへ遷移するServlet
 */
public class NewArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GET時は入力画面を表示
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        try {
            // サイドバーの情報を付加
            SidebarUtil.setLatestFiveArticles(req);
            SidebarUtil.setTopFiveCategories(req);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
            return;
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/new-article.jsp");
        rd.forward(req, rsp);
    }

    /**
     * POST時は記事の投稿処理
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
          req.setCharacterEncoding("UTF-8");
          
          // リクエストから記事のタイトルと内容を取得
          String title = req.getParameter("article-title");
          String article = req.getParameter("article-content");
          if (title.isEmpty() || article.isEmpty()) {
              // パラメータが空なら入力画面に戻す
              req.setAttribute("message", "タイトルと内容は両方入力してください。");
              doGet(req, rsp);
              return;
          }
          
          // 記事DTOにパラメータをセット
          ArticleInformationDTO dto = new ArticleInformationDTO();
          dto.setSubmitdate(new Timestamp(new Date().getTime()));
          dto.setTitle(title);
          dto.setArticle(article);
//          dto.setCategory1(1);
//          dto.setCategory2(1);
//          dto.setCategory3(1);
//          dto.setCategory4(1);
//          dto.setCategory5(1);
          
          try (ArticleTransactionDAO dao = new ArticleTransactionDAO()) {
              // 記事投稿処理
              dao.insertArticle(dto);
              // サイドバーの情報を付加
              SidebarUtil.setLatestFiveArticles(req);
              SidebarUtil.setTopFiveCategories(req);
          } catch (Exception e) {
              e.printStackTrace();
              RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
              rd.forward(req, rsp);
              return;
          }
          
          // リクエストにメッセージをセット
          req.setAttribute("message", "記事を投稿しました。");
          
          RequestDispatcher rd = req.getRequestDispatcher("/jsp/complete.jsp");
          rd.forward(req, rsp);
    }
}

