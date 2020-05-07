package blog.dao.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import blog.dao.RootDAO;
import blog.dto.ArticleInformationDTO;

/**
 * @author Omura
 * 記事を複数SELECTするDAO
 */
public class SelectMultiArticlesDAO extends RootDAO {
    /*****************************************************************
     * 記事複数クエリ用SQL
     *****************************************************************/
    /**
     * 最新記事5件取得用SQL(右側常時表示)
     * DTOに保持する値
     * articleid
     * submitdate
     * title
     */
    public List<ArticleInformationDTO> selectFiveArticleHeaders() throws Exception {
        // initialize return value
        List<ArticleInformationDTO> list = new ArrayList<ArticleInformationDTO>();

        // Declare Base SQL
        String sql = "SELECT "
                + "articleid, submitdate, title\n"
                + "FROM article\n"
                + "ORDER BY submitdate DESC\n"
                + "LIMIT 5";

        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                // DTOをセットしてリストに追加
                ArticleInformationDTO dto = new ArticleInformationDTO();
                dto.setArticleid(resultSet.getInt("articleid"));
                dto.setSubmitdate(resultSet.getTimestamp("submitdate"));
                dto.setTitle(resultSet.getString("title"));
                list.add(dto);
            }
            resultSet.close();

            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 月別記事取得用SQL
     * DTOに保持する値
     * articleid
     * submitdate
     * title
     */
    public List<ArticleInformationDTO> selectArticleHeadersPerMonth(Date date) throws Exception {
        // initialize return value
        List<ArticleInformationDTO> list = new ArrayList<ArticleInformationDTO>();

        // Declare Base SQL
        String sql = "SELECT "
                + "articleid, submitdate, title\n"
                + "FROM article\n"
                + "WHERE submitdate >= ? AND submitdate <= ?\n"
                + "ORDER BY submitdate DESC\n";

        // 検索に使用する日付を用意
        // 日付FROM(月初日)
        Calendar fromYmd = Calendar.getInstance();
        fromYmd.setTime(date);
        fromYmd.set(Calendar.DAY_OF_MONTH, fromYmd.getActualMinimum(Calendar.DAY_OF_MONTH));
        // 日付TO(月最終日)
        Calendar toYmd = Calendar.getInstance();
        toYmd.setTime(date);
        toYmd.set(Calendar.DAY_OF_MONTH, toYmd.getActualMaximum(Calendar.DAY_OF_MONTH));

        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setDate(1, new Date(fromYmd.getTime().getTime()));
            statement.setDate(2, new Date(toYmd.getTime().getTime()));

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                ArticleInformationDTO dto = new ArticleInformationDTO();
                dto.setArticleid(resultSet.getInt("articleid"));
                dto.setSubmitdate(resultSet.getTimestamp("submitdate"));
                dto.setTitle(resultSet.getString("title"));
                list.add(dto);
            }
            resultSet.close();

            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 日別記事取得用SQL
     * DTOに保持する値
     * articleid
     * submitdate
     * title
     */
    public List<ArticleInformationDTO> selectArticleHeadersPerDay(Date date) throws Exception {
        // initialize return value
        List<ArticleInformationDTO> list = new ArrayList<ArticleInformationDTO>();

        // Declare Base SQL
        String sql = "SELECT "
                + "articleid, submitdate, title\n"
                + "FROM article\n"
                + "WHERE submitdate = ?\n"
                + "ORDER BY submitdate DESC\n";

        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setDate(1, date);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                ArticleInformationDTO dto = new ArticleInformationDTO();
                dto.setArticleid(resultSet.getInt("articleid"));
                dto.setSubmitdate(resultSet.getTimestamp("submitdate"));
                dto.setTitle(resultSet.getString("title"));
                list.add(dto);
            }
            resultSet.close();

            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 記事キーワード検索用SQL<br>
     * DTOに保持する値<br>
     * articleid<br>
     * submitdate<br>
     * title<br>
     */
    public List<ArticleInformationDTO> selectArticleHeadersByKeyword(String keyword) throws Exception {
        // initialize return value
        List<ArticleInformationDTO> list = new ArrayList<ArticleInformationDTO>();

        // Declare Base SQL
        String sql = "SELECT "
                + "articleid, submitdate, title\n"
                + "FROM article\n"
                + "WHERE title LIKE ?\n"
                + "ORDER BY submitdate DESC\n";

        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, "%" + keyword + "%");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                ArticleInformationDTO dto = new ArticleInformationDTO();
                dto.setArticleid(resultSet.getInt("articleid"));
                dto.setSubmitdate(resultSet.getTimestamp("submitdate"));
                dto.setTitle(resultSet.getString("title"));
                list.add(dto);
            }
            resultSet.close();

            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 記事カテゴリ検索用SQL
     * DTOに保持する値
     * articleid
     * submitdate
     * title
     */
    public List<ArticleInformationDTO> selectArticleHeadersByCategory(int categoryid) throws Exception {
        // initialize return value
        List<ArticleInformationDTO> list = new ArrayList<ArticleInformationDTO>();

        // Declare Base SQL
        String sql = "SELECT "
                + "articleid, submitdate, title\n"
                + "FROM article\n"
                + "WHERE category1 = ?\n"
                + "OR category2 = ?\n"
                + "OR category3 = ?\n"
                + "OR category4 = ?\n"
                + "OR category5 = ?\n"
                + "ORDER BY submitdate DESC\n";

        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setInt(1, categoryid);
            statement.setInt(2, categoryid);
            statement.setInt(3, categoryid);
            statement.setInt(4, categoryid);
            statement.setInt(5, categoryid);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                ArticleInformationDTO dto = new ArticleInformationDTO();
                dto.setArticleid(resultSet.getInt("articleid"));
                dto.setSubmitdate(resultSet.getTimestamp("submitdate"));
                dto.setTitle(resultSet.getString("title"));
                list.add(dto);
            }
            resultSet.close();

            return list;
        } catch (Exception e) {
            throw e;
        }
    }
}
