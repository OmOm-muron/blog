package blog.dao.article;

import java.sql.PreparedStatement;
import java.sql.Timestamp;

import blog.dao.RootDAO;
import blog.dto.*;

/**
 * @author Omura
 * INSERT,UPDATE,DELETE系の処理を行うDAO
 */
public class ArticleTransactionDAO extends RootDAO {

    /*****************************************************************
     * 記事関係のトランザクション
     *****************************************************************/
    /**
     * 記事を投稿する
     * @param articleInformationDTO
     * @return insert数
     * @throws Exception
     */
    public int insertArticle(ArticleInformationDTO articleInformation) throws Exception {
        // initialize result(return value)
        int result = 0;

        // declare base SQL
        String sql ="INSERT INTO article\n"
                + "    (submitdate, title, category1, category2, category3, category4, category5, article)\n"
                + "VALUES\n"
                + "    (?, ?, ?, ?, ?, ?, ?, ?)\n";

        try {
            // カテゴリIDを取得
            int category1 = articleInformation.getCategory1();
            int category2 = articleInformation.getCategory2();
            int category3 = articleInformation.getCategory3();
            int category4 = articleInformation.getCategory4();
            int category5 = articleInformation.getCategory5();
            
            // get prepared statement and execute insert transaction
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setTimestamp(1, new Timestamp(articleInformation.getSubmitdate().getTime()));
            statement.setString(2, articleInformation.getTitle());
            if (category1 == 0) {
                // カテゴリIDが0の場合はNULL
                statement.setNull(3, java.sql.Types.INTEGER);
            } else {
                statement.setInt(3, category1);
            }
            if (category2 == 0) {
                // カテゴリIDが0の場合はNULL
                statement.setNull(4, java.sql.Types.INTEGER);
            } else {
                statement.setInt(4, category1);
            }
            if (category3 == 0) {
                // カテゴリIDが0の場合はNULL
                statement.setNull(5, java.sql.Types.INTEGER);
            } else {
                statement.setInt(5, category1);
            }
            if (category4 == 0) {
                // カテゴリIDが0の場合はNULL
                statement.setNull(6, java.sql.Types.INTEGER);
            } else {
                statement.setInt(6, category1);
            }
            if (category5 == 0) {
                // カテゴリIDが0の場合はNULL
                statement.setNull(7, java.sql.Types.INTEGER);
            } else {
                statement.setInt(7, category1);
            }
            statement.setString(8, articleInformation.getArticle());

            result = statement.executeUpdate();

            // commit
            super.commit();
        } catch (Exception e) {
            // rollback transaction and throw exception
            super.rollback();
            throw e;
        }

        return result;
    }

    /**
     * 記事を更新する
     * @param articleInformationDTO
     * @return update数
     * @throws Exception
     */
    public int updateArticle(ArticleInformationDTO articleInformation) throws Exception {
        // initialize result(return value)
        int result = 0;

        // Declare Base SQL
        String sql = "UPDATE article\n"
                + "SET updatedate = ?,\n"
                + "title = ?,\n"
                + "category1 = ?,\n"
                + "category2 = ?,\n"
                + "category3 = ?,\n"
                + "category4 = ?,\n"
                + "category5 = ?,\n"
                + "article = ?\n";

        try {
            // get prepared statement and execute update transaction
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setTimestamp(1, new Timestamp(articleInformation.getUpdatedate().getTime()));
            statement.setString(2, articleInformation.getTitle());
            statement.setInt(3, articleInformation.getCategory1());
            statement.setInt(4, articleInformation.getCategory2());
            statement.setInt(5, articleInformation.getCategory3());
            statement.setInt(6, articleInformation.getCategory4());
            statement.setInt(7, articleInformation.getCategory5());
            statement.setString(8, articleInformation.getArticle());

            result = statement.executeUpdate();

            // commit
            super.commit();
        } catch (Exception e) {
            // rollback transaction and throw exception
            super.rollback();
            throw e;
        }

        return result;
    }

    /**
     * 記事を削除する
     * @param articleInformationDTO
     * @return delete数
     * @throws Exception
     */
    public int deleteArticle(ArticleInformationDTO articleInformation) throws Exception {
        // initialize result(return values)
        int result = 0;

        // Declare Base SQL for comments
        String sql_comments = "DELETE FROM comment\n"
                + "WHERE articleid = ?\n";
        // Declare Base SQL for article
        String sql_article = "DELETE FROM article\n"
                + "WHERE articleid = ?\n";

        try {
            // get prepared statement and execute delete comments transaction
            PreparedStatement statement_comments = getPreparedStatement(sql_comments);
            statement_comments.setInt(1, articleInformation.getArticleid());

            result += statement_comments.executeUpdate();

            // get prepared statement and execute delete article transaction
            PreparedStatement statement_article = getPreparedStatement(sql_article);
            statement_article.setInt(1, articleInformation.getArticleid());

            result += statement_article.executeUpdate();

            //commit
            super.commit();
        } catch (Exception e) {
            // rollback transaction and throw exception
            super.rollback();
            throw e;
        }

        return result;
    }
}
