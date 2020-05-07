package blog.dao.comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import blog.dao.RootDAO;
import blog.dto.CommentDTO;

/**
 * @author Omura
 * 一件のデータを取得するDAO
 */
public class SelectOneCommentDAO extends RootDAO {
	/*****************************************************************
	 * コメント関係のクエリ
	 *****************************************************************/
	public CommentDTO selectComment(int commentid) throws Exception {
		// initialize return value
		CommentDTO dto = new CommentDTO();
		
		// declare base SQL
		String sql = "SELECT "
				+ "commentid, articleid, commentdate, "
				+ "comment, updatedate\n"
				+ "FROM comment\n"
				+ "WHERE commentid = ?";
		
		try {
			// get prepared statement and execute query
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1, commentid);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				// set SQL Result to return value
				dto.setCommentid(resultSet.getInt("commentid"));
				dto.setArticleid(resultSet.getInt("articleid"));
				dto.setCommentdate(resultSet.getTimestamp("commentdate"));
				dto.setComment(resultSet.getString("comment"));
				dto.setUpdatedate(resultSet.getTimestamp("updatedate"));
			}
			
			if (!dto.isValid()) {
				// when invalid comment information
				throw new Exception("Comment Information is invalid.\n");
			}
			return dto;
		} catch (Exception e) {
			throw e;
		}
	}
}
