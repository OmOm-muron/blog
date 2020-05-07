package blog.dao.comment;

import java.sql.PreparedStatement;

import blog.dao.RootDAO;
import blog.dto.*;

/**
 * @author Omura
 * INSERT,UPDATE,DELETE系の処理を行うDAO
 */
public class CommentTransactionDAO extends RootDAO {
	/*****************************************************************
	 * コメント関係のトランザクション
	 *****************************************************************/
	/**
	 * コメントを投稿する
	 * @param CommentDTO
	 * @return insert数
	 * @throw Exception
	 */
	public int insertComment(CommentDTO comment) throws Exception {
		// initialize result(return values)
		int result = 0;
		
		// Delcare Base SQL
		String sql = "INSERT INTO comment\n"
				+ "    (articleid, commentdate, comment)\n"
				+ "VALUES\n"
				+ "    (?, ?, ?)\n";
		
		try {
			// get prepared statement and execute insert transaction
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1, comment.getArticleid());
			statement.setTimestamp(2, comment.getCommentdate());
			statement.setString(3, comment.getComment());
			
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
	 * コメントを更新する
	 * @param CommentDTO
	 * @return update数
	 * @throw Exception
	 */
	public int updateComment(CommentDTO comment) throws Exception {
		// initialize result(return values)
		int result = 0;
		// Declare Base SQL
		String sql = "UPDATE comment\n"
				+ "SET updatedate = ?,\n"
				+ "comment = ?\n";
		
		try {
			// get prepared statement and execute update transaction
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setTimestamp(1, comment.getUpdatedate());
			statement.setString(2, comment.getComment());
			
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
	 * コメントを削除する
	 * @param CommentDTO
	 * @return delete数
	 * @throw Exception
	 */
	public int deleteComment(CommentDTO comment) throws Exception {
		// initialize result(return values)
		int result = 0;
		// Declare Base SQL
		String sql = "DELETE FROM comment\n"
				+ "WHERE commentid = ?\n";
		
		try {
			// get prepared statement and execute delete transaction
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1, comment.getCommentid());
			
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
