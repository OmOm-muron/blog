package blog.dao.comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import blog.dao.RootDAO;
import blog.dto.ArticleInformationDTO;

/**
 * @author Omura
 * 記事を複数SELECTするDAO
 */
public class SelectMultiCommentsDAO extends RootDAO {
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
		List<ArticleInformationDTO> in_list = new ArrayList<ArticleInformationDTO>();
		
		// Declare Base SQL
		String in_sql = "SELECT "
				+ "articleid, submitdate, title\n"
				+ "FROM article\n"
				+ "ORDER BY submitdate DESC\n"
				+ "LIMIT 5";
		
		try {
			// get prepared statement and execute query
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			
			ResultSet in_resultSet = in_statement.executeQuery();
			for (in_resultSet.first(); in_resultSet.next();) {
				ArticleInformationDTO in_dto = new ArticleInformationDTO();
				in_dto.setArticleid(in_resultSet.getInt("articleid"));
				in_dto.setSubmitdate(in_resultSet.getDate("submitdate"));
				in_dto.setTitle(in_resultSet.getString("title"));
				
				in_list.add(in_dto);
			}
			in_resultSet.close();
			
			return in_list;
		} catch (Exception e) {
			throw e;
		} finally {
			super.close();
		}
	}
	
	/**
	 * 月別記事取得用SQL
	 * DTOに保持する値
	 * articleid
	 * submitdate
	 * title
	 */
	public List<ArticleInformationDTO> selectArticleHeadersPerMonth(Date ex_date) throws Exception {
		// initialize return value
		List<ArticleInformationDTO> in_list = new ArrayList<ArticleInformationDTO>();
		
		// Declare Base SQL
		String in_sql = "SELECT "
				+ "articleid, submitdate, title\n"
				+ "FROM article\n"
				+ "WHERE submitdate <= ? AND submitdate >= ?\n"
				+ "ORDER BY submitdate DESC\n";
		
		try {
			// get prepared statement and execute query
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setDate(1, ex_date);
			
			ResultSet in_resultSet = in_statement.executeQuery();
			for (in_resultSet.first(); in_resultSet.next();) {
				ArticleInformationDTO in_dto = new ArticleInformationDTO();
				in_dto.setArticleid(in_resultSet.getInt("articleid"));
				in_dto.setSubmitdate(in_resultSet.getDate("submitdate"));
				in_dto.setTitle(in_resultSet.getString("title"));
				
				in_list.add(in_dto);
			}
			in_resultSet.close();
			
			return in_list;
		} catch (Exception e) {
			throw e;
		} finally {
			super.close();
		}
	}
	
	/**
	 * 記事キーワード検索用SQL
	 * DTOに保持する値
	 * articleid
	 * submitdate
	 * title
	 */
	public List<ArticleInformationDTO> selectArticleHeadersByKeyword(String ex_keyword) throws Exception {
		// initialize return value
		List<ArticleInformationDTO> in_list = new ArrayList<ArticleInformationDTO>();
		
		// Declare Base SQL
		String in_sql = "SELECT "
				+ "articleid, submitdate, title\n"
				+ "FROM article\n"
				+ "WHERE title LIKE '%?%'\n"
				+ "ORDER BY submitdate DESC\n";
		
		try {
			// get prepared statement and execute query
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setString(1, ex_keyword);
			
			ResultSet in_resultSet = in_statement.executeQuery();
			for (in_resultSet.first(); in_resultSet.next();) {
				ArticleInformationDTO in_dto = new ArticleInformationDTO();
				in_dto.setArticleid(in_resultSet.getInt("articleid"));
				in_dto.setSubmitdate(in_resultSet.getDate("submitdate"));
				in_dto.setTitle(in_resultSet.getString("title"));
				
				in_list.add(in_dto);
			}
			in_resultSet.close();
			
			return in_list;
		} catch (Exception e) {
			throw e;
		} finally {
			super.close();
		}
	}
	
	/**
	 * 記事カテゴリ検索用SQL
	 * DTOに保持する値
	 * articleid
	 * submitdate
	 * title
	 */
	public List<ArticleInformationDTO> selectArticleHeadersByKeyword(int ex_categoryid) throws Exception {
		// initialize return value
		List<ArticleInformationDTO> in_list = new ArrayList<ArticleInformationDTO>();
		
		// Declare Base SQL
		String in_sql = "SELECT "
				+ "articleid, submitdate, title\n"
				+ "FROM article\n"
				+ "WHERE categoryid = ?\n"
				+ "ORDER BY submitdate DESC\n";
		
		try {
			// get prepared statement and execute query
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setInt(1, ex_categoryid);
			
			ResultSet in_resultSet = in_statement.executeQuery();
			for (in_resultSet.first(); in_resultSet.next();) {
				ArticleInformationDTO in_dto = new ArticleInformationDTO();
				in_dto.setArticleid(in_resultSet.getInt("articleid"));
				in_dto.setSubmitdate(in_resultSet.getDate("submitdate"));
				in_dto.setTitle(in_resultSet.getString("title"));
				
				in_list.add(in_dto);
			}
			in_resultSet.close();
			
			return in_list;
		} catch (Exception e) {
			throw e;
		} finally {
			super.close();
		}
	}
}
