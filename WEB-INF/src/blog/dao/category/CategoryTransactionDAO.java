package blog.dao.category;

import java.sql.PreparedStatement;

import blog.dao.RootDAO;
import blog.dto.*;

/**
 * @author Omura
 * INSERT,UPDATE,DELETE系の処理を行うDAO
 */
public class CategoryTransactionDAO extends RootDAO {
	/*****************************************************************
	 * カテゴリ関係のトランザクション
	 *****************************************************************/
	/**
	 * カテゴリを作成する
	 * @param CategoryDTO
	 * @return insert数
	 * @throw Exception
	 */
	public int insertCategory(CategoryDTO category) throws Exception {
		// initialize result(return values)
		int result = 0;
		// Declare Base SQL
		String sql = "INSERT INTO category\n"
				+ "    (categoryname)\n"
				+ "VALUES\n"
				+ "    (?)\n";
		
		try {
			// get prepared statement and execute insert transaction
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setString(1, category.getCategoryname());
			
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
	 * カテゴリを更新する
	 * @param CategoryDTO
	 * @return update数
	 * @throw Exception
	 */
	public int updateCategory(CategoryDTO category) throws Exception {
		// initialize result(return value)
		int result = 0;
		// Daclare Base SQL
		String sql = "UPDATE category\n"
				+ "SET categoryname = ?\n"
				+ "WHERE categoryid = ?\n";
		
		try {
			// get prepared statement and execute update transaction
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setString(1, category.getCategoryname());
			statement.setInt(2, category.getCategoryid());
			
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
	 * カテゴリを削除する
	 * @param CategoryDTO
	 * @return delete数
	 * @throw Exception
	 */
	public int deleteCategory(CategoryDTO category) throws Exception {
		// initialize result(return value)
		int result = 0;
		// Declare Base SQL
		String sql = "DELETE FROM category\n"
				+ "WHERE categoryid = ?\n";
		
		try {
			// get prepared statement and execute update transaction
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1, category.getCategoryid());
			
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
}
