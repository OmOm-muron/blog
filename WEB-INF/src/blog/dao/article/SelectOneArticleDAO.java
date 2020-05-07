package blog.dao.article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import blog.dao.RootDAO;
import blog.dto.ArticleInformationDTO;

/**
 * @author Omura
 * 一件のデータを取得するDAO
 */
public class SelectOneArticleDAO extends RootDAO {
    
    /*****************************************************************
     * 最新の記事を取得
     *****************************************************************/
    public ArticleInformationDTO selectLatestArticle() throws Exception {
        // initialize return value
        ArticleInformationDTO dto = new ArticleInformationDTO();
        
        // declare base SQL
        String sql = "SELECT "
                + "articleid, submitdate, title, "
                + "category1, category2, category3, category4, category5, "
                + "(SELECT categoryname FROM category WHERE categoryid = category1) AS categoryname1, "
                + "(SELECT categoryname FROM category WHERE categoryid = category2) AS categoryname2, "
                + "(SELECT categoryname FROM category WHERE categoryid = category3) AS categoryname3, "
                + "(SELECT categoryname FROM category WHERE categoryid = category4) AS categoryname4, "
                + "(SELECT categoryname FROM category WHERE categoryid = category5) AS categoryname5, "
                + "article, updatedate\n"
                + "FROM article\n"
                + "ORDER BY articleid DESC\n"
                + "LIMIT 1";
        
        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // set SQL Result to return value
                dto.setArticleid(resultSet.getInt("articleid"));
                dto.setSubmitdate(resultSet.getTimestamp("submitdate"));
                dto.setTitle(resultSet.getString("title"));
                dto.setCategory1(resultSet.getInt("category1"));
                dto.setCategory2(resultSet.getInt("category2"));
                dto.setCategory3(resultSet.getInt("category3"));
                dto.setCategory4(resultSet.getInt("category4"));
                dto.setCategory5(resultSet.getInt("category5"));
                dto.setCategoryname1(resultSet.getString("categoryname1"));
                dto.setCategoryname2(resultSet.getString("categoryname2"));
                dto.setCategoryname3(resultSet.getString("categoryname3"));
                dto.setCategoryname4(resultSet.getString("categoryname4"));
                dto.setCategoryname5(resultSet.getString("categoryname5"));
                dto.setArticle(resultSet.getString("article"));
                dto.setUpdatedate(resultSet.getTimestamp("updatedate"));
            }
            
            if (!dto.isValid()) {
                // when invalid article information
                throw new Exception("Article Information is invalid.\n");
            }
            return dto;
        } catch (Exception e) {
            throw e;
        }
    }
    
    /*****************************************************************
     * 記事IDから取得
     *****************************************************************/
    public ArticleInformationDTO selectArticle(int articleid) throws Exception {
        // initialize return value
        ArticleInformationDTO dto = new ArticleInformationDTO();
        
        // declare base SQL
        String sql = "SELECT "
                + "articleid, submitdate, title, "
                + "category1, category2, category3, category4, category5, "
                + "(SELECT categoryname FROM category WHERE categoryid = category1) AS categoryname1, "
                + "(SELECT categoryname FROM category WHERE categoryid = category2) AS categoryname2, "
                + "(SELECT categoryname FROM category WHERE categoryid = category3) AS categoryname3, "
                + "(SELECT categoryname FROM category WHERE categoryid = category4) AS categoryname4, "
                + "(SELECT categoryname FROM category WHERE categoryid = category5) AS categoryname5, "
                + "article, updatedate\n"
                + "FROM article\n"
                + "WHERE articleid = ?";
        
        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setInt(1, articleid);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // set SQL Result to return value
                dto.setArticleid(resultSet.getInt("articleid"));
                dto.setSubmitdate(resultSet.getTimestamp("submitdate"));
                dto.setTitle(resultSet.getString("title"));
                dto.setCategory1(resultSet.getInt("category1"));
                dto.setCategory2(resultSet.getInt("category2"));
                dto.setCategory3(resultSet.getInt("category3"));
                dto.setCategory4(resultSet.getInt("category4"));
                dto.setCategory5(resultSet.getInt("category5"));
                dto.setCategoryname1(resultSet.getString("categoryname1"));
                dto.setCategoryname2(resultSet.getString("categoryname2"));
                dto.setCategoryname3(resultSet.getString("categoryname3"));
                dto.setCategoryname4(resultSet.getString("categoryname4"));
                dto.setCategoryname5(resultSet.getString("categoryname5"));
                dto.setArticle(resultSet.getString("article"));
                dto.setUpdatedate(resultSet.getTimestamp("updatedate"));
            }
            
            if (!dto.isValid()) {
                // when invalid article information
                throw new Exception("Article Information is invalid.\n");
            }
            return dto;
        } catch (Exception e) {
            throw e;
        }
    }
}
