package blog.web.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
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
 *日別記事一覧ページへ遷移するServlet
 */
public class ListDailyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        // リクエストから日付を取得
        String ymd = req.getParameter("ymd");
        if (ymd != null) {
            // リクエストの日付からjava.sql.Dateインスタンス生成
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(ymd.split("-")[0]));
            calendar.set(Calendar.MONTH, Integer.parseInt(ymd.split("-")[1]) - 1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(ymd.split("-")[2]));
            Date date = new Date(calendar.getTime().getTime());
            
            List<ArticleInformationDTO> dto;
            try (SelectMultiArticlesDAO dao = new SelectMultiArticlesDAO()) {
                // 記事情報を取得
                dto = dao.selectArticleHeadersPerDay(date);
                // サイドバーの情報を付加
                SidebarUtil.setLatestFiveArticles(req);
                SidebarUtil.setTopFiveCategories(req);
            } catch (Exception e) {
                e.printStackTrace();
                RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
                rd.forward(req, rsp);
                return;
            }
            
            // 記事情報をリクエストにバインド
            req.setAttribute("articleList", dto);
            // TODO 後でクライアントサイドでやる
            // 日付情報をリクエストにバインド
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            req.setAttribute("previousYmd", String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            req.setAttribute("currentYmd", String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            req.setAttribute("nextYmd", String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/list-daily.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
