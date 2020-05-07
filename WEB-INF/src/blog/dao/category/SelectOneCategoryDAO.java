package blog.dao.category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import blog.dao.RootDAO;
import blog.dto.CategoryDTO;

/**
 * @author Omura
 * 一件のデータを取得するDAO
 */
public class SelectOneCategoryDAO extends RootDAO {
	/*****************************************************************
	 * カテゴリ関係のクエリ
	 *****************************************************************/
	public CategoryDTO selectCategory(int categoryid) throws Exception {
		// initialize return value
		CategoryDTO dto = new CategoryDTO();
		
		// declare base SQL
		String sql = "SELECT "
				+ "categoryid, categoryname\n"
				+ "FROM category\n"
				+ "WHERE categoryid = ?";
		
		try {
			// get prepared statement and execute query
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1, categoryid);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				// set SQL Result to return value
				dto.setCategoryid(resultSet.getInt("categoryid"));
				dto.setCategoryname(resultSet.getString("categoryname"));
			}
			
			if (!dto.isValid()) {
				// when invalid category information
				throw new Exception("Category Information is invalid.\n");
			}
			return dto;
		} catch (Exception e) {
			throw e;
		}
	}
}
