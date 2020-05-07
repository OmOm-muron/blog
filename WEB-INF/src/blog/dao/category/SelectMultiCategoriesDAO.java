package blog.dao.category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import blog.dao.RootDAO;
import blog.dto.CategoryDTO;

/**
 * @author Omura
 * カテゴリを複数SELECTするDAO
 */
public class SelectMultiCategoriesDAO extends RootDAO {
    /*****************************************************************
     * 記事カテゴリクエリ用SQL
     *****************************************************************/
    /**
     * 使用最多カテゴリ5件取得用SQL(右側常時表示)<br>
     * DTOに保持する値<br>
     * categoryid<br>
     * categoryname<br>
     */
    public List<CategoryDTO> selectFiveCategories() throws Exception {
        // initialize return value
        List<CategoryDTO> list = new ArrayList<CategoryDTO>();

        // Declare Base SQL
        // TODO Consider SQL or DB design.
        String sql = "SELECT "
                + "COUNT(*) AS count, categoryid, categoryname\n"
                + "FROM article\n"
                + "INNER JOIN category ON article.category1 = category.categoryid\n"
                + "OR article.category2 = category.categoryid\n"
                + "OR article.category3 = category.categoryid\n"
                + "OR article.category4 = category.categoryid\n"
                + "OR article.category5 = category.categoryid\n"
                + "GROUP BY categoryid, categoryname\n"
                + "ORDER BY count, categoryid DESC\n"
                + "LIMIT 5";

        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                CategoryDTO dto = new CategoryDTO();
                dto.setCategoryid(resultSet.getInt("categoryid"));
                dto.setCategoryname(resultSet.getString("categoryname"));

                list.add(dto);
            }
            resultSet.close();

            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 全カテゴリ取得用SQL<br>
     * DTOに保持する値<br>
     * categoryid<br>
     * categoryname<br>
     */
    public List<CategoryDTO> selectAllCategories() throws Exception {
        // initialize return value
        List<CategoryDTO> list = new ArrayList<CategoryDTO>();

        // Declare Base SQL
        String sql = "SELECT "
                + "categoryid, categoryname\n"
                + "FROM category\n"
                + "ORDER BY categoryid";

        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                CategoryDTO dto = new CategoryDTO();
                dto.setCategoryid(resultSet.getInt("categoryid"));
                dto.setCategoryname(resultSet.getString("categoryname"));

                list.add(dto);
            }
            resultSet.close();

            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * カテゴリキーワード検索用SQL<br>
     * DTOに保持する値<br>
     * categoryid<br>
     * categoryname<br>
     */
    public List<CategoryDTO> selectCategoriesByKeyword(String keyword) throws Exception {
        // initialize return value
        List<CategoryDTO> list = new ArrayList<CategoryDTO>();

        // Declare Base SQL
        String sql = "SELECT "
                + "categoryid, categoryname\n"
                + "FROM category\n"
                + "WHERE categoryname LIKE '%?%'\n"
                + "ORDER BY categoryid";

        try {
            // get prepared statement and execute query
            PreparedStatement statement = getPreparedStatement(sql);
            statement.setString(1, keyword);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                CategoryDTO dto = new CategoryDTO();
                dto.setCategoryid(resultSet.getInt("categoryid"));
                dto.setCategoryname(resultSet.getString("categoryname"));

                list.add(dto);
            }
            resultSet.close();

            return list;
        } catch (Exception e) {
            throw e;
        }
    }
}
