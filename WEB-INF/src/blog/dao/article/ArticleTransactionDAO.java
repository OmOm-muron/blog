package blog.dao.article;

import java.sql.PreparedStatement;

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
	public int insertArticle(ArticleInformationDTO ex_articleInformation) throws Exception {
		// initialize result(return value)
		int in_result = 0;
		
		// declare base SQL
		String in_sql ="INSERT INTO article\n"
				+ "    (submitdate, title, category1, category2, category3, category4, category5, article)\n"
				+ "VALUES\n"
				+ "    (?, ?, ?, ?, ?, ?, ?, ?)\n";
		
		try {
			// get prepared statement and execute insert transaction
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setDate(1, ex_articleInformation.getSubmitdate());
			in_statement.setString(2, ex_articleInformation.getTitle());
			in_statement.setInt(3, ex_articleInformation.getCategory1());
			in_statement.setInt(4, ex_articleInformation.getCategory2());
			in_statement.setInt(5, ex_articleInformation.getCategory3());
			in_statement.setInt(6, ex_articleInformation.getCategory4());
			in_statement.setInt(7, ex_articleInformation.getCategory5());
			in_statement.setString(8, ex_articleInformation.getArticle());
			
			in_result = in_statement.executeUpdate();
			
			// commit
			super.commit();
		} catch (Exception e) {
			// rollback transaction and throw exception
			super.rollback();
			throw e;
		}
		
		return in_result;
	}
	
	/**
	 * 記事を更新する
	 * @param articleInformationDTO
	 * @return update数
	 * @throws Exception
	 */
	public int updateArticle(ArticleInformationDTO ex_articleInformation) throws Exception {
		// initialize result(return value)
		int in_result = 0;
		
		// Declare Base SQL
		String in_sql = "UPDATE article\n"
				+ "SET title = ?,\n"
				+ "category1 = ?,\n"
				+ "category2 = ?,\n"
				+ "category3 = ?,\n"
				+ "category4 = ?,\n"
				+ "category5 = ?,\n"
				+ "article = ?\n";
		
		try {
			// get prepared statement and execute update transaction
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setDate(1, ex_articleInformation.getUpdatedate());
			in_statement.setString(2, ex_articleInformation.getTitle());
			in_statement.setInt(3, ex_articleInformation.getCategory1());
			in_statement.setInt(4, ex_articleInformation.getCategory2());
			in_statement.setInt(5, ex_articleInformation.getCategory3());
			in_statement.setInt(6, ex_articleInformation.getCategory4());
			in_statement.setInt(7, ex_articleInformation.getCategory5());
			in_statement.setString(8, ex_articleInformation.getArticle());
			
			in_result = in_statement.executeUpdate();
			
			// commit
			super.commit();
		} catch (Exception e) {
			// rollback transaction and throw exception
			super.rollback();
			throw e;
		}
		
		return in_result;
	}
	
	/**
	 * 記事を削除する
	 * @param articleInformationDTO
	 * @return delete数
	 * @throws Exception
	 */
	public int deleteArticle(ArticleInformationDTO ex_articleInformation) throws Exception {
		// initialize result(return values)
		int in_result = 0;
		
		// Declare Base SQL for comments
		String in_sql_comments = "DELETE FROM comment\n"
				+ "WHERE articleid = ?\n";
		// Declare Base SQL for article
		String in_sql_article = "DELETE FROM article\n"
				+ "WHERE articleid = ?\n";
		
		try {
			// get prepared statement and execute delete comments transaction
			PreparedStatement in_statement_comments = getPreparedStatement(in_sql_comments);
			in_statement_comments.setInt(1, ex_articleInformation.getArticleid());
			
			in_result += in_statement_comments.executeUpdate();
			
			// get prepared statement and execute delete article transaction
			PreparedStatement in_statement_article = getPreparedStatement(in_sql_article);
			in_statement_article.setInt(1, ex_articleInformation.getArticleid());
			
			in_result += in_statement_article.executeUpdate();
			
			//commit
			super.commit();
		} catch (Exception e) {
			// rollback transaction and throw exception
			super.rollback();
			throw e;
		}
		
		return in_result;
	}

	/*****************************************************************
	 * コメント関係のトランザクション
	 *****************************************************************/
	/**
	 * コメントを投稿する
	 * @param CommentDTO
	 * @return insert数
	 * @throw Exception
	 */
	public int insertComment(CommentDTO ex_comment) throws Exception {
		// initialize result(return values)
		int in_result = 0;
		
		// Delcare Base SQL
		String in_sql = "INSERT INTO comment\n"
				+ "    (articleid, commentdate, comment)\n"
				+ "VALUES\n"
				+ "    (?, ?, ?)\n";
		
		try {
			// get prepared statement and execute insert transaction
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setInt(1, ex_comment.getArticleid());
			in_statement.setDate(2, ex_comment.getCommentdate());
			in_statement.setString(3, ex_comment.getComment());
			
			in_result = in_statement.executeUpdate();
			
			// commit
			super.commit();
		} catch (Exception e) {
			// rollback transaction and throw exception
			super.rollback();
			throw e;
		}
		
		return in_result;
	}
	
	/**
	 * コメントを更新する
	 * @param CommentDTO
	 * @return update数
	 * @throw Exception
	 */
	public int updateComment(CommentDTO ex_comment) throws Exception {
		// initialize result(return values)
		int in_result = 0;
		// Declare Base SQL
		String in_sql = "UPDATE comment\n"
				+ "SET updatedate = ?,\n"
				+ "comment = ?\n";
		
		try {
			// get prepared statement and execute update transaction
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setDate(1, ex_comment.getUpdatedate());
			in_statement.setString(2, ex_comment.getComment());
			
			in_result = in_statement.executeUpdate();
			
			// commit
			super.commit();
		} catch (Exception e) {
			// rollback transaction and throw exception
			super.rollback();
			throw e;
		}
		
		return in_result;
	}
	
	/**
	 * コメントを削除する
	 * @param CommentDTO
	 * @return delete数
	 * @throw Exception
	 */
	public int deleteComment(CommentDTO ex_comment) throws Exception {
		// initialize result(return values)
		int in_result = 0;
		// Declare Base SQL
		String in_sql = "DELETE FROM comment\n"
				+ "WHERE commentid = ?\n";
		
		try {
			// get prepared statement and execute delete transaction
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setInt(1, ex_comment.getCommentid());
			
			in_result = in_statement.executeUpdate();
			
			// commit
			super.commit();
		} catch (Exception e) {
			// rollback transaction and throw exception
			super.rollback();
			throw e;
		}
		
		return in_result;
	}
	
	/*****************************************************************
	 * カテゴリ関係のトランザクション
	 *****************************************************************/
	/**
	 * カテゴリを作成する
	 * @param CategoryDTO
	 * @return insert数
	 * @throw Exception
	 */
	public int insertCategory(CategoryDTO ex_category) throws Exception {
		// initialize result(return values)
		int in_result = 0;
		// Declare Base SQL
		String in_sql = "INSERT INTO category\n"
				+ "    (categoryname)\n"
				+ "VALUES\n"
				+ "    (?)\n";
		
		try {
			// get prepared statement and execute insert transaction
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setString(1, ex_category.getCategoryname());
			
			in_result = in_statement.executeUpdate();
			
			// commit
			super.commit();
		} catch (Exception e) {
			// rollback transaction and throw exception
			super.rollback();
			throw e;
		}
		
		return in_result;
	}
	
	/**
	 * カテゴリを更新する
	 * @param CategoryDTO
	 * @return update数
	 * @throw Exception
	 */
	public int updateCategory(CategoryDTO ex_category) throws Exception {
		// initialize result(return value)
		int in_result = 0;
		// Daclare Base SQL
		String in_sql = "UPDATE category\n"
				+ "SET categoryname = ?\n"
				+ "WHERE categoryid = ?\n";
		
		try {
			// get prepared statement and execute update transaction
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setString(1, ex_category.getCategoryname());
			in_statement.setInt(2, ex_category.getCategoryid());
			
			in_result = in_statement.executeUpdate();
			
			// commit
			super.commit();
		} catch (Exception e) {
			// rollback transaction and throw exception
			super.rollback();
			throw e;
		}
		
		return in_result;
	}
	
	/**
	 * カテゴリを削除する
	 * @param CategoryDTO
	 * @return delete数
	 * @throw Exception
	 */
	public int deleteCategory(CategoryDTO ex_category) throws Exception {
		// initialize result(return value)
		int in_result = 0;
		// Declare Base SQL
		String in_sql = "DELETE FROM category\n"
				+ "WHERE categoryid = ?\n";
		
		try {
			// get prepared statement and execute update transaction
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setInt(1, ex_category.getCategoryid());
			
			in_result = in_statement.executeUpdate();
			
			// commit
			super.commit();
		} catch (Exception e) {
			// rollback transaction and throw exception
			super.rollback();
			throw e;
		}
		
		return in_result;
	}
}
