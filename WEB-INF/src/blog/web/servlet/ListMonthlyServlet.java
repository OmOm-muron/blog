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
 *月別記事一覧ページへ遷移するServlet
 */
public class ListMonthlyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        // TODO 後でクライアントサイドでやる
        // 画面に年月を返す用
        String previousYm;
        String currentYm;
        String nextYm;
        
        List<ArticleInformationDTO> dto;
        try (SelectMultiArticlesDAO dao = new SelectMultiArticlesDAO()) {
            // 検索年月を取得
            // デフォルトで操作年月を使用する
            Date date = new Date( new java.util.Date().getTime());
            // リクエストに年月があればそれを使用する
            String yearMonth = req.getParameter("yearMonth");
            if (yearMonth != null) {
                // "-"で区切って先頭を年、次を月として取得
                int year = Integer.parseInt(yearMonth.split("-")[0]);
                int month = Integer.parseInt(yearMonth.split("-")[1]) - 1;
                // Calendarに年月をセット
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                // Calendar.getTime() → Date, Date.getTime() → long
                date = new Date(calendar.getTime().getTime());
            }
            // 記事情報を取得
            dto = dao.selectArticleHeadersPerMonth(date);
            // サイドバーの情報を付加
            SidebarUtil.setLatestFiveArticles(req);
            SidebarUtil.setTopFiveCategories(req);
            
            // TODO 後でクライアントサイドでやる
            // 画面に返す年月
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            // 前月
            calendar.add(Calendar.MONTH, -1);
            previousYm = String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1);
            // 当月
            calendar.add(Calendar.MONTH, 1);
            currentYm = String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1);
            // 翌月
            calendar.add(Calendar.MONTH, 1);
            nextYm = String.valueOf(calendar.get(Calendar.YEAR)) + "-" + String.valueOf(calendar.get(Calendar.MONTH) + 1);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
            return;
        }
        
        // 記事情報をリクエストにバインド
        req.setAttribute("articleList", dto);
        // 年月をリクエストにバインド
        req.setAttribute("previousYm", previousYm);
        req.setAttribute("currentYm", currentYm);
        req.setAttribute("nextYm", nextYm);
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/list-monthly.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
