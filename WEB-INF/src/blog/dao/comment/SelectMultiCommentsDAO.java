package blog.dao.comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import blog.dao.RootDAO;
import blog.dto.CommentDTO;

/**
 * @author Omura
 * コメントを複数SELECTするDAO
 */
public class SelectMultiCommentsDAO extends RootDAO {
    /*****************************************************************
     * コメント複数クエリ用SQL
     *****************************************************************/
	/**
	 * コメント全件取得用SQL
	 * DTOに保持する値
	 * commentid
	 * commentdate
	 * comment
	 * updatedate
	 */
	public List<CommentDTO> selectComments(int articleid) throws Exception {
		// initialize return value
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		
		// Declare Base SQL
		String sql = "SELECT "
				+ "commentid, commentdate, comment, updatedate\n"
				+ "FROM comment\n"
				+ "WHERE articleid = ?\n"
				+ "ORDER BY updatedate DESC\n";
		
		try {
			// get prepared statement and execute query
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1, articleid);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setCommentid(resultSet.getInt("commentid"));
				dto.setCommentdate(resultSet.getTimestamp("commentdate"));
				dto.setComment(resultSet.getString("comment"));
				dto.setUpdatedate(resultSet.getTimestamp("updatedate"));
				
				list.add(dto);
			}
			resultSet.close();
			
			return list;
		} catch (Exception e) {
			throw e;
		}
	}
}
